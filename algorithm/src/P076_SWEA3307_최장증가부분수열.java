package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P076_SWEA3307_최장증가부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.fill(dp, 1); // 일단 자기자신은 LIS 가능
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) { 
					if (arr[i] > arr[j] && dp[i] < dp[j] + 1) { // j의 값이 i보다 작고 j의 LIS값이 i의 LIS값보다 같거나 큰 경우 
						dp[i] = dp[j] + 1; // 업데이트
					}
				}
			}
			int max = 0; // dp의 값은 i번째를 포함한 LIS이므로 각각의 LIS 중 최대값 찾기
			for(int n:dp) {
				max = Math.max(max, n); // LIS 최대값 찾기
			}
			sb.append("#"+t+" "+max).append("\n");
		}
		System.out.println(sb);
	}

}
