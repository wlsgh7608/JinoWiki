package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P051_SWEA3289_서로소집합 {
	
	static int find(int v) { //find
		if(parent[v] == v) { //v의 부모가 자기 자신일 때는 리턴
			return v;
		}
		return parent[v] = find(parent[v]); // path compression
	}
	
	static void union(int a, int b) { //a b 합집합
		int aRoot = find(a); //a의 루트
		int bRoot = find(b); //b의 루트
		if( aRoot< bRoot) { //a의 루트가 b루트보다 작으면 
			parent[bRoot] = aRoot; //b루트 재할당
		}else { //b의 루트가 a의 루트보다 작으면
			parent[aRoot] = bRoot; //a루트 재할당
		}
		
	}
	static int sameParent(int a,int b) { //같은 집합인지 찾기
		int aRoot = find(a); // a루트 
		int bRoot = find(b); // b루트
		if(aRoot == bRoot) { // a루트와 b루트가 같으면
			return 1; //1 리턴
		}else { //같지 않다면
			return 0; // 0 리턴
		}
		
	}
	
	static int[] parent; //부모를 저장하는 배열
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T;t++) { //TC개 만큼 반복
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			parent = new int[n+1];
			for(int i = 1;i<n+1;i++) {
				parent[i] = i;  //부모값 초기화
			}
			sb.append("#"+t+" ");
			for(int i =0;i<m;i++) {
				input = br.readLine().split(" ");
				int op = Integer.parseInt(input[0]); // 수행연산 0(합집합), 1(같은집합인지)
				int a = Integer.parseInt(input[1]);
				int b = Integer.parseInt(input[2]);
				
				if (op == 0){ //0일 경우
					union(a,b); //합집합 수행
					//union
				}else {
					sb.append(sameParent(a, b)); // same parent; // 같은 부모인 지 체크
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
		

	}

}
