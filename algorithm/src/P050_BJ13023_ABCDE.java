package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P050_BJ13023_ABCDE {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static boolean isTrue; // 
	
	static void dfs(int vertex,int depth) {
		if(isTrue) return;
		if(depth==5) { //깊이가 5라는 것은 A->B->C->D->E 가능하다!
			isTrue = true; // 정답을 찾음 => flag = true 
			return;
		}
		for(int next : list.get(vertex)) { // 인접 정점에 대하여 
			if(!visited[next]) { //방문하지 않았다면
				visited[next] = true; //방문 표시
				dfs(next,depth+1); //재귀
				if(isTrue) return; //답을 찾았다면 return;
				visited[next] = false; //방문 표시 해제
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		for (int i = 0; i < N; i++) { 
			list.add(new ArrayList<>()); // ArrayList 생성
		}
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]); // a
			int to = Integer.parseInt(input[1]); // b
			list.get(from).add(to); // 인접리스트에 추가
			list.get(to).add(from); // 양방향이므로 반대도 추가
		}

		// ------------BFS----------//
		visited = new boolean[N];
		isTrue = false;
		for (int i = 0; i < N; i++) {
			dfs(i,0); // dfs 호출

		} // end for
		if (isTrue) { // 답을 찾았다면
			System.out.println(1);
		} else { // 찾지 못했다면
			System.out.println(0);
		}

	}

}
