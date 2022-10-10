package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P039_BJ1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine(); 
		String[] temp = line.split("\\-|\\+"); // 숫자만 뽑기위하여 -,+ 을 기준으로 스플릿
		int size = line.split("-")[0].split("\\+").length; // 맨처음 - 앞의 숫자 개수
		
		int sum = 0;
		for(int i = 0; i<size;i++) { // - 앞의 숫자 개수만큼은 더하고
			sum += Integer.parseInt(temp[i]);
		}
		for (int i = size;i<temp.length;i++) { // 그 외 숫자는 빼준다.
			sum-= Integer.parseInt(temp[i]);
		}
		System.out.println(sum);
		
		
		

	}

}
