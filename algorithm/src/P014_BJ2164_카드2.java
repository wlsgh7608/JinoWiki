package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P014_BJ2164_카드2 {
	
	public static void main(String[] args) throws Exception {
		//
		Queue<Integer> Q = new LinkedList<>(); // 큐 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // n 입력
		// 큐에 숫자 하나씩 add
		for(int i = 1; i<=N;i++) {
			Q.add(i); 
		}
		
		
		// 큐의 크기가 1개가 될 때 까지 반복
		while (Q.size()>1) {
			Q.remove(); // 맨 위에꺼 버리고
			Q.add(Q.remove()); // 다음 꺼는 빼서 맨 아래에 삽입
		}
		System.out.println(Q.remove()); // 출력
	}

}
