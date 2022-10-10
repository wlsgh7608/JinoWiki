package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P001_SWEA1289_원재의메모리복구하기{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String answer = br.readLine();
            char current = '0';
            int cnt = 0;
            for (int i = 0; i<answer.length();i++) {
            	char c = answer.charAt(i);
            	if (c == current) {
            		continue;
            	}
            	else {
            		current = c;
            		cnt+=1;
            	}
            }
            System.out.println("#"+test_case+" "+cnt);

		}
	}
}