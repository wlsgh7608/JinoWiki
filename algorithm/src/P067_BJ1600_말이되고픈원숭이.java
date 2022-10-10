package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P067_BJ1600_말이되고픈원숭이 {
	static class Monkey{
		int x;
		int y;
		int cnt;
		int jump;

		public Monkey(int x, int y, int cnt, int jump) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
		}

		@Override
		public String toString() {
			return "Monkey [x=" + x + ", y=" + y + ", cnt=" + cnt + ", jump=" + jump + "]";
		}
		
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] G = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] jumpCnt = new int[H][W];
		int[][] monkeyCnt = new int[H][W];
		for (int[] row : jumpCnt) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		for(int[] row: monkeyCnt) {
			Arrays.fill(row, 0);
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int[] knightDx = { -2, -2, 2, 2, -1, -1, 1, 1 };
		int[] knightDy = { 1, -1, -1, 1, 2, -2, 2, -2 };

		Queue<Monkey> Q = new ArrayDeque<>();
		int result = -1;
		jumpCnt[0][0] = 0;
		monkeyCnt[0][0] = K;
		Q.add(new Monkey(0, 0, 0, K));
		while (!Q.isEmpty()) {
			Monkey cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int jump = cur.jump;
			if (x == H - 1 && y == W - 1) {
				result = cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || G[nx][ny] == 1) {
					continue;
				}
				if (jumpCnt[nx][ny] > cnt + 1) {
					jumpCnt[nx][ny] = cnt + 1;
					monkeyCnt[nx][ny]  = jump;
					Q.add(new Monkey(nx, ny, cnt + 1, jump));
				}else if(monkeyCnt[nx][ny] < jump) {  //cnt은 적으나 jump 횟수가 더 많은 경우 큐에 추가
					monkeyCnt[nx][ny]  = jump;
					Q.add(new Monkey(nx, ny, cnt + 1, jump));
					
				}
			}

			if (jump > 0) { // 원숭이 점프가 가능한 경우
				for (int i = 0; i < 8; i++) {

					int nx = x + knightDx[i];
					int ny = y + knightDy[i];

					if (nx < 0 || nx >= H || ny < 0 || ny >= W || G[nx][ny] == 1) {
						continue;
					}
					if (jumpCnt[nx][ny] > cnt + 1) {
						jumpCnt[nx][ny] = cnt + 1;
						monkeyCnt[nx][ny] = jump-1;
						Q.add(new Monkey(nx, ny, cnt + 1, jump - 1));
					}else if(monkeyCnt[nx][ny] < jump-1) { //cnt은 적으나 jump 횟수가 더 많은 경우 큐에 추가
						monkeyCnt[nx][ny]  = jump-1;
						Q.add(new Monkey(nx, ny, cnt + 1, jump-1));
						
					}

				}
			}

		} // end while
		System.out.println(result);

	}
	

}


 