package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> Q = new LinkedList<>(); // 큐 
		StringBuffer sb = new StringBuffer();
		
		
		for (int test_case = 1;test_case<=10;test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] inputs = br.readLine().split(" ");
			for (int i = 0; i<inputs.length;i++) {
				Q.add(Integer.parseInt(inputs[i])); // 입력받은 것을 차례대로 큐에 삽입
			}
			
			int cycle_n = 0; // 사이클 
			while (true) {
				int current = Q.poll();
				cycle_n = (cycle_n%5)+1; // 나누기 연산을 통하여 5,4,3,2,1 ,5,4,3,2,1 반복
				current = Math.max(current-cycle_n, 0); // 연산값이 음수일 경우 0으로 할당
				Q.add(current);
				if (current == 0) { // 0일 경우   출력후 반복문 끝
					sb.append("#"+test_case+" ");
					for (int i = 0; i<8;i++) {
						sb.append(Q.poll() +" ");
					}
					sb.append("\n");
					break;
				}
			}
			
			
		}
		System.out.println(sb);

	}

}
