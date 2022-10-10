package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] whites = new boolean[100][100]; //100x100 사이즈 생성
		int n = Integer.parseInt(br.readLine());
		for (int k = 0; k<n;k++) {
			String[] inputs = br.readLine().split(" ");
			int x = Integer.parseInt(inputs[0]);
			int y = Integer.parseInt(inputs[1]);
			for(int i = 0;i<10;i++) { //10x10의 색종이
				for (int j = 0; j<10;j++) {
					whites[x+i][y+j] = true;  // true로 변경
				}
				
			}
		} 
		
		int cnt = 0;
		for (int i = 0;i<100;i++) {
			for (int j = 0; j<100;j++) {
				if(whites[i][j]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
		
		
		
		
	}

}
