package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P009_BJ11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); // 버퍼드리더를 통하여 입력을 빠르게
		StringBuilder sb = new StringBuilder(); // Stringbuilder을 통하여 출력을 빠르게
		
		
		String[] inputs = br.readLine().split(" "); // 공백으로 n,m을 나누기
		int N = Integer.parseInt(inputs[0]); // N값 저장  
		int M = Integer.parseInt(inputs[1]);// M값 저장
		
		int[] arr = new int[N]; // 입력받을 arr 배열
		int[] dp  = new int[N+1]; // prefix_sum 저장
		inputs = br.readLine().split(" "); // 입력받을 arr을 공백으로 나누기 
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(inputs[i]); //arr[i]에 나눈 값을 정수형으로 저장 
			dp[i+1] = dp[i]+arr[i]; // 현재까지의 합을 dp[i+1]에 저장
			
		}
		
		for (int i =0;i<M;i++) {
			int start,end; // 구간의 시작,끝
			inputs = br.readLine().split(" "); // 공백으로 나누기
			start = Integer.parseInt(inputs[0]); // 시작값
			end = Integer.parseInt(inputs[1]); // 끝값
			sb.append(dp[end]-dp[start-1]).append("\n"); // end까지의 합  - (start-1)까지의 합
		}
		System.out.println(sb); // 출력
		
		
		

	}

}
