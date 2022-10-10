package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P060_BJ10971_외판원순회2 {
	static int[][] map;
	static int[] route;
	static boolean[] isSelected;
	static int N;
	static int min_dist = Integer.MAX_VALUE;
	public static void dfs(int depth,int sum) {
		if (depth == N) {
			if(map[route[N-1]][route[0]]==0)return; // 마지막 방문한 노드에서 출발 노드로  갈 수 없다면
			sum+=map[route[N-1]][route[0]]; // 마지막 방문한 노드에서 출발 노드 거리값 더하기
			min_dist = sum <min_dist ?sum:min_dist; //최소값 업데이트
			return;
		}
		for(int i = 0; i<N;i++) {
			if(!isSelected[i]) { // 방문하지 않았다면
				isSelected[i]= true; //방문 표시
				route[depth] = i; // 현재 길 저장 
				if (depth ==0) {// 첫방문이라면 
					dfs(depth+1,sum); 
				}//그 외 방문이라면, 갈  수 있는지, 갈 수 있다면 거리의 합이 최소값보다 작은지
				else if (map[route[depth-1]][i]>0 && sum+map[route[depth-1]][i]<min_dist){ 
					dfs(depth+1,sum+map[route[depth-1]][i]); // 깊이 하나 늘리고, 거리를 늘려 재귀호출
				}
				isSelected[i]= false; //방문 표시 풀기.
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		map = new int[N][N]; // 비용행렬 저장
		isSelected = new boolean[N]; // 방문한 노드인지 체크용
		route = new int[N]; //현재까지 온 루트를 저장하기 위나 배열
		
		for(int i = 0; i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0 ; j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		/* 입력 */
		dfs(0,0);
		System.out.println(min_dist);

	}

}
