package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 동생을 찾을 수 있는 가장 빠른 시간
 * 수빈이가 동생보다 앞에 있는 경우도 고려
 */

public class Baekjoon_1697 {

    static int n, k; // 수빈 위치 & 동생 위치
    static int[] result = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        System.out.println(result[k]);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        result[x] = 0;
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int[] dx = new int[]{now - 1, now + 1, now * 2};

            for (int i = 0; i < 3; i++) {
                int xx = dx[i];

                if (xx > 100000 || xx < 0) continue; // 범위 벗어나면 안됨
                if (visited[xx]) continue;
                visited[xx] = true;

                result[xx] = result[now] + 1;

                if (xx == k) break;
                queue.offer(xx);
            }
        }
    }
}
