package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P046_SWEA3234_준환이의양팔저울 {
	static int[] weight;
	static int N;
	static int count;
	
	public static void perm(int depth, int left_sum, int right_sum,int flag) {
		if(depth ==N) { // depth 이 N이라면
			count++; // count 하나 늘리기 
			return;
		}
		for (int i = 0;i<N;i++) {
			if((flag&(1<<i))==0 ) { // i가 선택하지 않았다면
				perm(depth+1,left_sum+weight[i],right_sum,flag|1<<i); // 왼쪽에 추 추가
				if(left_sum>=right_sum+weight[i]) { // 오른쪽 저울에 추를 추가한 것이 더 작거나 같은 경우
					perm(depth+1,left_sum,right_sum+weight[i],flag|1<<i); // 오른쪽에 추 추가 
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t < TC + 1; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(input[i]);
			}
			count = 0;
			perm(0,0,0,0);
			bw.write("#"+t+" "+count+"\n");
		}
		bw.flush();
		bw.close();

	}

}
