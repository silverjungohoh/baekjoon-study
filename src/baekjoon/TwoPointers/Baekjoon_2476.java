package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값
 * 두 개 이상일 경우에는 그 중 아무것이나 하나
 */

public class Baekjoon_2476 {

    static int n;
    static long min;
    static int[] arr, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        selected = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0;
        int e = arr.length - 1;
        min = Long.MAX_VALUE;

        while (s != e) {

            long sum = arr[s] + arr[e];

            if (sum == 0) { // 더 이상 가까운 값이 존재하지 않음
                System.out.println(arr[s] + " " + arr[e]);
                return;
            } else {
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    selected[0] = arr[s];
                    selected[1] = arr[e];
                }
                if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        sb.append(selected[0]).append(" ").append(selected[1]);
        System.out.println(sb);
    }
}
