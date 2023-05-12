package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 연결 요소 : 서로 분리되어 있는 그래프
 */
public class Baekjoon_11724 {

    static int n, m, ans; // 정점의 개수, 간선의 개수, 연결 요소의 개수
    static ArrayList<Integer>[] list; // 인접 리스트
    static boolean[] visited; // 방문 여부 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문한 적이 없는 정점 탐색
                ++ans;
                dfs(i);
            }
        }
        System.out.println(ans);
    }

    static void dfs(int x) {
        visited[x] = true;

        for (int t : list[x]) {
            if (visited[t]) continue;
            dfs(t);
        }
    }
}
