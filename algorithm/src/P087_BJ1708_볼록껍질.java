package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P087_BJ1708_볼록껍질 {
	static class Point implements Comparable<Point> {
		long x;
		long y;

		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y == o.y) {
				return Long.compare(this.x, o.x);
			}
			return Long.compare(this.y, o.y);
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static class Vect implements Comparable<Vect> {
		Point p;
		double angle;
		double dist;

		public Vect(Point p, double outer, double dist) {
			super();
			this.p = p;
			this.angle = outer;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vect o) {
			if (this.angle == o.angle) {
				return Double.compare(this.dist, o.dist);
			}
			return -1 * Double.compare(this.angle, o.angle);
		}

		@Override
		public String toString() {
			return "Vect [p=" + p + ", angle=" + angle + ", dist=" + dist + "]";
		}

	}

	static double getDistance(Point a, Point b) {
		long dist = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		return Math.pow(dist, 0.5);
	}

	static double getAngle(Point a, Point b) {

		return Math.atan2((b.x - a.x), (b.y - a.y));
	}

	static boolean isCCW(Point a, Point b) {

		long result = a.x * b.y - a.y * b.x; // 외적

		if (result > 0) { // 0보다 크면 반시계
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		Collections.sort(list); // x,y 정렬(1순위 y , 2순위 x)
		Point start = list.remove(0);
		List<Vect> listVect = new ArrayList<>(); // 각도, 거리  저장할 리스트
		for (Point p : list) {
			double angle = getAngle(start, p); //각도 계산
			double dist = getDistance(start, p); // 거리 계산
			listVect.add(new Vect(p, angle, dist));
		}

		Collections.sort(listVect); // 1순위(각도, 2순위 거리)

		Stack<Point> answer = new Stack<>();
		answer.add(start); // 첫 번째
		Point s = listVect.get(0).p;
		answer.add(s); // 두 번쨰는 스택에 추가
		for (int i = 1; i < listVect.size(); i++) {
			Point cur = listVect.get(i).p;
			s = answer.peek();
			Point f = answer.get(answer.size() - 2);
			Point curVec = new Point(cur.x - s.x, cur.y - s.y); // 현재값과 스택의 top백터
			Point lVec = new Point(s.x - f.x, s.y - f.y); //스택의 벡터
			if (isCCW(lVec, curVec)) { //반시계방향
				answer.add(cur); // 스택에 추가
			} else {
				answer.pop();
				if (answer.size() >= 2) {
					while (answer.size() >= 2) {

						Point a = answer.get(answer.size() - 2); //스택에서 2번째
						Point b = answer.peek(); // 스택의 top
						Point c = cur;
						if (isCCW(new Point(b.x - a.x, b.y - a.y), new Point(c.x - b.x, c.y - b.y))) { // 반시계라면
							answer.add(cur); // 스택에 추가
							break; //while문 빠져나오기
						}
						answer.pop(); //스택에서 빼기
					}

				} else {
					answer.add(cur);
				}
			}
		}
		System.out.println(answer.size());

	}

}
