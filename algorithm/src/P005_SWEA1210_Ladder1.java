package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_SWEA1210_Ladder1 {
	
	public static int[] dy = {0,0,-1};
	public static int[] dx = {-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼드리더를 통하여 입력받음
		StringBuffer sb = new StringBuffer();
		int T = 10 ;  // 10 개의 testcase
		for(int test_case = 1; test_case <= T; test_case++) // 테스트케이스만큼 반복
		{
			int num = Integer.parseInt(br.readLine()); // br.readLine()은 스트링 값으로 int 형으로 변환
			int [][] G = new int [100][100]; // 100x100 배열 생성
			boolean [][] visited = new boolean[100][100]; //100x100 방문 배열 생성
			
			int current_y=-1; // 현재 y위치
			int current_x=-1; // 현재 x위치
			
			// 배열에 값 할당
			for (int i = 0; i<100;i++) { // 배열의 y축 만큼
				StringTokenizer st = new StringTokenizer( br.readLine()," "); // 공백을 기준으로 나눔
				for (int j = 0; j<100;j++) { // 열의 개수 만큼
					G[i][j] = Integer.parseInt(st.nextToken()); // 배열에 값 할당
					if (G[i][j]  == 2) { //목적지
						current_y = i; // 출발지점
						current_x = j; // 출발지점
					}
				}
			}
			// 끝에서부터 올라가보자
			// 1순위 : 다리를 만나면 이동
			// 2순위 : 아래에서 위로
			while(current_y != 0) { // 출발점에 도착할때까지
				for(int i = 0; i<3;i++) { // 왼쪽, 오른쪽, 위에 대한 반복
					int ny = current_y+dy[i]; // 이동할 위치
					int nx = current_x+dx[i]; // 이동할 위치
					
					if(0<=nx && nx<100 && 0<=ny && ny<100) { // 이동할 수있는 위치 체크
						if (G[ny][nx] == 1 && visited[ny][nx]==false) { // 길이있고 방문하지 않았는지 
							current_y = ny; // 현재 y위치 수정
							current_x = nx; // 현재 x위치 수정
							visited[ny][nx] = true; // 방문 표시
							break; // 다시 반복
						}
					}
				}
			}
			sb.append("#"+num+" "+current_x+"\n"); // 반복문이 끝날 때 ( 출발점)
			
		}
		System.out.println(sb); //출력
	}
}