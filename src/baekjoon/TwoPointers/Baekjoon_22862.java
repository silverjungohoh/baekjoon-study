package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 S에서 원하는 위치에 있는 수를 골라 최대 K번 삭제
 * 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이
 */

public class Baekjoon_22862 {

    static int n, k, len;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 0;
        int cnt = 0;

        // 최대 k개의 홀수가 담긴 배열의 최대 길이
        while (e <= n) {
            if (e == n) {
                break;
            }
            if (cnt > k) {
                if (arr[s] % 2 == 1) {
                    cnt--;
                }
                s++;
            } else {
                if (arr[e] % 2 == 1) {
                    cnt++;
                }
                e++;
            }
            if (cnt <= k) {
                len = Math.max(len, e - s - cnt); // 홀수의 개수만큼 제외
            }
        }
        System.out.println(len);
    }
}
