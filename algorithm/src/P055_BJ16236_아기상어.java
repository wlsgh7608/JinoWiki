package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P055_BJ16236_아기상어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) { // 걸린 시간이 같다면
				if (o1[0] == o2[0]) { // x위치가 같다면
					return o1[1] - o2[1]; //y위치를 기준으로 정렬
				} 
				return o1[0] - o2[0]; //x위치를 기준으로 정렬
			}
			return o1[2] - o2[2]; //걸린시간을 기준으로 정렬
		}); 
		boolean[][] visited = new boolean[N][N];
		int size = 2;// 아기상어 크기
		int[] dx = { -1, 0, 0, 1 };// 위,왼,오,아래
		int[] dy = { 0, -1, 1, 0 };
		int[] shark = new int[2];// 상어 위치 저장

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 9) { // 상어라면
					shark[0] = i; //상어의 x위치 저장
					shark[1] = j; //상어의 y위치 저장
					map[i][j] = 0; // 상어 위치의 값을 0으로 변경

					que.add(new int[] { i, j, 0 });// 상어 위치, 이동횟수
					visited[i][j] = true; //방문 표시
				}
			}
		} // 지도 입력 완료

		// Bfs
		int count = 0;// 아기 상어가 먹은 물고기 갯수
		int ans = 0;// 정답 출력용
		while (!que.isEmpty()) {
			int cur[] = que.poll();
			if (map[cur[0]][cur[1]] < size && map[cur[0]][cur[1]] != 0) {// 먹이일때
				count++;
				if (size == count) {// count 갯수 늘리고 확인
					size++;// 아기 상어 크기랑 같으면 사이즈 늘리기
					count = 0;
				}
				// 먹이를 먹으면 방문 표시 초기화
				ans = cur[2];
				shark[0] = cur[0]; // 상어 x 위치
				shark[1] = cur[1]; // 상어 y 위치
				map[cur[0]][cur[1]] = 0; // 먹은 먹이의 값을 0으로 바꾸기
				visited = new boolean[N][N]; //새로 방문표시 생성
				que.clear();// 큐 비우고
				que.add(new int[] { shark[0], shark[1], cur[2]});// 상어 위치 넣어주기
				visited[shark[0]][shark[1]] = true;// 방문 표시
				continue; //다음반복 실행
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i]; // 이동할 x위치
				int ny = cur[1] + dy[i]; // 이동할 y위치

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {// 범위 안에 있다면

					if (!visited[nx][ny] && map[nx][ny] <= size) {// 방문하지 않았고 이동가능하다면
						visited[nx][ny] = true; //방문 표시
						que.add(new int[] { nx, ny, cur[2] + 1 }); // 다음 위치 큐에넣고 이동횟수 +1

					}
				}
			}
		}
		System.out.println(ans);

	}

}
