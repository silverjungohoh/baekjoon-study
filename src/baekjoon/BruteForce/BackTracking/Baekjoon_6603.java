package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순서 X , 중복 X
 */

public class Baekjoon_6603 {

    static int k;
    static int[] lotto, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            lotto = new int[k];
            visited = new boolean[50];
            selected = new int[6];

            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            recursive(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void recursive(int idx, int start) {
        if (idx == 6) {
            for (int i = 0; i < selected.length; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = start; i < lotto.length; i++) {
                if (visited[lotto[i]]) continue;

                selected[idx] = lotto[i];
                visited[lotto[i]] = true;

                recursive(idx + 1, i + 1);

                selected[idx] = 0;
                visited[lotto[i]] = false;
            }
        }
    }
}
