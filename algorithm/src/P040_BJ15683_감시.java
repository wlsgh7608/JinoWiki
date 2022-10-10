package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P040_BJ15683_감시 {
	static List<int[]> cctvs = new ArrayList<>();
	static int n_cctv;
	static int N;
	static int M;
	static int min_n = Integer.MAX_VALUE;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 동 남 서 북

	static void monitor(int x, int y, int dir, int[][] map) {
		int nx = x;
		int ny = y;
		while (true) {
			nx = x + dx[dir];
			ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 6) {
				break;
			}

			if (map[nx][ny] == 0) {
				map[nx][ny] = -1; // 탐색이 완료된 곳 -1로 변경
			}
			x = nx;
			y = ny;
		}
		
		
	}

	static int[][] getMap(int[][] map) {
		// 값이 같은 지도를 만들어 반환
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	static void dfs(int depth, int[][] map) {
		if (depth == n_cctv) { //탐색이 끝나면
			int cnt = 0;
			for (int i = 0; i < N; i++) {  // 사각지대 개수 체크
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						cnt++;
					}
				}
			}

			min_n = cnt < min_n ? cnt : min_n; // 작은 값으로 업데이트
			return;
		}
		int cctvX = cctvs.get(depth)[0];
		int cctvY = cctvs.get(depth)[1];
		int cctvCategory = cctvs.get(depth)[2];
		int[][] newMap = new int[N][M];
		switch (cctvCategory) {
		case 1: // 1방향 탐색
			for (int i = 0; i < 4; i++) {
				newMap = getMap(map);
				monitor(cctvX, cctvY, i, newMap);
				dfs(depth + 1, newMap);
			}
			break;
		case 2: // 직선 탐색
			for (int i = 0; i < 2; i++) {
				newMap = getMap(map);
				monitor(cctvX, cctvY, i, newMap);
				monitor(cctvX, cctvY, (i + 2) % 4, newMap);
				dfs(depth + 1, newMap);
			}
			break;

		case 3: // 90도 탐색
			for (int i = 0; i < 4; i++) {
				newMap = getMap(map);
				monitor(cctvX, cctvY, i, newMap);
				monitor(cctvX, cctvY, (i + 1) % 4, newMap);
				dfs(depth + 1, newMap);
			}
			break;

		case 4: // 180도 탐색
			for (int i = 0; i < 4; i++) {
				newMap = getMap(map);
				monitor(cctvX, cctvY, i, newMap);
				monitor(cctvX, cctvY, (i + 1) % 4, newMap);
				monitor(cctvX, cctvY, (i + 2) % 4, newMap);
				dfs(depth + 1, newMap);
			}
			break;
		case 5: //360도 탐색
			newMap = getMap(map);
			monitor(cctvX, cctvY, 0, newMap);
			monitor(cctvX, cctvY, 1, newMap);
			monitor(cctvX, cctvY, 2, newMap);
			monitor(cctvX, cctvY, 3, newMap);
			dfs(depth + 1, newMap);
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (0 < map[i][j] && map[i][j] < 6) {
					cctvs.add(new int[] { i, j, map[i][j] });
				}
			}
		}
		n_cctv = cctvs.size();
		dfs(0, map);
		System.out.println(min_n);

	}

}


