package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P016_BJ2023_신기한소수 {
	static int totalCnt;
	static int n_target;
	static List<Integer> answer = new ArrayList<>(); // 정답 담을 리스트
	
	static boolean isPrime(int n) { // 소수 판별
		if (n<2) return false; // 2보다 작을 시 소수아님
		int sqrt = (int)Math.sqrt(n); // 제곱근까지 for문 돌림
		for (int i = 2; i<=sqrt;i++) { 
			if (n%i == 0) return false; // 나누어떨어지면 소수가아님
		}
		return true;
	}
	
	static void combination(int depth,int start,int n) { // 중복조합 
		if (depth ==n_target) { //깊이가  n_target자리와 맞다면 
			answer.add(n); //리스트에 추가 
			return;
		}
		
		for (int i=start ; i<=9 ; i++) {
			int new_n = n*10+i; // 다음 수 판별 
			if (isPrime(new_n)){ // 소수라면
				combination(depth+1,start,new_n); // 재귀
			}
		}
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n_target = Integer.parseInt(br.readLine());
		combination(0,0,0);
		
		for(int n : answer) {
			sb.append(n+"\n");
		}
		System.out.println(sb);
		
		
		
		
		
	}

}
