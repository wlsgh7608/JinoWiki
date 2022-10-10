package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P038_SWEA5644_무선충전 {

	static int[] dx = { 0, 0, 1, 0, -1 }; // 그대로,상,우,하,좌
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] idx;

	static int[] isAbleIdx(int[] X, int[][] info) {
		idx = new int[2];
		int p = 0;
		idx[0] = -1;
		idx[1] = -1;

		for (int i = 0; i < info.length; i++) {
			int dist = Math.abs(X[0] - info[i][0]) + Math.abs(X[1] - info[i][1]);
			if (dist <= info[i][2]) {
				if (p >= 2)
					break;
				idx[p++] = i;
			}
		}
		return idx;
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]);
			int BC = Integer.parseInt(input[1]);
			int[] A_dir = new int[M + 1];
			int[] B_dir = new int[M + 1];
			int[][] info = new int[BC][4];
			int sum = 0;

			input = br.readLine().split(" ");
			for (int i = 1; i <= M; i++) {
				A_dir[i] = Integer.parseInt(input[i - 1]);
			}
			input = br.readLine().split(" ");
			for (int i = 1; i <= M; i++) {
				B_dir[i] = Integer.parseInt(input[i - 1]);
			}

			for (int i = 0; i < BC; i++) {
				input = br.readLine().split(" ");
				info[i][0] = Integer.parseInt(input[0]) - 1; // x
				info[i][1] = Integer.parseInt(input[1]) - 1; // y
				info[i][2] = Integer.parseInt(input[2]); // range
				info[i][3] = Integer.parseInt(input[3]); // power
			}
			Arrays.sort(info, (x1, x2) -> x2[3] - x1[3]);
			int[] A = { 0, 0 };
			int[] B = { 9, 9 };

			for (int i = 0; i <= M; i++) {
				A[0] += dx[A_dir[i]];
				A[1] += dy[A_dir[i]];
				B[0] += dx[B_dir[i]];
				B[1] += dy[B_dir[i]];
				int[] A_idx = new int[2];
				int[] B_idx = new int[2];
				A_idx = isAbleIdx(A, info);
				int a_1 = A_idx[0];
				int a_2 = A_idx[1];

				B_idx = isAbleIdx(B, info);
				int b_1 = B_idx[0];
				int b_2 = B_idx[1];

				if (a_1 == -1 && b_1 == -1) {
					continue;
				} else if (a_1 == -1) {
					sum += info[b_1][3];
				} else if (b_1 == -1) {
					sum += info[a_1][3];
				} else if (a_1 != b_1) {
					sum += info[a_1][3] + info[b_1][3];
				} else if (a_1 == b_1) {
					if (a_2 == -1 && b_2 == -1) {
						sum += info[a_1][3];
					} else if (b_2 == -1) {
						sum += info[a_1][3] + info[a_2][3];
					} else if (a_2 == -1) {
						sum += info[b_1][3] + info[b_2][3];
					} else {
						sum += info[b_1][3] + info[Math.min(a_2, b_2)][3];
					}
				}
			}
			sb.append("#" + t + " " + sum).append("\n");
		}
		System.out.println(sb);
	}

}
