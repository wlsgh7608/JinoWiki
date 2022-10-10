package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class P033_BJ11286_절댓값힙 {
	static PriorityQueue<Integer> pq;
	static HashMap<Integer, Integer> hash = new HashMap<>();// 절대값 , 음수count
	static List<Integer> ans = new ArrayList<>();
	
	public static void cal() {
		int cur = pq.peek(); //절대값 최소값
		if (hash.containsKey(cur) && hash.get(cur) > 0) // 해시에 값이 있고 음수 개수가 남아 있을 때
		{
			hash.put(cur, hash.get(cur) - 1); // 음수 개수 하나 빼기
			ans.add(-1 * pq.poll()); // 음수로 출력
		} else {
			ans.add(pq.poll()); // 양수로 출력
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if(pq.isEmpty()) { //큐에 아무것도 존재하지 않으면
					ans.add(0); // 답에 0추가 
					continue;
				}
				cal(); //cal 함수 호출
			} else if (input < 0) { // 음수일 때
				if (hash.containsKey(Math.abs(input))) { // 키가 이미 있으면
					hash.put(Math.abs(input), hash.get(Math.abs(input)) + 1);
				} else { // 키가 없으면
					hash.put(Math.abs(input), 1); // 절대값 , count
				}
				pq.add(Math.abs(input));
			} else { // 양수 일 때
				pq.add(input);
			}
		} // end for
		
		for(int i = 0; i<ans.size();i++) {
			bw.write(ans.get(i)+"\n"); //결과 출력
		}
		bw.flush();
		bw.close();

	}

}
