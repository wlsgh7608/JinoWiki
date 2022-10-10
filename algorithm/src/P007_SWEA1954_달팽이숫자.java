package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P007_SWEA1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력스트림리더
		StringBuilder sb = new StringBuilder(); // 출력을 위한 Stringbulder
		int T = Integer.parseInt(br.readLine()); //  테스트케이스 개수
		int[] dx = {1,0,-1,0}; // 이동할 x위치
		int[] dy = {0,1,0,-1}; // 이동할 y 위치
		
		for (int test_case =1;test_case<=T;test_case++) { // 테스트케이스만큼 반복
			int size = Integer.parseInt(br.readLine()); // 크기
			
			int[][] G= new int[size][size]; // 크기만큼의 배열 생성
			G[0][0] = 1; // 첫번째는 1로 초기화
			int direct = 0; // 현재 방향 -> 오른쪽으로 이동
			int current_y = 0; // 현재 y위치
			int current_x = 0; // 현재 x위치
			
			int cnt = 1; // 현재의 숫자 값(하나씩 늘려 그래프에 할당)
			int ny,nx; // 이동할 위치
			
			int life = 2; // 2번 방향을 돌면 반복문을 빠져나옴
			
			while(true) {
				ny = current_y+dy[direct]; // 이동할 y위치
				nx = current_x+dx[direct]; // 이동할 x위치
				if (life == 0) // 2번 돌았다면 
					break; //반복문 빠져나옴
				if (ny == -1 || ny== size || nx==-1|| nx==size) { // 그래프 범위에 벗어난다면
					// 끝에 도착
					direct = (direct+1)%4; // 방향을 바꿈
					life -=1;  // 방향 바꿀 수 있는 횟수 하나 뺌 -> 방향을 한 번 바꿨다는 의미
					continue;
				}
				else if (G[ny][nx] == 0) { // 처음 방문
					current_y = ny; // y위치 변경
					current_x = nx; // x위치 변경
					G[ny][nx] = ++cnt; // 그래프에 해당 값(cnt) 저장
					life = 2; // 방향 바꿀 수 있는 횟수 2로 초기화
				}
				else if(G[ny][nx] !=0) { // 방문했다면
					direct = (direct+1)%4; // 방향을 바꿈
					life -=1; // 방향 바꿀 수 있는 횟수 하나 뺌
				}
			}
			
			sb.append("#"+test_case+"\n"); // 테스트케이스 문장 출력
			for (int i =0;i<size;i++) { // 행만큼
				for (int j = 0; j<size;j++) { 
					sb.append(G[i][j]+" "); //그래프 값 append
				}
				sb.append("\n"); // 개행문자 append
			}
			
			
		}
		System.out.println(sb); //출력
		
		

	}

}
