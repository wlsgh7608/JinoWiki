package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P020_SWEA9229_한빈이와SpotMart {
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int TC = Integer.parseInt(br.readLine());
		for (int test_case  = 1 ; test_case<=TC;test_case++) {
			String[] inputs = br.readLine().split(" ");
			int N = Integer.parseInt(inputs[0]); // 과자 개수 
			int M = Integer.parseInt(inputs[1]); // 최대 가방 무게
			inputs = br.readLine().split(" ");
			int[] arr = new int [N]; // 과자들
			
			for (int i = 0 ; i< N;i++) {
				arr[i] = Integer.parseInt(inputs[i]);
			}
			
			int max_num = -1; // 최대 무게 
			for (int i = 0;i<N;i++) {
				for (int j = i+1;j<N;j++) {
					if(arr[i]+arr[j] <=M) { // 두 개의 무게가 M보다 작을 경우 
						max_num = Math.max(max_num, arr[i]+arr[j]); // 최대 무게 할당
					}
				}
			}
			sb.append("#"+test_case+" "+max_num).append("\n");
			
		}
		System.out.println(sb);
		
	}			

}
