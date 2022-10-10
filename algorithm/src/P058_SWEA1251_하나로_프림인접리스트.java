package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class P058_SWEA1251_하나로_프림인접리스트 {
	
	static class Node implements Comparable<Node>{ //오름차순
		int no;
		long weight;
		public Node(int no, long weight) {
			this.no = no; // 입력받을 것으로 설정
			this.weight = weight;// 입력받을 것으로 설정
		}
		@Override
		public int compareTo(Node o) { // 길이를 오름차순으로 정렬
			return Long.compare(this.weight, o.weight);
		}
	}

	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int TC = Integer.parseInt(br.readLine());
	    for (int t = 1; t < TC+1; t++) { // TC 개수만큼 반복
			int N = Integer.parseInt(br.readLine());
			
			String []input = br.readLine().split(" ");
			int []x = new int [N]; //x 저장용 배열
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(input[i]);
			}
			input = br.readLine().split(" ");
			int []y = new int [N]; //y 저장용 배열
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(input[i]);
			}
			
			double tax = Double.parseDouble(br.readLine());  // 세금

			ArrayList<ArrayList<Node>> list = new ArrayList<>(); // 연결 상태 넣어줄 ArrayList
			for (int i = 0; i < N; i++) {
				list.add(new ArrayList<>()); 
				for (int j = 0; j < y.length; j++) {
					long lenx = x[i]-x[j];  // 두 지점간의 x차이
					long leny = y[i]-y[j]; // 두 지점간의 y차이
					long distance = (lenx*lenx) + (leny*leny); //거리구하기
					list.get(i).add(new Node(j,distance)); // 노드를 생성하여 인접리스트에 추가
					//리스트의 i번째에 j까지의 거리를 넣음
					//list[i] = (j,거리)
				}
			}//연결 거리 표시
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean []visited = new boolean[N]; //방문 표시할 배열 
			long total =0; // 총 합 
			int count =0; // 개수
			pq.add(new Node(0,0));//0번째부터 탐색 시작
			
			while(!pq.isEmpty()) {//큐가 빌때까지
				Node node = pq.poll(); //꺼낸 노드
				
				
				if(!visited[node.no]) { // 방문하지 않았다면
					visited[node.no] = true; //방문 표시
					total+=node.weight; //총 합에 추가
					if(++count ==N) break; // 모든 노드를 찾았다면 break;
					
					for (Node cur:list.get(node.no)) { // 인접한 노드들에 대하여
						if(!visited[cur.no]) { //방문하지 않았다면
							pq.add(cur); // 큐에 추가
						}
						
					}
				}	
			}
			bw.write("#"+t+" "+Math.round(total*tax)+"\n"); // 최종거리에 세금 곱해서 결과 출력
		}// testcase end
	    
		bw.flush();
		bw.close();
	    
	}

}
