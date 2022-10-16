package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P083_BJ15961_회전초밥 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] dish = new int[N + k - 1];

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			dish[i] = n;
		}
		for (int i = 0; i < k - 1; i++) {
			dish[N + i] = dish[i];
		}

		int[] dishCnt = new int[d + 1];

		int result = 0;
		int maxDish = 0;

		for (int i = 0; i < k; i++) { // k-1번까지
			int cur = dish[i];
			if (dishCnt[cur] == 0) {
				result += 1;
			}
			dishCnt[cur] += 1;
		}
		maxDish = result; // 현재의 최대 초밥종류
		for (int i = k; i < N + k - 1; i++) { //k번 부터 슬라이딩 윈도우
			int cur = dish[i]; // 추가할 초밥이
			if (dishCnt[cur] == 0) { // 만약 새로운 종류라면
				result += 1; // +1
			}
			dishCnt[cur] += 1; // 추가할 현재 초밥의 개수 +1
			dishCnt[dish[i - k]] -= 1; // 뺄 초밥의 개수 -1
			if (dishCnt[dish[i - k]] == 0) { // 뺄 초밥이 없을 때
				result -= 1; // 
			}
			if (dishCnt[c] == 0) {
				maxDish = Math.max(maxDish, result + 1); //쿠폰이 없는 초밥이면 +1
			} else {
				maxDish = Math.max(maxDish, result); // 있는 초밥이라면 
			}


		}
		System.out.println(maxDish); // 결과 출력

	}

}
