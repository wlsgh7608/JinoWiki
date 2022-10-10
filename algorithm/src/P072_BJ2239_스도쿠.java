package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class P072_BJ2239_스도쿠 {
	static int N = 9;
	static int[][] G;

	static boolean dfs(int x, int y) {
		int nx = x + (y + 1) / N; // 다음 숫자 행
		int ny = (y + 1) % N; // 다음 숫자 열
		if (x == 9) {
			return true;
		}
		if (G[x][y] != 0) {
			return dfs(nx, ny);
		}

		HashSet<Integer> possible = getNumbers(x, y);
		for (int p : possible) { // 가능한 숫자들에 대하여
			G[x][y] = p;
			if (dfs(nx, ny)) { // 다음 dfs 진행
				return true;
			}
		}
		return false;
	}

	static HashSet<Integer> getNumbers(int x, int y) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			set.add(i);
		}
		for (int i = 0; i < N; i++) {
			set.remove(G[i][y]); // 가로
			set.remove(G[x][i]); // 세로
		}

		int tx = x / 3;
		int ty = y / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				set.remove(G[tx * 3 + i][ty * 3 + j]); // 한 방 3x3의 숫자들
			}
		}

		return set; // 가능한 숫자들 반환
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		G = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				G[i][j] = input.charAt(j) - '0';
			}
		}
		
		dfs(0,0);

		for (int[] row : G) {
			for (int n : row) {
				sb.append(n);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
