package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P052_SWEA3124_최소스패닝트리 {
	static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost; // 가중치 오름차순으로 정렬
		}

	}

	static int[] parent;
	static PriorityQueue<Node> que;

	public static int find(int v) { //부모찾기
		if (parent[v] == v)return v; // 부모노드가 본인이면 반환

		return parent[v] = find(parent[v]); //부모노드 찾기
	}

	public static void union(int a, int b) {
		int aRoot = find(a); //a가 포함된 집합의 root
		int bRoot = find(b); //b가 포함된 집합의 root

		if (aRoot < bRoot)parent[bRoot] = aRoot; // 더 작은 쪽으로 합치고
		else parent[aRoot] = bRoot;// 더 작은 쪽으로 합치고

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			String[] input = br.readLine().split(" ");
			int V = Integer.parseInt(input[0]);
			int E = Integer.parseInt(input[1]);

			parent = new int[V+1]; 
			for (int i = 1; i < V+1; i++) {
				parent[i] = i; //부모 값 초기화
			}
			que = new PriorityQueue<>(); // 우선순위큐 생성
			for (int i = 0; i < E; i++) {
				input = br.readLine().split(" ");
				int a =Integer.parseInt(input[0]); // start
				int b =Integer.parseInt(input[1]); // end 
				int c =Integer.parseInt(input[2]); // weight
				que.offer(new Node(a,b,c)); //간선들을 큐에 넣기
			}
			//큐의 노드들은 cost값이 오름차순으로 정렬
			long sum =0;
			while(!que.isEmpty()) { // 큐가 비어있을때까지
				Node cur = que.poll(); // 현재 노드 뽑기
				
				if(find(cur.start)!=find(cur.end)) { // 사이클이 아니라면
					union(cur.start, cur.end); // union
					sum+=cur.cost; //가중치 더하기
				}
			}
			
			bw.write("#"+t+" "+sum+"\n"); //결과 출력

		} // end testcase
		bw.flush();
		bw.close();

	}

}
