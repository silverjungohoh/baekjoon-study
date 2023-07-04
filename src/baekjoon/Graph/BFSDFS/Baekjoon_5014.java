package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 고층 건물 f층 / 회사 위치 g층 / 강호 위치 s층 / 위로 u층 아래로 d층 이동 가능
 * 눌러야 하는 버튼의 수의 최솟값을 출력
 * 회사 위치와 강호 위치가 동일한 경우 정답은 0이 됨
 */

public class Baekjoon_5014 {

    static int f, s, g, u, d, cnt;
    static int[] elevator;
    static boolean[] visited;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        dx = new int[]{-d, u};
        elevator = new int[f + 1];
        visited = new boolean[f + 1];

        if (s == g) { // 강호와 회사 위치가 동일한 경우 (탐색할 필요 x)
            System.out.println(0);
        } else {
            bfs(s);
            System.out.println(cnt == 0 ? "use the stairs" : cnt);
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int next = now + dx[i];
                if (checkRange(next) && !visited[next]) {
                    queue.offer(next);
                    elevator[next] = elevator[now] + 1;
                    visited[next] = true;

                    if (next == g) {
                        cnt = elevator[next];
                    }
                }
            }
        }
    }

    public static boolean checkRange(int x) {
        return (x >= 1 && x <= f);
    }
}
