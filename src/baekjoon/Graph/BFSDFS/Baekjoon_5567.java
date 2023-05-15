package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 자신의 친구와 친구의 친구를 초대
 * 양방향 , dfs 사용함
 */
public class Baekjoon_5567 {

    static int n, m;
    static ArrayList<Integer>[] list; // 인접 리스트
    static boolean[] visited;

    static Set<Integer> ans = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1, 1);
        System.out.println(ans.size());
    }

    static void dfs(int x, int depth) {

        if (depth > 2) { // 친구의 친구 범위를 벗어나면 탐색 X
            return;
        }

        visited[x] = true;

        for (int t : list[x]) {
            if (visited[t]) continue;

            dfs(t, depth + 1);
            ans.add(t);
        }
    }
}
