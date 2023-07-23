package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 같은 수를 여러 번 골라도 ok
 * 중복되는 수열을 여러 번 출력 XX
 */

public class Baekjoon_15665 {

    static int n, m;
    static int[] arr, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        selected = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recursive(0);
        System.out.println(sb);
    }

    public static void recursive(int idx) {

        if (idx == m) {
            for (int i : selected) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        } else {
            int before = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == before) continue;

                selected[idx] = arr[i];
                before = arr[i];
                recursive(idx + 1);
                selected[idx] = 0;
            }
        }
    }
}
