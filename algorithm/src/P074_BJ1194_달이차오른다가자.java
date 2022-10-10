package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P074_BJ1194_달이차오른다가자 {
	static class Point {
		int x;
		int y;
		int cnt;
		int keys;

		public Point(int x, int y, int cnt, int keys) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.keys = keys;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		char[][] G = new char[N][M];
		boolean[][][] visited = new boolean[N][M][64];
		// x,y 열쇠?
		Queue<Point> Q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				G[i][j] = row.charAt(j);
				if (G[i][j] == '0') {
					Q.add(new Point(i, j, 0, 0));
				}
			}
		}
		int result = -1;

		
		// BFS 실행
		while (!Q.isEmpty()) {  
			Point cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int keys = cur.keys;
			if (G[x][y] == '1') { // 출구에 왔다면
				result = cnt; // result 값 변경
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || G[nx][ny] == '#') { // 갈 수 없는 경우
					continue;
				}
				int newKeys = keys;
				if (!Character.isUpperCase(G[nx][ny])) { // 대문자(문)이 아닌 경우
					if (!visited[nx][ny][keys]) { //방문하지 않았다면

						visited[nx][ny][keys] = true; //방문표시

						if (Character.isLowerCase(G[nx][ny])) { // 소문자(열쇠) 라면
							int idx = G[nx][ny] - 'a'; // 열쇠 인덱스
							newKeys = keys | 1 << idx; // 해당 비트 추가 
						}
						Q.add(new Point(nx, ny, cnt + 1, newKeys));
					}

				} else { // 대문자인 경우 소문자가 있어야 함.
					if (!visited[nx][ny][keys]) { // 방문하지 않았다면
						visited[nx][ny][keys] = true; //방문표시
						int idx = G[nx][ny] + 32 - 'a'; // 열쇠의 idx
						if ((keys & 1 << idx) != 0) { //열쇠가 존재한다면
							Q.add(new Point(nx, ny, cnt + 1, newKeys));
						}
					}
				}

			}

		} // end while
		System.out.println(result);

	}

}
