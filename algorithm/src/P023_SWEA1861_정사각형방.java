package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P023_SWEA1861_정사각형방 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int max_n ;
	static int max_cnt;
	static int rx;
	static int ry;
	static int[][] G;
	static boolean[][] isVisited ;
	
	
	static void dfs(int cnt,int x,int y) {
		if(cnt>max_cnt) { // 최대숫자보다 큰 경우 
			max_cnt = cnt; // 새로운 최대값 할당
			max_n = G[rx][ry]; // 방번호 입력
		} else if (cnt == max_cnt && G[rx][ry] <max_n ) { // 방의 개수는 같으나 방 번호가 낮은 경우 
			max_n = G[rx][ry]; // 방 번호가 더 낮은 것으로 할당 
		}
		for (int i = 0; i<4;i++) {
			int nx = x+dx[i]; // 이동할 x위치 
			int ny = y+dy[i]; // 이동할 y위치 
			if (0<=nx&& nx <G.length && 0<=ny&&ny<G.length) { // 범위 안에 있는 경우 
				if(G[nx][ny] == G[x][y]+1) { // 해당 값이 1이 더 큰 경우 
					isVisited[nx][ny] = true; // 방문 표시 
					dfs(cnt+1,nx,ny); // 다음 dfs
				}
			}
			
		}
	}
	
	
	
	static void find(int x,int y) {
		// 먼저 해당 숫자에서 내려가서 최대로 내려갔을 때의 x,y값을 찾을 것
		rx = x; // 내려갔을 때의 x 값  
		ry = y; // 내려 갔을 때의 y 값 
		
		for (int i = 0; i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
		
			if (0<=nx&& nx <G.length && 0<=ny&&ny<G.length) {
				if(G[nx][ny] == G[x][y]-1) { // 1만큼 작은 경우 내려갈 수 있음 
					find(nx,ny);
				}
			}
		}
		
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t<=N;t++) {
			int size = Integer.parseInt(br.readLine());
			G = new int[size][size]; //그래프 크기 
			for (int i = 0; i<size;i++) {  
				String[] inputs = br.readLine().split(" "); //공백을 기준으로 나눔 
				for (int j = 0;j<size;j++) {
					G[i][j] = Integer.parseInt(inputs[j]);
				}
			}
			
			max_n = 0;
			max_cnt = 0;
			isVisited = new boolean[size][size]; //방문 표시를 위한 배열
			
			
			for (int i = 0; i<size;i++) {
				for (int j = 0; j<size;j++) {
					if (!isVisited[i][j]) { //방문하지 않았다면 
						find(i,j); // 숫자 내려가기 
						dfs(1,rx,ry); // 작은 숫자에서 올라가기 

					}
				}
			}
			sb.append("#"+t+" "+max_n+" "+max_cnt).append("\n");
		}
		System.out.println(sb);
		
		
		

	}

}
