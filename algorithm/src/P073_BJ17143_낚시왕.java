package 공진호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class P073_BJ17143_낚시왕 {
	static int result=0;
	static HashSet<Shark> hs;
	static HashMap<int[], List<Shark>> hm;
	static int R;
	static int C;
	static int[] dx = { -1, 0, 0, 1 }; // 상 우 좌 하
	static int[] dy = { 0, 1, -1, 0 }; // 상 우 좌 하

	static class Shark {
		int x;
		int y;
		int s;
		int d;
		int z;

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
		

	}

	static void fishing(int loc) { // 열에 대하여 체크
		int dist = Integer.MAX_VALUE;
		Shark fish = null;

		for (Shark shark : hs) { 
			if (shark.y == loc && shark.x < dist) { // 같은 열이고 x좌표(행)이 더 작으면 업데이트
				fish = shark;
				dist = shark.x;
			}

		}
		

		if (fish != null) {
			result += fish.z;
			hs.remove(fish);
		}
	}

	static void move() {
		HashSet<Shark> newHs = new HashSet<>();
		HashMap<String, Shark> hm = new HashMap<>();
		int dist;
		for (Shark shark : hs) {
			int sx = shark.x;
			int sy = shark.y;
			int sd = shark.d;
			boolean isUpDown = false; // 위아래로 가는 지 체크
			if (shark.d == 1 || shark.d == 2) { //좌우로감
				dist = C;
			} else { // 위아래로
				dist = R;
				isUpDown = true;
			}
			int speed = shark.s;
			if (dist > 1) {
				speed = (speed) % (2 * (dist - 1)); // 속력 = 속력%(2*(길이-1))
				// 상어의 방향을 알아야 함..........
				for (int t = 0; t < speed; t++) {
					sx = sx + dx[sd];
					sy = sy + dy[sd];
					if (isUpDown) {
						if (sx < 0 || sx >= R ) { // 머리콩
							sx -= 2*dx[sd]; //돌아가기
							sy -= 2*dy[sd];
							sd = 3 - sd; // 방향 전환
						}
					} else {
						if (sy <0 || sy >=C) { //머리콩
							sx -= 2*dx[sd]; // 돌아가기
							sy -= 2*dy[sd];
							sd = 3 - sd; // 방향 전환
						}
						
					}
				}
			}
			if (hm.containsKey(sx+" "+ sy)) { // 해쉬맵에 키가 존재하는 지 체크
				if (shark.z > hm.get(sx+" "+ sy).z) { // 존재하고 크기가 더 작다면
					hm.put(sx+" "+ sy, new Shark(sx, sy, speed, sd, shark.z)); // 업데이트
				}

			} else { // 값이 해쉬맵에 존재하지 않으면 추가
				hm.put(sx+" "+ sy, new Shark(sx, sy, speed, sd, shark.z));
			}

		} // end for
		for (Shark s : hm.values()) {
			newHs.add(s);
		}
		hs = newHs;

	}


	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 0);
		map.put(2, 3);
		map.put(3, 1);
		map.put(4, 2);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		hs = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			hs.add(new Shark(r - 1, c - 1, s, map.get(d), z));
		}
		int fisher = 0;
		while (fisher<C) {
			fishing(fisher);
			move();
			fisher++;
		}
		System.out.println(result);

	}

}

