package 공진호;

import java.util.Scanner;

public class P035_BJ2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[5001];
		dp[3] = 1; // 초기화
		dp[5] = 1; // 초기화
		for(int i = 6;i<=N;i++) {
			int minus3 = dp[i-3]; // i-3번쨰 값
			int minus5 = dp[i-5]; // i-5번째 값
			if (minus3 !=0 && minus5!=0) { // 둘다 0이 아닌 경우
				dp[i] = Math.min(minus3, minus5)+1; // 둘 중 작은 값 +1
			}
			else if(minus3 == 0 && minus5==0) { // 만약 둘 다 0이라면 
				dp[i] = 0; // 0으로 
			}
			else if(minus3 ==0) { // i-3가 만들수 없는 경우라면 
				dp[i] = minus5+1;
			} else if(minus5 == 0) { //i-5가 만들 수 없는 경우라면
				dp[i] = minus3+1;
			}
		}
		if (dp[N] == 0) { // 만들 수 없는 경우라면 
			System.out.println(-1); // -1 출력 
		}else {
			System.out.println(dp[N]);
		}
		
		

	}

}
