package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 정수로 이루어진 수열
 * 두 수를 골랐을 때 그 차이가 m 이상이면서 가장 작은 경우
 * 주의! : 같은 수를 고를 수 있음
 */

public class Baekjoon_2230 {

    static int n, m, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 오름차순 정렬
        ans = Integer.MAX_VALUE;
        int e = 0;

        for (int s = 0; s < n; s++) {
            int sub;

            while (e < n) {
                sub = arr[e] - arr[s];
                if (sub < m) { // 차를 늘려야 함
                    e++;
                } else if (sub == m) { // 더 이상 탐색할 필요 X
                    System.out.println(m);
                    return;
                } else {
                    ans = Math.min(ans, sub);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
