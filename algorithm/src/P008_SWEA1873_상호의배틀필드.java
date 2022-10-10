package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P008_SWEA1873_상호의배틀필드 {
	public static char[][] G;

	public static int x;
	public static int y;
	public static int direct; // 0: UP, 1: Right, 2: Down, 3: Left
	public static int[] dx = { -1, 0, 1, 0 }; //위 , 오른쪽,아래,왼쪽
	public static int[] dy = { 0, 1, 0, -1 }; //위, 오른쪽,아래,왼쪽
	
	public static char tank_direct(int d) {
		char result = '-';
		switch (direct) {
		case (0):
			result = '^';
			break;
		case (1):
			result = '>';
			break;
		case (2):
			result = 'v';
			break;
		case (3):
			result = '<';
			break;
		}
		return result;
	}
	

	public static void move(int d) {
		direct = d; // 방향 수정 
		int nx = x + dx[direct]; // 이동할 x위치
		int ny = y + dy[direct]; // 이동할 y위치
		G[x][y] = tank_direct(d); // 탱크의 방향을 수정하여 저장
		if (0 <= nx && nx < G.length && 0 <= ny && ny < G[0].length) { // 범위를 벗어나지 않을 시
			if (G[nx][ny] == '.') { // 평지일경우
				G[nx][ny] = tank_direct(d); // 이동할 위치의 탱크 저장
				G[x][y] ='.'; // 그 전 위치 평지로 수정
				x = nx; // 현재 x위치
				y = ny; // 현재 y위치
			}
		}

	}

	public static void shoot() {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dx[direct]; // 포탄의 x 위치
			ny += dy[direct]; // 포탄의 y 위치
			if (0 <= nx && nx < G.length && 0 <= ny && ny < G[0].length) { // 포탄이 범위 안에 있을 경우 
				if (G[nx][ny] == '.' || G[nx][ny] == '-') { //포탄이 평지나 물을 만난다면
					continue; // 반복문 계속 수행
				} else if(G[nx][ny] == '*') { // 포탄이 벽을 만난다면
					G[nx][ny] = '.'; // 평지로 수정
					break; // 반복문을 빠져나옴
				}else if (G[nx][ny] == '#') { // 포탄이 강철벽을 만난다면
					break; // 반복문을 빠져나옴
				}
			}
			else { // 포탄이 범위 밖에 있을 경우
				break; // 반복문을 빠져나옴
			}
		}
		

	}

	public static void act_command(char c) {
		// 행동 수행 
		switch (c) {
		case ('U'): 
			move(0);
			break;
		case ('D'):
			move(2);
			break;
		case ('L'):
			move(3);
			break;
		case ('R'):
			move(1);
			break;
		case ('S'):
			shoot();
			break;

		}

	}

	public static void main(String args[]) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int row, col;
			String[] inputs = br.readLine().split(" ");
			row = Integer.parseInt(inputs[0]); // 그래프의 행
			col = Integer.parseInt(inputs[1]); // 그래프의 열
			G = new char[row][col]; // 그래프 생성

			for (int i = 0; i < row; i++) {
				String map_row = br.readLine(); // 한줄의 맵
				for (int j = 0; j < map_row.length(); j++) {
					G[i][j] = map_row.charAt(j); // 그래프 값 할당
					switch (G[i][j]) {
					// 탱크를 찾아서  x,y,direct(방향) 저장
					case ('^'):
						x = i;
						y = j;
						direct = 0;
						break;
					case ('>'):
						x = i;
						y = j;
						direct = 1;
						break;

					case ('v'):
						x = i;
						y = j;
						direct = 2;
						break;

					case ('<'):
						x = i;
						y = j;
						direct = 3;
						break;
					}
				}
			}
			int command_cnt = Integer.parseInt(br.readLine());

			String commands = br.readLine(); //명령 스트링

			for (int i = 0; i < command_cnt; i++) {
				act_command(commands.charAt(i)); // 명령 수행
			}
			
			sb.append("#"+test_case+" "); 
			for(char[] r : G) {
				for (char c: r) {
					sb.append(c);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}
