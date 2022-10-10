package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P031_BJ3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] temp;
	static int[] ans;
	static boolean[] visited;
	static int count = 0;
	
	public static void comb( int start, int depth) {
		if(depth == 7) { // 뽑은 난쟁이의 수 
			if(count == 1) { //이미 합이 100인 난쟁이들을  찾았다면
				return;
			}
			int sum = 0;
			for (int i = 0; i<7;i++) {
				sum +=temp[i];
			} 
			if (sum ==100) { // 합이 100이라면 
				count++; //count를 1 늘림
				ans = Arrays.copyOf(temp,7); // temp의 배열을 복사하여 ans에 저장
			}
			return;
		}
		else {
			for(int i = start;i<9;i++) {
				if(!visited[i]) //방문하지 않았다면
				{
					visited[i] = true; //방문 표시
					temp[depth] = arr[i];
					comb(start+1,depth+1); // 재귀호출
					visited[i] = false;
				}
				
			}
			
		}
		
		
		
		
	}
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		arr = new int[9]; // 난쟁이들을 저장할 배열 
		temp = new int[7]; // 현재 뽑은 난쟁이들을 저장할 배열 
		visited = new boolean[9]; //방문표시를 위한 배열 
		for (int i = 0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0); // 조합 호출
		for (int i = 0; i<7; i++) {
			bw.write(ans[i]+"\n");
		}
		bw.flush();
		bw.close();
		

	}

}
