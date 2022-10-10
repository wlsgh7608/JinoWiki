package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P036_BJ1074_Z {
	
	static int order = 0;
	
	public static void search(int r, int c,int size) {
		if(size ==1) { // 한 개 남았을 경우 리턴
			return;
		}
		
		if(r<size/2 && c<size/2) { // 왼쪽 상단
			search(r,c,size/2); // r, c, size 리사이징
		} else if(r<size/2 && c>=size/2) { // 오른쪽 상단
			order+=Math.pow(size/2, 2); // 왼쪽 상단 수 만큼 더하기
			search(r,c-size/2,size/2); // r, c, size 리사이징
		} else if(r>=size/2 && c<size/2) { // 왼쪽 하단
			order+=Math.pow(size/2, 2)*2; // 왼쪽 상단,오른쪽 상단 수 만큼 더하기
			search(r-size/2,c,size/2);// r, c, size 리사이징
		} else { // 오른쪽 하단 
			order+=Math.pow(size/2, 2)*3; // 왼쪽 상단, 오른쪽 상단, 왼쪽 하단 수 만큼 더하기
			search(r-size/2,c-size/2,size/2); // r, c, size 리사이징
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[]  = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		search(r,c,(int)Math.pow(2, N)); // Math.pow의 리턴값은 double이므로 int로 강제 형변환
		bw.write(order+""); //출력
		bw.flush();
		bw.close();

	}

}
