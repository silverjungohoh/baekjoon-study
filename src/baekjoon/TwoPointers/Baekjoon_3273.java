package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열은 서로 다른 양의 정수
 */

public class Baekjoon_3273 {

    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        Arrays.sort(arr); // 배열 오름차순 정렬

        int cnt = 0;
        int s = 0;
        int e = arr.length - 1;

        while(s < e) {
            int sum = arr[s] + arr[e];

            if(sum == x) {
                cnt++;
                e--;
            } else if (sum < x) {  // 합을 늘려야
                s++;
            } else { // 합을 줄여야
                e--;
            }
        }
        System.out.println(cnt);
    }
}
