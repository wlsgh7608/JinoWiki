package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P028_BJ17406_배열돌리기4 {
	static int[][] G;
	static int[][] newG;
	static int N;
	static int M;
	static int K;
	static int[] dx = {1,0,-1,0}; // 아래 , 오른 , 위 , 왼
	static int[] dy = {0,1,0,-1};
	static int[][] Karr ;
	static boolean[] isSelected;
	static int[] rotateNum;
	static int min;
	
	static void rotate(int r,int c,int s) {
		/*
		 * 1. 스핀 횟수 -> O 
		 * 2. 제대로 돌아가나요? O
		 */
		
		// 왼쪽 위(r-s,c-s) , 오른쪽 아래(r+s,c+s)
		int startX = r-s-1;  // 왼쪽위 x좌표
		int startY = c-s-1;  // 왼쪽위 y좌표
		
		for(int spin = 0;spin <s;spin++) { // 회전 하는 수 
			int x = startX + spin; 
			int y = startY + spin;
			// x길이?
			int temp = newG[x][y];
			int cnt = 0;
			while(cnt<4) { 
				int nx= x+dx[cnt]; // 이동할 위치 = 현재x위치 + dx
				int ny= y+dy[cnt]; // 이동할 위치 = 현재y위치 + dy
				
				
				if(nx<startX+spin || nx> startX+2*s-spin || ny<startY+spin || ny> startY+2*s-spin ) { // 범위에서 벗어날 경우
					cnt++; // 방향 바꾸기 
				}
				else { // 범위 안에 있는 경우
					newG[x][y] = newG[nx][ny]; 
					x = nx;
					y = ny;
				}
			}
			newG[startX + spin][startY + spin+1] = temp; // 스타트 지점의  값 저장
		}
	}
	
	public static void perm(int depth) {
		if (depth == K) { // K번째 도달 했을 때
			// newG 초기화
			for (int i = 0 ;i<N;i++) {
				for (int j = 0;j<M;j++) {
					newG[i][j] = G[i][j]; // G와 동일한 값의 2차원 배열 생성
				}
			}
			
			for (int o = 0; o<K;o++) {
				int p = rotateNum[o]; // 해당 회전 순서 
				rotate(Karr[p][0],Karr[p][1],Karr[p][2]);
			}
			for (int i= 0;i<N;i++) {
				int current_sum = 0; 
				for (int j = 0; j<M;j++) { 
					current_sum += newG[i][j]; // 행의 원소들의  합
				}
				min = min>current_sum ? current_sum:min; // 최소값 저장
			}
			return;
		} 
		else { // 순열
			for(int i = 0; i<K;i++) {
				if(!isSelected[i] ) { // 선택되지 않았다면
					isSelected[i] = true;
					rotateNum[depth] = i; // 회전 순서 저장
					perm(depth+1); // 깊이+1
					isSelected[i] = false; 
				}
			}
			
		}
		
		
		
	}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		Karr = new int[K][3]; // 회전정보 저장
		isSelected = new boolean[K]; // 순열을 위한 배열
		rotateNum = new int[K]; // 회전번호 저장 
		
		G = new int[N][M]; // N x M 배열 생성
		newG = new int [N][M];
		for (int i = 0;i<N;i++) {
			input  = br.readLine().split(" ");
			for(int j = 0;j<M;j++) {
				G[i][j] = Integer.parseInt(input[j]);
			}
		}
		 
		for (int i = 0; i<K;i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]);
			Karr[i] = new int []{r,c,s};
			
		}
		min = Integer.MAX_VALUE; // 최소값
		perm(0);
		
		// 최솟값 찾기
		System.out.println(min);

	}

}
