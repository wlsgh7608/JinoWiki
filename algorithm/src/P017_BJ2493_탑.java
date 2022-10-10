package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P017_BJ2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Integer> S = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] arr = new int[n];
		
		int[] answer = new int [n];
		for (int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(inputs[i]); // 입력값 저장
		}
		
		/*
		 * 배열의 끝에서부터 반복문을 돌림
		 * 만약 현재 배열이 스택의 top보다 작으면 스택에 추가 
		 * 클 경우 , 스택에서 pop한 후 값 저장
		 */
		
		
		int p = n-1;
		for (int i =n-1;i>=0;i--){ // 마지막 인덱스부터 시작하여 첫번째 인덱스로 반복
			if (S.isEmpty()) { // 스택이 비어있다면
				S.add(i); // add
			}
			else {
				while(!S.isEmpty() && arr[S.peek()] < arr[i])  // arr[i] 값이 현재 스택의 top보다 크다면 
				{
					answer[S.pop()]= i+1; // 결과값 저장 
				}
				S.add(i); // 스택에 추가
			}
		}
		
		while (S.size()>0) { // 남아있는 스택은  어떤 탑에도 수신 못함 ( 결과값 0)
			answer[S.pop()] = 0;
		}
		
		
		for (int i = 0;i<n;i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
		
		
		
		
		
		
	
		

	}

}
