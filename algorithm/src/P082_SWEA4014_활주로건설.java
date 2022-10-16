package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P082_SWEA4014_활주로건설 {
	static int N;
	static int X;
	static int[][] G;

	static boolean check(int idx, boolean isRow) {
		int[] h = new int[N]; // 해당 선 배열
		if (isRow) {
			for (int i = 0; i < N; i++) {
				h[i] = G[idx][i];
			}
		} else {
			for (int i = 0; i < N; i++) {
				h[i] = G[i][idx];
			}
		}

		int p = 1; // 현재 위치를 가리키는 포인터
		int sameCnt = 1; // 현재까지 같은 높이의 개수
		while (p < N) {
			int diff = h[p] - h[p - 1]; // 두 칸의 차이
			if (diff <= -2 || diff >= 2) { // 2를 넘어가면 false
				return false;
			}
			if (diff == 1) { // 현재 값이 이전값보다 1 클 경우
				if (sameCnt < X) { // 그 전까지의 같은 높이의 개수가 X보다 작을 경우
					return false; //false
				} else { // 같은 높이의 개수가 X보다 크거나 같을 경우 가능함
					sameCnt = 1; // 다시 sameCnt 1로 할당
				}
			} else if (diff == -1) { // 현재 값이 이전값보다 1 작은 경우
				for (int i = 0; i < X - 1; i++) { // 현재 칸부터 X-1번 돌아 체크
					p++;
					if (p >= N) { // 범위를 벗어난다면
						return false;
					}
					if (h[p] != h[p - 1]) { //값이 같지 않다면
						return false;
					}
					sameCnt=0; // sameCnt 값 0으로 할당
				}
			} else { // 값이 같은 경우
				sameCnt++; // sameCnt+1
			}
			p++; // 다음 칸 가리킴
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			G = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					G[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				if (check(i, false)) { // 열 체크
					cnt++;
				}
				if (check(i, true)) { // 행 체크
					cnt++;
				}
				

			}
			sb.append("#" + tc + " " + cnt).append("\n");

		}
		System.out.println(sb);
	}

}
