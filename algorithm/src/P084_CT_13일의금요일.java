package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P084_CT_13일의금요일 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// mod 값이 0 이되어야 금요일
		int year = 2022;
		int month = 10;
		int day = 13;
		int[] monthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		while (true) {
			int checkDay = day % 7; // 요일 계산
			if (checkDay == 0) { // 금요일이라면
				System.out.println(year + "년 " + month + "월");
				break;
			}

			day = day + monthDay[month]; // 각 월당 해당하는 일 수를 더함
			if (month == 2) {
				if (year % 400 == 0) { // 윤년
					day++;
				} else if (year % 100 == 0) { // 윤년 아님

				} else if (year % 4 == 0) { // 윤년
					day++;
				}
			}
			month++;
			if (month == 13) {
				month = 1;
				year++;
			}

		}

	}

}
