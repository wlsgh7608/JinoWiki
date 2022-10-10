package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P010_BJ11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		String[] inputs = br.readLine().split(" "); // 공백을 기준으로 나눔
		int N = Integer.parseInt(inputs[0]); //첫 번째 인수
		int M = Integer.parseInt(inputs[1]); //두 번째 인수
		int[][] G = new int[N][N]; // NxN 배열 생성
		int[][] dp = new int[N+1][N+1];
		for(int i = 0; i<N;i++) {
			inputs = br.readLine().split(" "); // 공백을 기준으로 나누
			for(int j =0;j<inputs.length;j++) {
				G[i][j] = Integer.parseInt(inputs[j]);
				dp[i+1][j+1] = dp[i][j+1]+dp[i+1][j]-dp[i][j]+G[i][j]; // (0,0) ~ (i,j) 구간 합
			}
		}
		
		for(int i = 0;i<M;i++){
			inputs = br.readLine().split(" ");
			int x1 = Integer.parseInt(inputs[0]); 
			int y1 = Integer.parseInt(inputs[1]);
			int x2 = Integer.parseInt(inputs[2]);
			int y2 = Integer.parseInt(inputs[3]);
			int answer = dp[x2][y2] - dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];  // (x1,y1) ~ (x2,y2) 구간 합
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
		
		

	}

}
