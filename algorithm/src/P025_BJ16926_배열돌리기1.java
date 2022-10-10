package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P025_BJ16926_배열돌리기1 {
	
	static final int[] dx = { 0, 1, 0, -1 };// 우,하,좌,상
	static final int[] dy = { 1, 0, -1, 0 };// 우,하,좌,상

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);// 행
		int M = Integer.parseInt(line[1]);// 열
		int R = Integer.parseInt(line[2]);// 회전수
		int G[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				G[i][j] = Integer.parseInt(line[j]);
			}
		} // 데이터 초기화 완료
		
		int min = N > M ? M : N;
		int grpNo = min / 2;// 회전해야 할 그룹 갯수

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < grpNo; j++) {
				int x = j;// 시작 x위치
				int y = j;// 시작 y위치 
				int temp = G[x][y];// 스와핑을 위해 현재 데이터 값을 보관
				int idx = 0;// 방향
				while (idx < 4) {// 우하좌상 순서로 처리
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					if (nx < j || nx >= N - j || ny < j || ny >= M - j) {
						idx++;// 범위를 벗어나면 방향 전환하여 조건에 맞을때까지 탐색

					} else {// 범위내의 경우는 스와핑으로 값을 변경
						G[x][y] = G[nx][ny];
						x = nx;
						y = ny;
 
					}
				} // while을 나갈 때는 스타트 지점의 값만 빼고 모든 값이 한칸씩 전진된 상태
				G[j + 1][j] = temp;// 한 그룹 처리가 완료되는 시점에 스타트 지점의 값을 x-1 한 위치에 저장해야 함.
			} // end j 모든 그룹 처리 완료
		} // end i
			// 결과 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(G[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}


}
