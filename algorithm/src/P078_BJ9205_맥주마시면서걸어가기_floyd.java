package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P078_BJ9205_맥주마시면서걸어가기_floyd {
	static final int INF = 9999999;
	static int n, dist[][];

	static class Conv {
		int x;
		int y;

		public Conv(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			n = Integer.parseInt(br.readLine());
			Conv[] conv = new Conv[n + 2];

			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				conv[i] = new Conv(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int[][] dist = new int[n + 2][n + 2]; // 거리 배열
			for (int[] row : dist) {
				Arrays.fill(row, INF); // 최대값으로 초기화
			}
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					int d = Math.abs(conv[i].x - conv[j].x) + Math.abs(conv[i].y - conv[j].y);
					if (d <= 1000) { //거리가 1000이하(맥주20병이하)는 dist값 1로 
						dist[i][j] = 1;
					}
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						// k 를 거쳐서 가는 것이 더 빠른 경우
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); 

					}
				}
			}

			if (dist[0][n + 1] < INF) { // INF보다 작다 => 이동가능하다.
				sb.append("happy").append("\n");
			} else { //INF보다크거나 같다. => 이동불가
				sb.append("sad").append("\n");
			}

		}
		System.out.println(sb);
	}

}
