package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> S = new Stack<>();
		HashMap<Character,Character> M = new HashMap<>(); // 세트를 찾기 위한 해쉬맵
		
		StringBuilder sb = new StringBuilder();
		M.put('[', ']'); // [   ] 는 세트
		M.put('(', ')'); // (   ) 는 세트
		M.put('{', '}'); // {   } 는 세트
		M.put('<', '>'); // <   > 는 세트
		
		
		for (int test_case = 1; test_case<=10;test_case++) {
			S.clear(); // 스택에 남아있을수 있으니 비움
			
			int N = Integer.parseInt(br.readLine()); // 입력크기
			String inputs = br.readLine();
			for (int i = 0;i<N;i++) {
				char current = inputs.charAt(i); // 현재 문자 
				if (S.size()>0 && M.get(S.peek()) == current) { // 스택에 내용이 남아 있는 경우
					S.pop(); // 같을 시 pop
					continue;
				}
				S.add(current);
				if(M.containsValue(current)) { //만약 닫는문자가 들어오는 경우
					break; //반복문을 빠져나옴
				}
				
				
			}
			int result = 0; // 결과값 초기화 
			if (S.size()==0) { // 스택에 아무것도 없는 경우
				result = 1; // 참 
			}
			
			
			sb.append("#"+test_case+" "+result).append("\n");
		}
		System.out.println(sb);
	}

}
