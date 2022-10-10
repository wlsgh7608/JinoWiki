package 공진호;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P065_BJ1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[3];
		
		for (int i = 1; i < N + 1; i++) {
			int[] arr = new int[3];
			int[] newDp = new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			newDp[0] = Math.min(dp[1],dp[2])+arr[0];
			newDp[1] = Math.min(dp[0],dp[2])+arr[1];
			newDp[2] = Math.min(dp[0],dp[1])+arr[2];
			dp = newDp;
		}

		int minV = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			minV = Math.min(minV, dp[i]);
		}
		System.out.println(minV);

	}
}
