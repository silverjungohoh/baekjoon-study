package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 현재 팀을 구성하지 않은 사람들 중
 * 가장 낮은 능력치 + 가장 높은 능력치
 */

public class Baekjoon_26091 {

    static int n, m, cnt;
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

        Arrays.sort(arr); // 오름차순 정렬

        int s = 0;
        int e = arr.length - 1;
        int sum = 0;

        while (s < e) {
            sum = arr[s] + arr[e];

            if (sum >= m) {
                cnt++;
                s++;
                e--;
            } else {
                s++;
            }
        }
        System.out.println(cnt);
    }
}
