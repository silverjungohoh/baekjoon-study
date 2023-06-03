package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 단방향
 */

public class Baekjoon_21937 {

    static int n, m, k, cnt;
    static List<Integer>[] list; // 인접 리스트
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }
        k = Integer.parseInt(br.readLine());
        dfs(k);
        System.out.println(cnt - 1);
    }

    public static void dfs(int x) {
        visited[x] = true;
        cnt++;

        for (int i : list[x]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }
}
