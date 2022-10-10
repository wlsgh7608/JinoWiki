package 공진호;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P064_BJ1463_1로만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		Arrays.fill(dp, 1000000);
		dp[1] = 0;
		for(int i = 2;i<=N;i++) {
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
			dp[i] = Math.min(dp[i-1]+1, dp[i]);
		}
		System.out.println(dp[N]);
	}

}
