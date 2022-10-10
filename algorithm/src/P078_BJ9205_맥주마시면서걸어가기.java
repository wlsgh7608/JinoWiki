package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P078_BJ9205_맥주마시면서걸어가기 {
	static class Conv {
		int x;
		int y;

		public Conv(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Conv [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < TC; t++) {
			int n = Integer.parseInt(br.readLine());
			Conv[] conv = new Conv[n + 2];
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				conv[i] = new Conv(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			boolean[] visited = new boolean[n + 2];
			Queue<Integer> Q = new ArrayDeque<>();
			Q.add(0);
			visited[0] = true; // 시작점 방문표시
			String result = "sad"; // 결과값 초기화

			while (!Q.isEmpty()) {
				int v = Q.poll();
				if (v == n + 1) { // 끝에 도달하였다면
					result = "happy"; // 결과값 변경
				}
				int x = conv[v].x; // 현재 x
				int y = conv[v].y; // 현재 y

				for (int i = 0; i < n + 2; i++) {
					if (visited[i]) { // 방문한 곳이라면 continue
						continue;
					}
					Conv next = conv[i];
					if (Math.abs(x - next.x) + Math.abs(y - next.y) <= 1000) { // 최대 1000의거리까지만 이동가능
						Q.add(i); // 이동가능하다면 큐에 넣고
						visited[i] = true; // 방문표시
					}
				}

			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}

}
