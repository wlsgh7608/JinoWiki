package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P043_SWEA1247_최적경로 {
	static int companyX; // 회사 X위치
	static int companyY; // 회사 Y위치
	static int homeX; // 집 X위치
	static int homeY; // 집 Y위치
	static int N; // 손님 수
	static int minD; //최소거리
	static boolean[] isSelected; // 선택유무 판단
	static int[] routes; // 손님 경로 저장을 위한 배열
	static int[] clientX; // 손님 X위치 저장
	static int [] clientY; // 손님 Y위치 저장
	
	static int getDistance(int x1,int y1,int x2,int y2) { // 거리 구하는 함수
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	static void dfs(int depth,int dist) {
		if (depth == N) {
			//마지막 손님이면 집과의 거리 체크
			int ans = dist+ getDistance(clientX[routes[N-1]], clientY[routes[N-1]], homeX, homeY); //현재까지의 거리
			minD = ans<minD?ans:minD; //최소 거리 저장
			
			return;
		}
		for(int i = 0;i<N;i++) {
			if(!isSelected[i]) { //방문하지 않은 손님이라면
				isSelected[i] = true; // 방문처리
				routes[depth] = i; //해당 손님 경로에 저장
				if(depth==0) { // 깊이가 0이라면 회사와의 거리를 구해야 함
					int d = getDistance(clientX[routes[depth]], clientY[routes[depth]], companyX, companyY);
					dfs(depth+1,dist+d);
				}
				else {
					// 그 외의 경우는 그 전경로의 손님의 위치와의 거리 구해야 함
					int d = getDistance(clientX[routes[depth]],clientY[routes[depth]], clientX[routes[depth-1]], clientY[routes[depth-1]]);
					dfs(depth+1,dist+d);
				}
				isSelected[i] = false;
			}
		}
		
		
		
			
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t =1;t<=TC;t++) {
			N = Integer.parseInt( br.readLine());
			String [] input = br.readLine().split(" ");
			isSelected = new boolean[N];
			routes = new int[N];
			minD = Integer.MAX_VALUE;
			clientX = new int[input.length/2 -2];
			clientY = new int[input.length/2 -2];
			companyX = Integer.parseInt(input[0]);
			companyY = Integer.parseInt(input[1]);
			homeX = Integer.parseInt(input[2]);
			homeY = Integer.parseInt(input[3]);
			
			for(int i = 4,j = 0; i<input.length;i = i+2,j++) {
				clientX[j] =Integer.parseInt(input[i]);
				clientY[j] =Integer.parseInt(input[i+1]);
			}
			dfs(0,0);
			sb.append("#"+t+" "+minD).append("\n");
		}
		System.out.println(sb);
		

	}

}
