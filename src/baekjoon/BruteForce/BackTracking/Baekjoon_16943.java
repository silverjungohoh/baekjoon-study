package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_16943 {

    static String a;
    static int b, ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = Integer.parseInt(st.nextToken());
        visited = new boolean[a.length()];

        ans = Integer.MIN_VALUE;
        recursive(0, 0);
        System.out.println(ans == Integer.MIN_VALUE ? -1 : ans);
    }

    public static void recursive(int idx, int num) {
        if(idx == a.length()) {
            if(num < b) {
                ans = Math.max(ans, num);
            }
        } else {

            for(int i = 0; i<a.length(); i++) {
                if(idx == 0 && a.charAt(i) - '0' == 0) continue;
                if(visited[i]) continue;

                visited[i] = true;
                recursive(idx + 1, num * 10 + a.charAt(i)-'0');
                visited[i] = false;
            }

        }
    }
}
