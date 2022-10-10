package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class P053_SWEA7465_창용마을무리의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T  = Integer.parseInt(br.readLine());
		
		for(int t= 1;t<=T;t++) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // ArrayList 생성
			String[] input = br.readLine().split(" "); 
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			/* 입력 받기 */
			//arraylist 초기화
			for(int i = 0; i<N+1;i++) {
				list.add(new ArrayList<>());
			} // ArrayList생성
			
			
			for(int i = 0; i<M;i++){
				input = br.readLine().split(" ");
				int from = Integer.parseInt(input[0]); // 시작 
				int to = Integer.parseInt(input[1]); // 끝
				list.get(from).add(to); //인접리스트에 추가
				list.get(to).add(from); //양방향이므로 반대 인접리스트에도 추가
			}
			Queue<Integer> que = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			int count = 0;
			for(int i =1;i<N+1;i++) {
				if(!visited[i]) { // 방문하지 않았다면
					que.add(i); // 큐에 추가
					visited[i] = true; //방문 표시
					count++; // count 값 +1
					while(!que.isEmpty()) { //bfs 돌기 => 찾을 수 있는 노드 탐색
						int cur = que.poll(); //큐에서 빼기
						for(int num:list.get(cur)) { // 인접한 노드들에 대하여
							if(!visited[num]) { //방문하지 않았다면
								que.add(num); //큐에추가
								visited[num] = true; //방문 표시
							}
						}
						
					}
				}
			}
			
			bw.write("#"+t+" "+count+"\n");
		} // end testcase
		bw.flush();
		bw.close();
		
		
	}

}
