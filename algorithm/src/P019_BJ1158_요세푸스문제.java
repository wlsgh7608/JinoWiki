package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P019_BJ1158_요세푸스문제 {
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> Q = new LinkedList<>();
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		// Q 에 삽입
		for(int i = 1; i<=N; i++) {
			Q.add(i);
		}
		sb.append("<");
		while (Q.size()>0) {
			for (int c = 1; c<M;c++) {
				Q.add(Q.poll()); // M이 될때까지 맨앞에서 빼서 맨뒤에 붙임
			}
			if (Q.size()>1) {
				sb.append(Q.poll()+", "); //Q의 크기가 2이상인 경우  sb에 pop한 값과 , 을 붙임 
			}else {
				sb.append(Q.poll()); // Q의 크기가 하나인 경우는 pop한 값만  append
			}
			
		}
		sb.append(">"); 
		
		System.out.println(sb);
	}

}
