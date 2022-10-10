package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P006_SWEA2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼드리더를 통하여 입력받음
		StringBuffer sb = new StringBuffer(); // StringBuffer 생성(한번에 출력위함)
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		for (int test_case =1;test_case<=T;test_case++) { //테스트케이스만큼 반복
			int size = Integer.parseInt(br.readLine()); // 크기
			int[][] G = new int [size][size]; // 그래프 크기x크기 배열 생성
			int center = size/2; // 중심값
			int sum = 0; // 합
			for (int i =0;i<size;i++) { // y축만큼 반복
				String row_input = br.readLine(); // 행 입력받기
				for (int j = 0;j<size;j++) { // 열 만큼 반복
					int dist;
					dist = Math.abs(center-i)+Math.abs(center-j); // 맨하탄 거리 계산
 					if (dist <=center) { //맨하탄 거리가 중심만큼 떨어져있다 => 정사각형 마름모 안에 있다.
						sum +=row_input.charAt(j)-'0'; // char->int 값 만들기
					}
					
				}
			}
			sb.append("#"+test_case+" "+sum+"\n"); // sb에 append
		}
		System.out.println(sb); // 결과출력

	}

}
