package 공진호;

import java.util.Arrays;
import java.util.Scanner;

public class P025_BJ16926_배열돌리기1_시간초과 {


	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[3];
		arr[0] = scan.nextInt();
		arr[1] = scan.nextInt();
		arr[2] = scan.nextInt();
		Arrays.sort(arr);

		System.out.println(arr[1]);
		
	}

}
