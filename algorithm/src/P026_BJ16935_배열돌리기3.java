package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P026_BJ16935_배열돌리기3 {
	static int arr[][]; //입력 배열
	static int ans[][]; //연산 저장
	static int n;
	static int m;
	
	
	// 배열 상하 반전
	public static void  one() {
		for (int i = n-1,j = 0;i>=0;i--) { // 위 아래 줄 바꾸기
			for (int k = 0; k<m;k++) {
				ans[j][k] = arr[i][k];
			}
			j++;
		}
		arr= ans; // 결과값을 입력 배열로
	}
	// 배열 좌우 반전
	public static void two() {
		for (int i = m-1,j=0; i>=0;i--) {  // 좌우 위치 바꾸기
			for (int k = 0 ; k<n;k++) {
				ans[k][j] = arr[k][i];
			}
			j++;
		}
		arr = ans;
	}
	
	//오른쪽으로 90도 회전
	public static void three() { 
		for (int i = 0; i<m;i++) {
			for (int k = 0; k<n;k++) {
				ans[i][k] = arr[n-1-k][i];
			}
		}
		int temp = 0;
		temp = n;
		n = m;
		m = temp;
		arr =ans;
		
	}
	
	//왼쪽으로 90도 회전
	public static void four() {
		for (int i = 0; i<m;i++) {
			for (int k = 0; k<n;k++) {
				ans[i][k] = arr[k][m-i-1];
			}
		}
		int temp = 0;
		temp = n;
		n = m;
		m = temp;
		arr = ans;
	}
	
	// 사분할 시계 방향 이동
		public static void five() {
			for (int i = 0; i < n/2; i++) {//왼쪽 위
				for (int j = 0; j < m/2; j++) {
					ans[i][j+(m/2)] = arr[i][j];
				}
			}
			for (int i = 0; i < n/2; i++) {//오른쪽 위
				for (int j = m/2; j < m; j++) {
					ans[i+(n/2)][j] = arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {//오른쪽 아래
				for (int j = m/2; j < m; j++) {
					ans[i][j-(m/2)] = arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {//왼쪽 아래
				for (int j = 0; j < m/2; j++) {
					ans[i-(n/2)][j] = arr[i][j];
				}
			}
			arr = ans;

		}
		// 사분할 반시계 방향 이동
		public static void six() {
			for (int i = 0; i < n/2; i++) {//왼쪽 위
				for (int j = 0; j < m/2; j++) {
					ans[i+(n/2)][j] = arr[i][j];
				}
			}
			for (int i = 0; i < n/2; i++) {//오른쪽 위
				for (int j = m/2; j < m; j++) {
					ans[i][j-(m/2)] = arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {//오른쪽 아래
				for (int j = m/2; j < m; j++) {
					ans[i+-(n/2)][j] = arr[i][j];
				}
			}
			for (int i = n/2; i < n; i++) {//왼쪽 아래
				for (int j = 0; j < m/2; j++) {
					ans[i][j+(m/2)] = arr[i][j];
				}
			}
			arr = ans;

		}
	
	
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));				
		
		String[] string = br.readLine().split(" ");
		n = Integer.parseInt(string[0]);
		m = Integer.parseInt(string[1]);
		int r = Integer.parseInt(string[2]);
		arr = new int[n][m];
		int op ; //연산
		
		
		for(int i = 0 ; i<n;i++) {
			string = br.readLine().split(" ");
			for(int j = 0 ; j<m;j++) {
				arr[i][j] = Integer.parseInt(string[j]);
			}
		} //end array input
		
		string = br.readLine().split(" ");
		
		for (int i = 0; i<r;i++) {
			op = Integer.parseInt(string[i]);
			switch(op) {
			case 1:
				ans = new int[n][m];
				one();
				break;
			case 2:
				ans = new int[n][m];
				two();
				break;
			case 3:
				ans = new int[m][n];
				three();
				break;
			case 4:
				ans = new int[m][n];
				four();
				break;
			case 5:
				ans = new int[n][m];
				five();
				break;
			case 6:
				ans = new int[n][m];
				six();
				break;
			}
			
		}
		
		
		
		for(int i = 0 ; i <n;i++) { // 결과 출력 
			for (int j = 0; j<m;j++) {
				bw.write(ans[i][j]+" ");
			}
			bw.write("\n");
		}
		
		
		bw.flush(); //버퍼 flush
		bw.close(); //버퍼 close
		
		

	} // end main

}
