package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P034_SWEA4012_요리사 {
	static int N; 
	static int[][] S; // 시너지 값
	static int[] A; // 선택된 A 배열
	static int[] B; // 선택된 B 배열
	static boolean[] isSelected; // 음식들 중 A가 선택한 것들 (B 리스트를 구하기 위함)
	static int sum; // 음식 시너지 합계
	static int[] favor; // 음식들 중 2개 저장하는 배열
	static int minDiff ; // 최소 차이
	
	//음식들중 2개씩 뽑아 시너지를 더하는 함수
	static void getFlavor(int[] arr,int depth,int start) {
		if(depth == 2) {
			int x = arr[favor[0]]; // favor[0] : 음식들 중 뽑은 첫 번째
			int y = arr[favor[1]]; // favor[1] : 음식들 중 뽑은 두 번째
			
			sum+= S[x][y]+ S[y][x]; // 두 음식들의 시너지 합
			return;
		}
		for (int i = start;i<arr.length;i++) {
			favor[depth] = i; //i인덱스 선택
			getFlavor(arr, depth+1, i+1);
		}
	}
	
	//음식의 합을 반환 하는 함수   arr : 어느 한 손님의 음식들
	static int tasteSum(int[] arr) {
		sum = 0; //합계 0으로 초기화
		favor = new int[2]; // 2개의 음식 시너지를 구하기 위한 인덱스
		// 2개씩 뽑아야 함
		getFlavor(arr, 0, 0);
		return sum;
	}
	
	
	
	static void comb(int depth,int start) {
		if (depth ==N/2) { // A를 다 뽑은 경우
			
			int b= 0;
			for (int i =0;i<N;i++) {
				if (!isSelected[i]) { // 선택되지 않은 것은 B
					B[b++] = i; 
				}
			}
			// A의 음식 맛 합계
			int a_sum = tasteSum(A); //A의 합계
			// B의 음식 맛 합계
			int b_sum = tasteSum(B); //B의 합계
			minDiff = Math.min(minDiff, Math.abs(a_sum-b_sum)); // 최소차이값 업데이트
			
			return;
		}
		for(int i = start;i<N;i++) {
			if(!isSelected[i]) { // i인덱스가 선택되지 않았다면
				A[depth] = i; //A에 저장 
				isSelected[i] = true;
				comb(depth+1,i+1);
				isSelected[i] = false;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t<=tc;t++) {
			minDiff = Integer.MAX_VALUE; // 최소값 MAX_VALUE로 할당
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			isSelected = new boolean[N]; 
			A = new int[N/2]; // A와 B는 정확히 반씩 나눔 (N : 짝수)
			B = new int[N/2];
			for(int i = 0;i<N;i++) {
				String[] input = br.readLine().split(" ");
				for(int j =0;j<N;j++) {
					S[i][j] = Integer.parseInt(input[j]); // 음식 시너지 저장
				}
			}
			comb(0,0);
			
			sb.append("#"+t+" "+minDiff).append("\n");
		}
		System.out.println(sb);

	}

}
