package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열은 여러 개의 서로 다른 정수로 구성
 */
public class Baekjoon_9024 {

    static int test, n, k;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr); // 오름차순 정렬
            int s = 0;
            int e = arr.length - 1;
            int sum;
            int cnt = 1;
            int min = Integer.MAX_VALUE;

            while (s < e) {
                sum = arr[s] + arr[e];
                int t = Math.abs(k - sum);

                if (t == min) {
                    cnt++;
                } else if (t < min) {
                    cnt = 1; // 개수 초기화
                    min = t; // k와 sum 차이 더 작은 값으로 초기화
                }

                if (sum == k) {
                    s++;
                    e--;
                } else if (sum < k) {
                    s++;
                } else {
                    e--;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
