package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행
 * 0 = + / 1 = - / 2 = x / 3 = ÷
 */

public class Baekjoon_15658 {

    static int n, min, max;
    static int[] arr, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        operator = new int[4];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        recursive(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void recursive(int idx, int res) {
        if (idx == n - 1) {
            max = Math.max(max, res);
            min = Math.min(min, res);
        } else {

            for (int i = 0; i < 4; i++) {
                if (operator[i] == 0) continue;

                operator[i]--;

                if (i == 0) {
                    recursive(idx + 1, res + arr[idx + 1]);
                } else if (i == 1) {
                    recursive(idx + 1, res - arr[idx + 1]);
                } else if (i == 2) {
                    recursive(idx + 1, res * arr[idx + 1]);
                } else {
                    recursive(idx + 1, res / arr[idx + 1]);
                }

                operator[i]++;
            }
        }
    }
}
