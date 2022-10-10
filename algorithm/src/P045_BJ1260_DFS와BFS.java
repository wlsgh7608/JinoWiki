package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P045_BJ1260_DFS와BFS {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> graph; // 인접리스트 생성
	static boolean[] went;

	public static void DFS(int v) {
		went[v] = true; // 방문 표시
		System.out.print(v + " ");
		for (Integer a : graph.get(v)) { // 인접노드에 대하여
			if (!went[a]) { // 방문하지 않았다면
				DFS(a);
			}
		}

	}

	public static void BFS(int v) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N + 1]; // 방문 초기화
		que.add(v);
		visited[v] = true; // 첫번째 노드 방문 표시
		int cur;

		while (!que.isEmpty()) { // 큐가 비어있지 않을 때까지 반복
			cur = que.poll(); // 현재 노드
			System.out.print(cur + " ");

			for (Integer a : graph.get(cur)) { // 노드의 인접한 노드들에 대하여
				if (!visited[a]) { // 방문하지 않았다면
					visited[a] = true; // 방문표시
					que.add(a); // 큐에 추가
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		int start;
		int end;
		went = new boolean[N + 1];

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			start = Integer.parseInt(input[0]);
			end = Integer.parseInt(input[1]);

			graph.get(start).add(end); // 인접리스트에 노드 추가
			graph.get(end).add(start); // 양방향이므로 반대도 추가
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph.get(i));
		} // 오름차순 정렬
		DFS(V);
		System.out.println();
		BFS(V);

	}

}
