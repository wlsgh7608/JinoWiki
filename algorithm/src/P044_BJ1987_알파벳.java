package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P044_BJ1987_알파벳 {

	static boolean[] check;
	static char[][] map;
	static int dx[] = { 0, 1, 0, -1 };// 방향
	static int dy[] = { 1, 0, -1, 0 };
	static int R;
	static int C;
	static int max = 0;// 최대값 확인
	static int count = 0;// 현재 횟수 확인

	public static void move(int x, int y) {
		if (x >= R || x < 0 || y >= C || y < 0) {// 범위 벗어나면 멈추기
			return;
		}
		// max 확인
		max = count > max ? count : max;// max 업데이트

		for (int i = 0; i < 4; i++) {// 네 방향 탐색
			if (check[(int) map[x][y] - 65])
				continue; // 해당 알파벳 사용

			else {
				check[(int) map[x][y] - 65] = true;// 해당 알파벳을 사용으로 변경
				count++;// 갯수 더해주기
				move(x + dx[i], y + dy[i]);
				count--;// 다시 빼주기
				check[(int) map[x][y] - 65] = false;// 해당 알파벳 미사용으로 변경
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input[] = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		check = new boolean[26];// 알파벳 개수 만큼: A 65를 0 인덱스로 설정
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		} // 입력 완료

		move(0, 0);

		bw.write(max + "");
		bw.flush();
		bw.close();

	}

}