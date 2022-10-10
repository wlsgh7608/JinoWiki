package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P011_SWEA2001_파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 한 번에 받기
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		StringBuilder sb = new StringBuilder(); // 출력 한번에 하기
		
		for(int test_case =1;test_case<=T;test_case++) {
			
			String[] inputs = br.readLine().split(" ");
			int N = Integer.parseInt(inputs[0]);
			int M = Integer.parseInt(inputs[1]);
			int[][] G = new int[N][N];
			int[][] dp = new int[N+1][N+1]; // 계산을 편하게 하기 위하여 (N+1)x(N+1)
			for ( int i = 0 ;i <N;i++) {
				inputs = br.readLine().split(" ");
				for (int j = 0; j<N;j++){
					G[i][j] = Integer.parseInt(inputs[j]); // 
				}
			}
			
			
			for (int i = 0;i<N;i++) {
				for (int j = 0;j<N;j++){
					dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + G[i][j]; // 누적합 구하기
				}
			}
			
			
			int max_fly = 0;
			for (int i =0;i<=N-M;i++) {
				for (int j = 0; j<=N-M;j++) {
					max_fly = Math.max(dp[i+M][j+M]-dp[i][j+M]-dp[i+M][j]+dp[i][j], max_fly); // MxM 크기의 구간합 구하기
				}
			}
			
			sb.append("#"+test_case+" "+max_fly).append("\n");
			
		}
		System.out.println(sb);
		

	}

}
