package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P021_SWEA1233_사칙연산유효성검사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	static int isTrue(int n) throws Exception { // 트리가 연산할 수 있는 지 판단
		int result = 1; // 1로 초기화 
		for(int i = 0; i<n;i++) { // 노드의 수만큼 반복
			String[] data = br.readLine().split(" "); // 데이터를 공백을 기준으로 나눔 
			int size = data.length; // 나눈 조각들의 크기 
			if (size ==2) { // 사이즈가 2이다 => 리프노드이다. => 숫자만 있어야 함 
				switch(data[1]) { // 연산자가 있을 경우 
				case "+":
				case "-":
				case "*":
				case "/":
					result = 0; // 0으로 할당
				}
			} 
			else if(size==3) { // 사이즈가 3이다. => 자식이 하나만 있다 => 연산 불가 
				result = 0;
			}
			else if (size ==4) { // 사이즈가 4이다. => 자식이 2개 있다. => data값이 연산자 
				try {
					Integer.parseInt(data[1]); // 데이터를 숫자로 바꾸는 시도
					result = 0; // 윗문장에서 오류나지 않는 경우 ( 숫자인 경우 ) result 0으로 할당 
				}
				catch(Exception e) {
					// 해당 노드가 연산자인 경우
					// 더 정확하게 하려면 두 자식이 해당 노드의 자식인지 판단해야 함 . 왼쪽자식 = 2n , 오른쪽 자식 = 2n+1
					int parent = Integer.parseInt(data[0]);
					int left= Integer.parseInt(data[2]);
					int right = Integer.parseInt(data[3]);
					if (left != 2*parent || right != 2*parent+1) { // 자식이 맞지 않는 경우
						result = 0;
					}
				}
			}
			}
		return result;
		
		
	}
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int test_case= 1;test_case<=10;test_case++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#"+test_case+" "+isTrue(n)).append("\n");
		}
		System.out.println(sb);
			
	}
		

}
