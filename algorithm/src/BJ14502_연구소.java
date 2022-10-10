package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ14502_연구소 {

	static List<Zero> zeros = new ArrayList<>();
	static int W = 3;
	static Zero[] walls = new Zero[3];
	static int N;
	static int M;
	static int[][] G;

	static int[][] copy(int[][] G) {
		int[][] newG = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newG[i][j] = G[i][j];
			}

		}
		return newG;

	}

	static void comb(int cnt, int start) {

		if (cnt == W) {
			int[][] newG = copy(G);

			System.out.println(Arrays.toString(walls));
			return;
		}

		for (int i = start; i < zeros.size(); i++) {
			walls[cnt] = zeros.get(i);
			comb(cnt + 1, i + 1);
		}

	}

	static class Zero {
		int x;
		int y;

		public Zero(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Zero [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		G = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
				if (G[i][j] == 0) {
					zeros.add(new Zero(i, j));
				}
			}
		}
		comb(0, 0);

	}

}
