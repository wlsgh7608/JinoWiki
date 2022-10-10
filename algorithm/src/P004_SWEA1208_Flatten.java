package 공진호;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class P004_SWEA1208_Flatten { // #7) 접근지정자는 default 

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼드리더를 통하여 입력받음
		StringBuilder  sb = new StringBuilder (); //#3 ) StringBuilder 추가 한번에 출력하기
		
		int T = 10; // 테스트 케이스는 10개
		int min_idx = 0;
		int max_idx = 99;
		
		for(int test_case = 1; test_case <= T; test_case++) //테스트 케이스만큼 반복
		{
			int dump = Integer.parseInt(br.readLine()); // 덤프 횟수
			List<Integer> arr = new ArrayList<>(); //리스트 생성
			
			String [] row = br.readLine().split(" "); //#2) split()으로 변경
			
			for(int i = 0; i<100;i++) { //블록은 무조건 100개 있음
				arr.add(Integer.parseInt(row[i])); // 공백을 기준으로 나누어 arr에 추가 
			}
			
			
			// 최댓값에서 하나 빼서 최솟값에 더 해주기
			while(dump-- > 0) { // 덤프 횟수가 없을 때까지
				Collections.sort(arr); // 최솟값과 최댓값을 구하기 위하여 정렬, Collections 정렬은 O(nlogn)이라고 한다.
				int min_n, max_n;  // 최소, 최대 값
				min_n = arr.get(0); // 0번째 인덱스는 최솟값
				max_n = arr.get(99); // 마지막 인덱스(99)는 최댓값
				if (max_n-min_n <=1) { // 최솟값과 최대값이 같을 시 
					break; // 반복문을 빠져나옴
				}
				arr.set(99, max_n-1); // 최대값의 블록을 하나 뺌
				arr.set(0,min_n+1); // 최소값의 블록을 하나 더함 
			}
			Collections.sort(arr); // 다시 정렬 
			int diff = arr.get(99)-arr.get(0); // 최대값과 최소값의 차이
			sb.append("#"+test_case+" "+diff).append("\n"); // #10) append("A").append("\n")으로
		}
		System.out.println(sb); // Stringbuilder 출력
		br.close();
	}
}
