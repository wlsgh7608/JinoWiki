package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P062_BJ17144_미세먼지안녕 {
	static int R;
	static int C;
	static int[] dx = { -1, 0, 1, 0 };// 상,우,하,좌
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map; // RxC 맵
	static int[] fans; // 공기청정기 x(행)위치

	static void expand() { // 확산되는 미세먼지 함수
		int[][] temp = new int[R][C]; // 퍼지는 미세먼지를 저장하는 RxC배열
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int cnt = 0;
				int dustNum = map[i][j] / 5; // 
				for (int k = 0; k < 4; k++) { //4방향에 대하여
					int nx = i + dx[k]; //이동할 행 위치
					int ny = j + dy[k]; // 이동할 열 위치
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) { //범위 밖에 있거나 공기청정기인 경우
						continue; 
					}
					cnt++; // 퍼질 수 있으면 개수+1
					temp[nx][ny] += dustNum; // 퍼진 미세먼지 양 저장
				}
				map[i][j] -= dustNum * cnt;  // 내 위치의 미세먼지의 양 - 퍼지는 미세먼지양 *개수
			}
		} 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += temp[i][j]; //  기존의 맵에 퍼지는 맵을 더함
			}
		}

	}

	static void move(int p,boolean isCounter,int sx,int ex) {
		/*
		 *  p : 공기청정기의 idx
		 *  isCounter : 반시계방향인지를 나타내는 boolean
		 *  sx : 행의 시작부분
		 *  ex : 행의 마지막 부분
		 */ 
		int x = fans[p];
		int y = 0;
		int d_start = 0;
		int d=1;
		if(isCounter) { // 반시계방향이면
			d_start = 2+4; // 시작위치는 6으로 설정( 2로 하게될경우 나머지연산이 문제생김)
			d = -1; // 반대로 가기위하여 d=-1
		}
		for (int i = 0; i < 4; i++) {
			int d_idx = (d_start + d*i) % 4; // 방향 변경
			while (true) { 
				int nx = x + dx[d_idx]; // 이동할 행 위치
				int ny = y + dy[d_idx]; // 이동할 열 위치
				if (nx < sx || nx >= ex || ny < 0 || ny >= C ) { //범위밖이라면
					break; //다음 방향에 찾기
				}
				if(map[nx][ny] ==-1) { //만약 다음 위치가 공기청정기라면
					map[x][y] = 0; // 현재값을 0으로 저장
					break; //끝
				}
				if (map[x][y] == -1) { // 만약 현재 공기청정기라면
					x = nx; // 다음위치로 업데이트 
					y = ny; // 다음위치로 업데이트 
					continue;
				}
				map[x][y] = map[nx][ny]; // 값 옮기기
				x = nx; // 다음위치
				y = ny; // 다음위치로 업데이트 
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		int T = Integer.parseInt(input[2]);
		int f = 0;
		map = new int[R][C];
		fans = new int[2];

		for (int i = 0; i < R; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == -1) {
					fans[f++] = i; // 공기청정기의 행위치 저장
				}
			}
		}

		while (T-- > 0) { //시간이 끝날떄까지 반복
			expand(); //미세먼지 확산
			move(0,false,0,fans[1]); // 위에있는 공기청정기 실행
			move(1,true,fans[1],R); // 아래에 있는 공기청정기 실행

		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) { 
					result += map[i][j]; // 미세먼지 양 더하기
				}
			}
		}
		System.out.println(result);

	}

}
