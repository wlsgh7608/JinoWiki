package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P037_JO1828_냉장고 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		int[][] t = new int[N][2];
		
		for (int i =0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			t[i][0] = Integer.parseInt(input[0]);
			t[i][1] = Integer.parseInt(input[1]);
		}
		// 끝 온도를 기준으로 정렬
		Arrays.sort(t, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; //1번쨰 인덱스(끝 온도)를 기준으로 비교
			}
		});
		
		int cnt = 1; // 첫번 째 냉장고
		int end_temp = t[0][1];  //첫 번쨰 냉장고의 끝 온도
		for(int i = 1;i<N;i++) {
			if (t[i][0] >end_temp) { // 현재 냉장고가 커버할 수 없는 음식일 경우
				cnt++; // 냉장고 개수 늘리고
				end_temp = t[i][1]; // 냉장고의 끝온도 업데이트
			}
		}
		System.out.println(cnt);
		

	}

}
