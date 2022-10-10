package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class P015_BJ12891_DNA비밀번호 {
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Character,Integer> M = new HashMap<>();
		
		// 문자 => cnt_box idx 반환
		M.put('A',0);
		M.put('C',1);
		M.put('G',2);
		M.put('T',3);
		
		String[] inputs = br.readLine().split(" ");
		int S = Integer.parseInt(inputs[0]);
		int P = Integer.parseInt(inputs[1]);
		String str = br.readLine();
		inputs = br.readLine().split(" ");
		int[] requirements = new int[inputs.length]; // A C G T 요구사항
		for (int i = 0; i<inputs.length;i++) {
			requirements[i] = Integer.parseInt(inputs[i]); // 요구사항 개수 저장
		}
		int[] current_box = new int[4];	 //현재 상황의 A,C,G,T 개수
		int cnt = 0; // 정답 개수
		
		for (int i = 0;i<S;i++) {
			int box_idx =  M.get(str.charAt(i));
			if (i<P) {
				current_box[box_idx]++; // 현재 인덱스가 P보다 작은 경우 채우는 것만 수행
			} else { // 현재 인덱스가 P보다 크거나 같은 경우 
				int minus_idx = M.get(str.charAt(i-P)); 
				current_box[box_idx] ++; // 현재의 인덱스의 문자수는 늘리고
				current_box[minus_idx]--; // 현재의 (인덱스-P)의 문자수는 하나 빼야함
			}
			if(i>=P-1) { // 현재의 부분집합이 요구사항이 만족하는 지 확인
				for (int k = 0; k<4;k++) {
					if(current_box[k] < requirements[k]) { // 개수가 요구사항보다 적은 경우
						break;
					}
					if (k ==3) { // A,C,G,T 모두 만족하는 경우
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
	}

}
