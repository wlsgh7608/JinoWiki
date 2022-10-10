package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P075_BJ2636_치즈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] G = new int[N][M];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int total = 0;
		int cnt = 0;
		int time = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
				if (G[i][j] == 1) {
					total++;
				}
			}
		}
		while (total > 0) {
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> Q = new ArrayDeque<>();
			Q.add(new int[] { 0, 0 });
			visited[0][0] = true;
			cnt = 0;
			while (!Q.isEmpty()) {
				int[] cur = Q.poll();
				int x = cur[0];
				int y = cur[1];
				for (int i = 0; i < 4; i++) { //4방향 탐색
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
						continue;
					}
					visited[nx][ny] = true; //방문표시
					if (G[nx][ny] == 0) { // 공기의 경우 큐에 추가
						Q.add(new int[] { nx, ny });
					} else { //1인 경우 개수 추가
						cnt++; 
						G[nx][ny] = 0;
					}

				}
			}

			total -= cnt; // 총 치즈값 갱신
			time++;
		}
		System.out.println(time); 
		System.out.println(cnt);

	}

}
