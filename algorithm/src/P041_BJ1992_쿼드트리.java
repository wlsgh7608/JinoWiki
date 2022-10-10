package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P041_BJ1992_쿼드트리 {
	static int[][] map;
	
	public static String change(int r, int c,int size) {
		if(size ==1) { // 한 개 남았을 경우 리턴
			return Integer.toString(map[r][c]);
		}
		else {
			String q1 = change(r,c,size/2); //왼쪽 위
			String q2 = change(r,c+size/2,size/2); //오른쪽 위 
			String q3 = change(r+size/2,c,size/2); //왼쪽 아래
			String q4 = change(r+size/2,c+size/2,size/2); //오른쪽 아래
			if(! q1.startsWith("(") && q1.equals(q2)&& q1.equals(q3) && q1.equals(q4)) { // 4부분의 값이 같은 경우  + 괄호로 시작하지 않는 경우 
				return q1; //첫번째 조각만 반환
			}
			else {
				return ("("+q1+q2+q3+q4+")"); // 4개의 조각과 괄호를 붙여서 반환
			}
		}
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N]; // NxN 데이터
		
		for(int i = 0;i<N;i++) {
			String input[] = br.readLine().split(""); 
			for(int j = 0; j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		bw.write(change(0,0,N));
		bw.flush();
		bw.close();
	}

}


