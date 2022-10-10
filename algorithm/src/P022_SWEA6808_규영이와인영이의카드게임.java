package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P022_SWEA6808_규영이와인영이의카드게임 {
	static int[] arr; // 인영이의 카드들 
	static boolean[] isSelected; // 인영이의 카드 선택
	static int[] GyuCards; //규영이의 카드 숫자들 
	static int win ; // 이긴 횟수
	static int lose;  // 진 횟수
	
	public static void perm(int depth,int sum) {
		if (depth == 9) {
			if(sum>0) { // 규영이가 이김
				win++;
			}else if (sum<0) { // 규영이가 짐 
				lose++;
			}
			return;
		} 
		
		for(int i = 0; i<9;i++) {
			if (!isSelected[i]) { // 현재 인덱스가 선택되지 않았다면
				isSelected[i] = true; // 해당 인덱스 true
				int newSum = 0;
				if(GyuCards[depth]>arr[i]) { // 규영이의 카드가 더 큰 경우 
					newSum = (GyuCards[depth]+arr[i]);  // 카드의 합 더하기 
				}
				else if (GyuCards[depth]< arr[i]) { // 규영이의 카드가 더 작은 경우 
					newSum = -1*(GyuCards[depth]+ arr[i]); // 카드의 합 뺴기
				}
				
				perm(depth+1,sum+newSum); // 순열 깊이+1
				isSelected[i] = false; // 다시 해당 인덱스 false
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N= Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=N;test_case++) {
			win = 0;
			lose = 0;
			boolean [] isSelectedCards = new boolean[19]; // 인영이의 카드를 찾기 위한 전체 카드뭉치 
			GyuCards = new int[9]; // 규영이의 카드 생성
			arr = new int[9]; // 인영이의 카드 생성
			isSelected = new boolean[9]; // 인영이의 선택된 카드들 
			String[] inputs = br.readLine().split(" "); // 공백을 기준으로 나눔
			for(int i = 0; i<9;i++) {
				GyuCards[i]=Integer.parseInt(inputs[i]); // 규영이의 카드 숫자 저장 
				isSelectedCards[GyuCards[i]] = true; 
			}
			int p = 0;
			for (int i = 1;i<19;i++) { // 전체 카드 뭉치에서 규영이가 선택하지 않은 숫자를 구함
				if (!isSelectedCards[i]) {
					arr[p++] = i;
				}
			}
			perm(0,0);
			sb.append("#"+test_case+" "+win+" "+lose).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
