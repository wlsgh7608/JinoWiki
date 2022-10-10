package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;


public class P059_SWEA1251_하나로_프림인접행렬 {
	static class Node implements Comparable<Node> { // 오름차순
		int no;
		long weight;

		public Node(int no, long weight) {
			this.no = no; // 입력받을 것으로 설정
			this.weight = weight;// 입력받을 것으로 설정
		}

		@Override
		public int compareTo(Node o) { // 길이를 오름차순으로 정렬
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t < TC + 1; t++) { // TC 개수만큼 반복
			int N = Integer.parseInt(br.readLine());

			String[] input = br.readLine().split(" ");
			int[] x = new int[N]; // x 저장용 배열
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(input[i]);
			}
			input = br.readLine().split(" ");
			int[] y = new int[N]; // y 저장용 배열
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(input[i]);
			}

			double tax = Double.parseDouble(br.readLine()); // 세금

			long[][] dist = new long[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long lenx = x[i] - x[j]; // 두 지점간의 x차이
					long leny = y[i] - y[j]; // 두 지점간의 y차이
					long distance = (lenx * lenx) + (leny * leny); // 거리구하기
					dist[i][j] = distance;
					// 리스트의 i번째에 j까지의 거리를 넣음
				}
			} // 연결 거리 표시

			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N]; // 방문 표시할 배열
			long total = 0; // 총 합
			int count = 0; // 개수

			long[] minDist = new long[N]; // 해당 노드로 갈 수 있는 최소 거리
			Arrays.fill(minDist, Long.MAX_VALUE); // 최대값으로 초기화 
			minDist[0] = 0; // 시작점 0으로 초기화 
			for (int i = 0; i < N; i++) {
				long min = Long.MAX_VALUE; // 최대값을 초기화
				int minVertex = -1; // 이동할 수 있는 최소 거리의 정점
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minDist[j]) { // 방문하지 않은 노드들중 현재의 min값보다 작은 경우
						min = minDist[j]; // min값 업데이트
						minVertex = j; // 최소 정점 저장
					}
				}
				visited[minVertex] = true; //방문 표시
				total += minDist[minVertex]; // 총합 더하기

				for (int j = 0; j < N; j++) {
					if (!visited[j]) { //방문하지 않은 노드들에 대하여
						minDist[j] = Math.min(minDist[j], dist[minVertex][j]); // 현재의 최소 거리 업데이트
					}
				}

			}

			bw.write("#" + t + " " + Math.round(total * tax) + "\n"); // 최종거리에 세금 곱해서 결과 출력
		} // testcase end

		bw.flush();
		bw.close();

	}

}
