package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전체 거리는 정해져 있음
 */

public class Baekjoon_2118 {

    static int n, total, ans;
    static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        point = new int[n];

        for (int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(br.readLine());
            total += point[i];
        }

        ans = Integer.MIN_VALUE;

        int s = 0;
        int e = 1;
        int dist = point[0];

        /**
         * 한 지점을 고정하고 다른 지점을 탐색
         * 시계방향이 반시계방향보다 더 커지는 시점부터는 최댓값이 변하지 않음 (같을 때가 최댓값) > 그 이후는 탐색 X
         */

        while (s < n) {
            ans = Math.max(ans, Math.min(dist, total - dist));

            if (dist >= total - dist) {
                dist -= point[s];
                s++;
            } else {
                dist += point[e];
                e++;
                e %= n; // 원형으로 연결되어 있음
            }
        }
        System.out.println(ans);
    }
}
