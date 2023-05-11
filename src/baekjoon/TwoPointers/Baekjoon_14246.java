package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 내 값들은 모두 자연수
 * (주의!) 합과 개수는 int 범위 넘어갈 수 있어 long으로 설정
 * arr = {1, 1, 1, 1, 1} | k = 2 → 합이 2보다 커지는 구간인 {1, 1, 1} 찾으면
 * {1, 1, 1, 1}과 {1, 1, 1, 1, 1}은 당연히 합이 3보다 크기 때문에 뒷부분까지 탐색 필요 X
 */

public class Baekjoon_14246 {

    static int n, k;
    static int[] arr;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        int s = 0;
        int e = 0;
        long sum = 0;

        while (e <= n) {
            if (sum <= k) { // 합을 늘려야
                if (e == n) break;
                sum += arr[e];
                e++;
            } else {
                sum -= arr[s];
                s++;
                cnt += n - e + 1;
            }
        }
        System.out.println(cnt);
    }
}
