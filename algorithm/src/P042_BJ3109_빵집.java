package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P042_BJ3109_빵집 {
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	static char[][] map;
	static int count = 0;
	static int cx;
	static int cy; 
	static int R; // row
	static int C; // col
	
	static boolean dfs(int x,int y) {
		// 기본적인 아이디어  
		// 오른쪽 위, 오른쪽 중간, 오른쪽 아래를 탐색!
		if(y==C-1) { // 끝에 도달했다면 
			count++; //개수 하나 늘리기
			return true;
		}
		
		for(int i = 0;i<3;i++) { //3가지 방향에 대하여 
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx< R && 0<=ny && ny<C && map[nx][ny] =='.') { //범위 안에 있고 해당 길이 .인 경우
				map[nx][ny] = 'x'; //해당 길은 x로 표시
				if(dfs(nx,ny))
					return true; //탐색
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C]; // RxC 배열 생성
		for(int i = 0; i<R;i++) {
			String row = br.readLine();
			for (int j = 0;j<C;j++) {
				map[i][j] = row.charAt(j);
			}
		}
		/* 입력 끝 */
		
		for(int i = 0;i<R;i++) {
			cx = i;
			cy = 0; // 각 첫째 열에 대하여 탐색시작
			dfs(cx,cy);
		}
		System.out.println(count);

	}

}
