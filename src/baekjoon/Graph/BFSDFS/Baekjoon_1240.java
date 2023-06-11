package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1240 {

    static int n, m, total;
    static List<Node>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, dist));
            list[e].add(new Node(s, dist));
        }

        for (int i = 0; i < m; i++) {
            total = 0;
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            dfs(s, e, 0);
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int goal, int sum) {
        visited[x] = true;
        if (x == goal) { // 도착해야 할 노드
            sb.append(sum).append('\n');
            return;
        }

        for (Node n : list[x]) {
            if (visited[n.e]) continue;

            dfs(n.e, goal, sum + n.dist);
        }
    }
}

class Node {
    int e;
    int dist;

    public Node(int e, int dist) {
        this.e = e;
        this.dist = dist;
    }
}

