package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P056_BJ7576_토마토 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M]; // 방문 표시를 위한 배열
		int[] dx = { -1, 1, 0, 0 }; 
		int[] dy = { 0, 0, 1, -1 };
		int max_days = -1; // 최대 사이즈 초기화
		Queue<int[]> Q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 1) { // 현재 토마토라면 
					Q.add(new int[] { i, j, 0 }); // 큐에 추가
					visited[i][j] = true; //방문 표시

				}
			}
		}

		while (!Q.isEmpty()) { // 큐가 비어있을 때마다 반복
			int[] cur = Q.poll(); // 큐에서 하나 뽑기
			max_days = cur[2] > max_days ? cur[2] : max_days; // 최대 일수 저장

			for (int i = 0; i < 4; i++) { // 4방향 반복
				int nx = cur[0] + dx[i]; // 이동할 x위치
				int ny = cur[1] + dy[i]; // 이동할 y위치

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == -1) { //범위 밖, 방문, -1인 경우는 다음 반복문 실행
					continue;
				}
				Q.add(new int[] { nx, ny, cur[2] + 1 }); // 큐에 days하나 늘려서 추가
				visited[nx][ny] = true;//방문표시
				map[nx][ny] = cur[2] + 1; // map 값 업데이트
			}
		}
		boolean allDone = true; // 다 익었는 지 확인하기 위한 flag 변수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 익지 않은 토마토가 있는 경우
					allDone = false; // false로 저장
				}
			}
		}

		if (allDone) { //다 익었다면
			System.out.println(max_days); // 최대일수 출력
		} else { //다 익지 않았다면
			System.out.println(-1); // -1 출력
		}

	}

}
