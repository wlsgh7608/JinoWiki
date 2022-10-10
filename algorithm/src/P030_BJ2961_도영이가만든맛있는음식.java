package 공진호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P030_BJ2961_도영이가만든맛있는음식 {
	
	static int[] sour;
	static int[] bitter;
	static int N;
	static int min = Integer.MAX_VALUE;
	static int count;
	
	public static void comb(int index ,int s, int b) {
		if(index==N) {
			if(count==0) return; // 음식을 하나도 선택하지 않은 경우
			else {
				min = min>Math.abs(s-b)? Math.abs(s-b):min; // 신맛과 쓴맛의 최소 차이
			}
			return;
		}
		for(int i = index;i<N;i++) {
			count++; //더한 갯수
			comb(i+1,s*sour[i],b+bitter[i]); //선택했을 경우
			count--; //개수 빼기
			comb(i+1,s,b); //선택하지 않았을 경우
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		String[] input = new String[2];
		for(int i = 0; i<N;i++) {
			input = br.readLine().split(" ");
			sour[i] = Integer.parseInt(input[0]);
			bitter[i] = Integer.parseInt(input[1]);
		}
		count= 0; //개수 초기화
		comb(0,1,0); //곱하기 때문에 1로
		bw.write(min+"");//결과
		bw.flush();
		bw.close();
		System.out.println(min);

	}

}
