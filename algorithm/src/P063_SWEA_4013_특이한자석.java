package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;

public class P063_SWEA_4013_특이한자석 {
	
	static void rotate(Deque<Integer> deque,int isClock) {
		if(isClock == 1) {
			deque.addFirst(deque.pollLast());
		}else {
			deque.addLast(deque.pollFirst());
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			Deque<Integer>[] wheels = new Deque[4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					wheels[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for(int i =0; i<K;i++) {
				boolean[] isRotate = new boolean[4];
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int n = Integer.parseInt(st.nextToken())-1; // idx는 0부터 시작
				isRotate[n] = true;
				int d = Integer.parseInt(st.nextToken());
//				for(int i = n-1;i>-1;i--) {
//					if wheels[i].get
//					
//				}
			}

		} // end for
		System.out.println(sb);

	}

}
