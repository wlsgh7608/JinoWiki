package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P047_BJ17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] map; // 맵 저장
	static int[] archer = new int[3]; // 궁수 위치 저장
	static HashSet<String> answer; // 죽은 병사 위치를 저장하기 위한 해쉬셋
	static int[] dx = {0,-1,0}; // 왼 위 오른쪽
	static int[] dy = {-1,0,1}; 
	static int max = Integer.MIN_VALUE; // 죽은 최대 병사수
	static int[][] newMap;	// map을 복사하기 위한 배열
	static void simulation(int ax,int ay) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		que.add(new int[] {ax,ay,1});// 
		visited[ax][ay] = true;
		//BFS
		while(!que.isEmpty()) {
			int[] current = que.poll();
			int x = current[0];
			int y = current[1];
			int d = current[2];
			if (newMap[x][y] == 1) { // 병사를 발견했다면
				answer.add(x+" "+y); // 해쉬셋에 추가
				break;
			} else if (d > D) { // 궁수범위를 벗어나는 경우 
				break; //BFS을 끝냄
			}
			for( int i = 0; i<3;i++) { // 왼쪽 위 오른쪽에 대하여 체크하기 
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] ) { // 맵안에 있고 방문하지 않았다면
					visited[nx][ny] = true; // 방문표시
					que.add(new int[] {nx,ny,d+1}); //큐에 추가
				}
			}
			
		}
	}
	static int[][] getMap(){ 
		// 맵을 복사해주는 함수 
		int[][] newMap = new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<M;j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
	
	
	
	static void comb(int depth, int start) {
		//조합
		if (depth==3) {
			// 궁수를 다 뽑았다면
			int cnt = 0; // cnt 0으로 초기화 
			newMap = getMap(); // 맵 복사
			for(int iter = 0; iter<N;iter++) { // 각 전투마다
				answer = new HashSet<>(); // 해쉬셋 초기화 
				for(int i = 0;i<3;i++) { //각 궁수별 BFS 진행
					simulation(N-1-iter, archer[i]);
				}
				for(String dead:answer) { // 죽은 병사에 대하여 반복문 돌림
					int dead_x = Integer.parseInt(dead.split(" ")[0]); 
					int dead_y = Integer.parseInt(dead.split(" ")[1]);
					newMap[dead_x][dead_y] = 0; // 죽은 병사 1 -> 0 으로 표시
				}
				cnt+=answer.size(); // 죽은 병사수 더하기
				
			}
			max = cnt>max? cnt:max; // 병사 최대값 업데이트
			
			return;
		}
		for(int i = start;i<M;i++){
			archer[depth] = i; 
			comb(depth+1,i+1);
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);
		map = new int[N][M];
		for (int i = 0; i<N;i++) {
			input = br.readLine().split(" ");
			for (int j = 0 ; j<M;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		// 입력 끝
		
		comb(0,0);
		System.out.println(max);
		
	}

}
