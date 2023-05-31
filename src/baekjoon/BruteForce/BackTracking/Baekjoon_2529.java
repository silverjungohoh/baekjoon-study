package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0부터 9까지의 정수
 * 첫 자리가 0인 경우도 정수에 포함
 */

public class Baekjoon_2529 {

    static int k;
    static long max, min;
    static int[] selected, sign;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        sign = new int[k];
        selected = new int[k + 1];
        visited = new boolean[10]; // 0~9까지의 정수 방문 확인

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            if (st.nextToken().equals("<")) {
                sign[i] = 0;
            } else {
                sign[i] = 1;
            }
        }
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        recursive(0);

        if (min > Math.pow(10, k)) {
            sb.append(max).append('\n').append(min);
        } else {
            sb.append(max).append('\n').append("0" + min);
        }
        System.out.println(sb);
    }

    public static void recursive(int idx) {
        if (idx == k + 1) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < k + 1; i++) {
                s.append(selected[i]);
            }
            max = Math.max(Long.parseLong(s.toString()), max);
            min = Math.min(Long.parseLong(s.toString()), min);
        } else {
            int tmp = idx > 0 ? selected[idx - 1] : -1;
            for (int i = 0; i < 10; i++) {
                if (visited[i]) continue;

                if (idx > 0) {
                    if (sign[idx - 1] == 0) {
                        if (tmp >= i) continue;
                    } else {
                        if (tmp <= i) continue;
                    }
                }

                selected[idx] = i;
                visited[i] = true;

                recursive(idx + 1);

                selected[idx] = -1;
                visited[i] = false;
            }
        }
    }
}
