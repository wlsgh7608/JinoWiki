package 공진호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P003_BJ1244_스위치켜고끄기 {
	public static int switch_btn(int btn) {
		if (btn==0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void switch_male(int[] arr ,int idx) {
		int current = idx+1;
		int i = 1;
		while (current*i <= arr.length) {
			arr[current*i-1] = switch_btn(arr[current*i-1]);
			i++;
		}
	}
	
	public static void switch_female(int[] arr,int idx) {
		int i=0;
		while ((idx-i)>=0 &&(idx+i)<arr.length) {
			if(arr[idx-i] == arr[idx+i] ) {
				if (i ==0) {
					arr[idx] = switch_btn(arr[idx]);
				}
				else {
					arr[idx-i] = switch_btn(arr[idx-i]);
					arr[idx+i] = switch_btn(arr[idx+i]);
				}
				i++;
			}
			else {
				break;
			}
		}
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i< n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int student_n  = Integer.parseInt(br.readLine());
		for (int i =0 ; i<student_n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken())-1;
			
			if (s==1) {
				switch_male(arr, idx);
				
			}else {
				switch_female(arr, idx);
				
			}
			
		}
		
		for (int i = 0; i<arr.length;i++) {
			if (i>0 && i%20 == 0) {
				sb.append("\n");
			}
			sb.append(arr[i]+" ");
			
		}
		System.out.println(sb);

	}

}
