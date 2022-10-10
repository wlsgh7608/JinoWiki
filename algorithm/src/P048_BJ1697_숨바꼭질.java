package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P048_BJ1697_숨바꼭질 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int cur = 0;
		int cnt = 0;
		boolean[] road = new boolean[100_001];
		Queue<Integer> queue = new LinkedList<>(); // 값을 저장하기 위한 큐
		Queue<Integer> count = new LinkedList<>(); // 연산횟수를 위한 큐
		queue.add(N);
		count.add(0);
		road[N] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			cnt = count.poll();
			if(cur== K ) { //목표값에 도달할경우
				break; //반복문을 빠져나옴
			}
			
			if(cur-1>=0 && !road[cur-1]) { // 1뺀 값 넣기
				queue.add(cur-1);
				count.add(cnt+1);
				road[cur-1] = true;// 방문표시
			}
			if(cur+1<=100000 && !road[cur+1]) { //1 더한 값 넣기
				queue.add(cur+1);
				count.add(cnt+1);
				road[cur+1] = true;// 방문표시
			}
			if(cur*2 <=100000 && !road[cur*2]) { //2 곱한 값 넣기 
				queue.add(cur*2);
				count.add(cnt+1);
				road[cur*2] = true; // 방문표시
			}
		}
		System.out.println(cnt); // 연산 횟수 반환
	}

}
