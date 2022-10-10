package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P027_BJ1010_다리놓기 {
	static int N; // 왼쪽 다리 수
	static int M; // 오른쪽 다리 수
	static int[][] result;
	
	
	static void init() {
		for(int i = 1;i<=M;i++) {
			for (int j =1; j<=N+1;j++) {
				result[i][j] = result[i-1][j] + result[i-1][j-1]; // nCr = n-1Cr-1 + n-1Cr
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			result = new int[M+1][N+2]; // 조합 결과를 저장 
			result[0][1] = 1; //초기값 설정
			init();
			sb.append(result[M][N+1]).append("\n");
		}
		System.out.println(sb);
	}

}
