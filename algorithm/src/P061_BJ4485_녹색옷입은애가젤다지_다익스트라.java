package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = -1;
		int[][] map;
		int[][] dp;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int num =0;
		while (true) {
			num++; // 현재 문제의 번호
			N = Integer.parseInt(br.readLine());
			if (N == 0) { // 0일 경우 반복끝냄
				break;
			}
			map = new int[N][N];
			dp = new int[N][N];
			//(x,y)까지의 이동최소값 저장
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE); //MAX값으로 초기화
			}
			
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			/*  입력  */

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[2]-o2[2]); //가중치를 기준으로 정렬
			pq.add(new int[] { 0, 0, map[0][0]}); // (0,0) 값 저장
			while (!pq.isEmpty()) { // 큐가 비어있지 않을 때 까지 반복
				int[] cur = pq.poll(); // 큐에서 가중치가 가장 작은 값 빼기
				if (cur[0] == N - 1 && cur[1] == N - 1) { // 끝에 도달했다면
					sb.append("Problem "+num+": "+cur[2]).append("\n"); // 결과값 저장
					break;
				}
				for (int i = 0; i < 4; i++) { //4방향 탐색
					int nx = cur[0] + dx[i]; // 이동할 x위치
					int ny = cur[1] + dy[i]; // 이동할 y위치

					if (0 > nx || nx >= N || 0 > ny || ny >= N) //범위를 벗어나면 
						continue; //다음 방향 
					if (cur[2] + map[nx][ny] < dp[nx][ny]) { // 현재위치에서 (nx,ny)로 이동하는 값이 지금까지의 (nx,ny)의 최솟값 보다 작은 경우
						dp[nx][ny] = cur[2] + map[nx][ny]; // (nx,ny) 최소값 업데이트
						pq.add(new int[] { nx, ny, cur[2] + map[nx][ny] }); // 큐에 추가
					}
				}

			} // end while

		}
		System.out.println(sb);

	}

}
