package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 캠프에 사용할 문제는 두 문제 이상
 * 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 함
 * 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 함
 */

public class Baekjoon_16938 {

    static int n, l, r, x, cnt;
    static int[] levels;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        visited = new boolean[n + 1];
        levels = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(levels);

        for (int i = 2; i <= n; i++) {
            recursive(0, 1, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        System.out.println(cnt);
    }

    public static void recursive(int idx, int start, int num, int sum, int max, int min) {
        if (idx == num) {
            if (checkLevel(sum, max - min)) {
                cnt++;
            }

        } else {
            for (int i = start; i <= n; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                recursive(idx + 1, i + 1, num, sum + levels[i], Math.max(levels[i], max), Math.min(levels[i], min));
                visited[i] = false;
            }
        }
    }

    public static boolean checkLevel(int sum, int sub) {
        return !(sum < l || sum > r || sub < x);
    }
}
