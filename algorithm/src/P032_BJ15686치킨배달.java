package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class P032_BJ15686치킨배달 {

	static List<Integer> chickX; // 치킨집 위치
	static List<Integer> chickY; // 치킨집 위치
	static List<Integer> houseX; // 집 위치
	static List<Integer> houseY; // 집 위치
	static int[][] map;
	static int[] select;
	static int count;
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static int comb_cnt = 0;
	
	public static void comb(int index) { //치킨집 조합
		if(count==M) {
			comb_cnt+=1;
			int temp = 0;
			for(int i = 0;i<houseX.size();i++) { //치킨집과의 거리 구하기 
				int sum = Integer.MAX_VALUE; //sum값 초기화 
				for(int j =0;j<M;j++) {
					int a = Math.abs(houseX.get(i) -chickX.get(select[j])) +Math.abs(houseY.get(i)-chickY.get(select[j]));
					sum = sum>a? a:sum; // 더 작은 값을 sum에 저장
				}
				temp+= sum;// 현재 치킨집들과의 거리 합
			}
			min = min>temp ? temp:min; //최소값
			return;
		}
		for(int i = index;i<chickX.size();i++) { //치킨집의 수만큼 반복
			select[count] = i;
			count++;
			comb(i+1); // 선택 
			count--; //빠져나올때는 count-1 
		}
		
	}
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][N];
		houseX = new ArrayList<>();
		houseY = new ArrayList<>();
		chickX = new ArrayList<>();
		chickY = new ArrayList<>();
		select = new int[M];
		
		for (int i = 0 ; i<N;i++) {
			input = br.readLine().split(" ");
			for(int j =0; j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j] ==1) { // 집
					houseX.add(i); //집 좌표 저장
					houseY.add(j);
				}else if (map[i][j] ==2){ // 치킨 집
					chickX.add(i); //치킨집 좌표저장
					chickY.add(j);
				}
			}
		}
		
		count = 0;
		comb(0); // 치킨집 구하기 호출
		bw.write(min+"");
		bw.flush();
		bw.close();
		

	}

}
