package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 부피 (m을 초과하면 안됨)
 */

public class Baekjoon_25916 {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        long sum = 0;
        long max = Long.MIN_VALUE;

        while (e < n) {
            if (sum + arr[e] == m) { // 최대 부피 (탐색 더 이상 X)
                System.out.println(m);
                return;
            } else if (sum + arr[e] < m) { // 합을 늘려야 함
                sum += arr[e];
                max = Math.max(max, sum);
                e++;
            } else { // 합을 줄여야 함
                sum -= arr[s];
                s++;
            }
        }
        System.out.println(max);
    }
}