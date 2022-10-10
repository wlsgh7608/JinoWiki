package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P057_BJ10026_적록색약 {
	static char[][] map;
	static boolean[][] visited; 
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs(int x, int y) {
		Queue<int[]> Q = new ArrayDeque<>();

		Q.add(new int[] { x, y }); //x,y 큐에 추가
		visited[x][y] = true; //방문표시
		while (!Q.isEmpty()) { //큐가 비어때까지 반복
			int[] current = Q.poll(); //큐에서 하나 빼기
			for (int i = 0; i < 4; i++) { // 4방향에 대하여
				int nx = current[0] + dx[i]; //이동할 x위치
				int ny = current[1] + dy[i]; //이동할 y위치
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {//범위내에 있고, 방문하지 않았다면
					if (map[x][y] == map[nx][ny]) { // 색상이 동일하다면
						Q.add(new int[] { nx, ny }); // 큐에추가
						visited[nx][ny] = true; //방문표시
					}

				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		/* 입력  */

		// 적록색약X 사람
		int cnt = 0; // 카운트 0으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) { //방문하지 않았으면
					bfs(i,j); // bfs 실행
					cnt++; 
				}
			}
		}
		// 적록색약인 사람은 R,G 구별을 할 수 없기 때문에 하나의 색상으로 변경
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') { // 초록색을 빨간색으로 변경
					map[i][j] = 'R';
				}
			}
		}
		int rg_cnt = 0; // 카운트 0으로 초기화
		// 적록색약인 사람
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) { //방문하지 않았으면
					bfs(i,j); //bfs 실행
					rg_cnt++; 
				}
			}
		}
		System.out.println(cnt+" "+rg_cnt);

	}

}
