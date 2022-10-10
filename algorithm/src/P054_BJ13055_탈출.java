package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P054_BJ13055_탈출 {
	static char[][] map;
	static int R;
	static int C;
	static int[] dx = { 0, -1, 0, 1 }; // 4 방향
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); // 행
		C = Integer.parseInt(input[1]); // 열

		int[] start = new int[3]; // 시작 x,y 위치 저장

		boolean[][] visited = new boolean[R][C]; // 방문 표시를 위한 배열
		map = new char[R][C]; // RxC 배열 생성
		Queue<int[]> que = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '*') { // 물 위치 큐에 넣기
					que.add(new int[] { i, j, 0 }); // 물이라면 큐에 추가
				} else if (map[i][j] == 'S') { // 시작 위치
					start[0] = i; // 고슴도치 x위치
					start[1] = j; // 고슴도치 y위치
				}
			}
		} // 지도 만들기

		boolean ans = false; // 정답 flag
		int count = 0; // 걸리는 시간
		que.add(start); // 시작 점 큐에 넣기
		visited[start[0]][start[1]] = true;
		hear:

		while (!que.isEmpty()) {
			count++;
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i]; // 이동할 nx
				int ny = cur[1] + dy[i]; // 이동할 ny
				if (nx >= 0 && nx < R && ny >= 0 && ny < C) { // 범위 안에 있으면
					// 도착이면 멈추기
					if (map[cur[0]][cur[1]] != '*' && map[nx][ny] == 'D') { // 현재 고슴도치이고 도착했다면
						ans = true; // true로 표시
						count = cur[2] + 1;
						break hear; // 반복문 break;
					}

					if (!visited[nx][ny] && map[cur[0]][cur[1]] == '*') { // 꺼낸 값이 물이라면
						if (map[nx][ny] == '.') { // 빈칸 이라면
							que.add(new int[] { nx, ny, cur[2] + 1 });// 큐에 넣고
							visited[nx][ny] = true;// 방문표시
							map[nx][ny] = '*'; // 물이라고 표시
						}
					} else if (!visited[nx][ny] && map[nx][ny] == '.') { // 현재 고슴도치이고, 빈칸이라면
						// 이동하기
						que.add(new int[] { nx, ny, cur[2] + 1 }); // 큐에 넣기
						visited[nx][ny] = true; // 방문표시

					}

				}
			}
		} // endwhile

		if (ans)

		{ // 찾았다면
			System.out.println(count); // count 출력
		} else { // 못찾았다면
			System.out.println("KAKTUS"); // KAKTUS 출력
		}

	}

}
