package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_25516 {

    static int n, k, ans;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] apple;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];
        apple = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int x, int depth) {
        if (depth == k + 1) {
            return;
        }
        visited[x] = true;
        ans += apple[x];

        for (int i : list[x]) {
            if (visited[i]) continue;

            dfs(i, depth + 1);
        }
    }
}