package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 라이언 인형은 1, 어피치 인형은 2로 표현
 */

public class Baekjoon_15565 {

    static int n, k, min;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;

        int s = 0;
        int e = 0;
        int cnt = 0;
        while (e <= n) {
            if (cnt < k) {
                if (e == n) break;
                if (arr[e] == 1) {
                    cnt++;
                }
                e++;
            } else {
                min = Math.min(min, e - s);
                if (arr[s] == 1) {
                    cnt--;
                }
                s++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
