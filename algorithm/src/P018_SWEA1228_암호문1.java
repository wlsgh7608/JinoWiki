package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		for (int test_case = 1; test_case <=10;test_case++) {
			int N =  Integer.parseInt(br.readLine());
			String[] inputs = br.readLine().split(" ");
			List<String> l = new ArrayList<>();
			for (int i = 0; i<N;i++) {
				l.add(inputs[i]);
			}
			
			int M = Integer.parseInt(br.readLine());
			inputs  = br.readLine().split("I "); // I을 기준으로 나눔 
			for (int i = 1; i<inputs.length;i++) {
				String[] cmds = inputs[i].split(" "); // 이후 공백을 기준으로 나눔
				
				int start = Integer.parseInt(cmds[0]); // 첫 번째는 삽입할 인덱스
				int size = Integer.parseInt(cmds[1]); // 삽입할 숫자 개수
				for(int k = 1+size; k>1;k--) { // 삽입할 숫자를 끝에서 부터 시작하여 해당 index에 add
					l.add(start,cmds[k]);
				}
				
			}
			sb.append("#"+test_case+" "); // 10개만 출력
			for (int i = 0; i<10;i++) {
				sb.append(l.get(i)+" ");
			}
			sb.append("\n"); // 줄바꿈 
		}
		System.out.println(sb);
		
		
				
		

	}

}
