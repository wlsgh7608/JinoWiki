package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P081_SWEA5643_키순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= TC; t++) {

			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			boolean[][] dist = new boolean[N][N];
			for (boolean[] row : dist) {
				Arrays.fill(row, false); // [a,b] = true: a가 b보다키가 더 크다. false: 알수없다.
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				dist[a - 1][b - 1] = true; // a는 b보다 키가 더 큼
			}
			for (int i = 0; i < N; i++) {
				dist[i][i] = true; // 자기자신은 true라고 초기화
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (dist[i][k] && dist[k][j]) { // 키가 i가 k보다 크고 k가 j보다 클 경우
							dist[i][j] = true; // i는 j보다 크다.
						}
					}
				}
			}
			int result = 0;

			for (int i = 0; i < N; i++) {
				boolean isTrue = true;
				for (int j = 0; j < N; j++) {
					if (!dist[i][j] && !dist[j][i]) { // 키가 i가 j보다 큰지 알수없거나 j가 i보다 큰지 알 수 없다면
						isTrue = false; // 해당 인덱스는 몇 순위인지 알 수 없음.
					}
				}
				if (isTrue) {
					result++; // true라면 개수++
				}
			}
			sb.append("#" + t + " " + result).append("\n");
		}
		System.out.println(sb);
	}

}
