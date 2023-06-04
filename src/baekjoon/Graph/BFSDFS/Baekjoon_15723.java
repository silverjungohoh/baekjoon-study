package baekjoon.Graph.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_15723 {

    static List<Integer>[] list;
    static int n, m;
    static boolean check;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new List[26];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            list[start - 'a'].add(end - 'a');
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            visited = new boolean[26];
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);

            dfs(start - 'a', end - 'a');

            if (check) {
                sb.append('T').append('\n');
            } else {
                sb.append('F').append('\n');
            }
            check = false;
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int end) {
        visited[x] = true;
        if (x == end) {
            check = true;
            return;
        }

        for (int i : list[x]) {
            if (visited[i]) continue;

            dfs(i, end);
        }
    }
}
