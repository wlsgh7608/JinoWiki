package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P068_SWEA1249_보급로 {
	static class Repair implements Comparable<Repair> {
		int x;
		int y;
		int cost;

		public Repair(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Repair o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] G = new int[N][N];
			for(int i =0;i<N;i++) {
				String input = br.readLine();
				for(int j = 0; j<N;j++) {
					G[i][j] = input.charAt(j)-'0';
					
				}
			}
			
			int[][] dist = new int[N][N];
			for (int[] row : dist) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}

			dist[0][0] = 0;
			PriorityQueue<Repair> PQ = new PriorityQueue<>();
			PQ.add(new Repair(0, 0, 0));
			while (!PQ.isEmpty()) {
				Repair current = PQ.poll();
				int x = current.x;
				int y = current.y;
				int cost = current.cost;
				if(x==N-1 && y==N-1) {
					sb.append("#"+t+" "+cost).append("\n");
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}
					
					if(dist[nx][ny] > dist[x][y]+G[nx][ny]) {
						dist[nx][ny] = dist[x][y]+G[nx][ny];
						PQ.add(new Repair(nx, ny, dist[nx][ny]));
					}
				
				}
			}

		}//end for
		System.out.println(sb);

	}
}
