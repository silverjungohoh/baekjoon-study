package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 내 모든 값은 자연수
 */

public class Baekjoon_2003 {

    static int n, m, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 0;
        int sum = 0;

        while(e <= n) {
            if(sum == m) {
                cnt++;
                sum -= arr[s];
                s++;
            } else if (sum > m) {
                sum -= arr[s];
                s++;
            } else {
                if(e == n) break;
                sum += arr[e];
                e++;
            }
        }
        System.out.println(cnt);
    }
}
