package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P066_BJ17070_파이프옮기기1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] G = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][3]; // 가로,세로,대각선
		dp[1][2][0] = 1;
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				
				if((i==1 && j==1) ||(i==1&&j==2)) {
					continue;
				}
				if (G[i][j] == 0) {

					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]; // 세로

					if (G[i][j - 1] == 0 && G[i - 1][j] == 0)
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]; // 대각선
				}
			}

		}

		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += dp[N][N][i];
		}
		System.out.println(result);

	}

}
