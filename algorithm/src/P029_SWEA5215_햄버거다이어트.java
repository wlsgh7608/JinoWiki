package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P029_SWEA5215_햄버거다이어트 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case =  1; test_case<= T;test_case++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int L = Integer.parseInt(input[1]);
			int[] dp = new int [L+1];
			int[] taste =new int[N]; // 맛 저장
			int[] cal = new int[N]; // 칼로리 저장
			
			for (int i = 0; i<N;i++) {
				input = br.readLine().split(" ");
				taste[i] = Integer.parseInt(input[0]);
				cal[i] = Integer.parseInt(input[1]);
			}
			
			for(int i =0 ;i<N;i++) {
				for(int j = L;j>=cal[i];j--) { // L부터 시작해서 해당음식 cal까지 내려가면서 반복
					dp[j] = dp[j-cal[i]] +taste[i]> dp[j] ? dp[j-cal[i]] +taste[i] : dp[j];  // 큰 값(맛)으로 할당
				}
			}
			
			
			sb.append("#"+test_case+" "+dp[L]).append("\n");
			
		}
		System.out.println(sb);
		
	}

}
