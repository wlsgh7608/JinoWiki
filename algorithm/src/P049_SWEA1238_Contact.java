package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P049_SWEA1238_Contact {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int start = Integer.parseInt(input[1]);
			boolean[] visited = new boolean[N + 1];
			List<Integer> list[] = new ArrayList[N + 1]; // 인접 리스트를 담는 배열 생성
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			} // 인접리스트 생성
			input = br.readLine().split(" "); 
			int p = 0;
			while (p < N) {
				int from = Integer.parseInt(input[p++]); // 시작점
				int to = Integer.parseInt(input[p++]); //도착점
				list[from].add(to); //인접리스트에 추가
			}

			Queue<Integer> Q = new ArrayDeque<>();
			Q.add(start);
			visited[start] = true;
			int max_n = start;
			while (!Q.isEmpty()) {
				max_n = 0;
				int depth = Q.size();
				while (depth-- > 0) { // 현재 깊이의 수만큼 반복
					int current = Q.poll(); // poll한 값
					max_n = current > max_n ? current : max_n; // 최대값으로 할당
					for (int next : list[current]) { // 이동할 수 있는 노드들에 대하여
						if (!visited[next]) { // 방문하지 않았다면
							Q.add(next); // 큐에 추가
							visited[next] = true; //방문 표시
						}
					}

				}
			}
			sb.append("#" + t + " " + max_n).append("\n"); //결과 출력
		}
		System.out.println(sb);

	}

}
