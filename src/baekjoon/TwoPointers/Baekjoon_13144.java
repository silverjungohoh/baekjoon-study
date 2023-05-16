package baekjoon.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 같은 수가 여러 번 등장하지 않는 경우의 수
 * 경우의 수 최대치가 int 범위를 넘어감
 */
public class Baekjoon_13144 {

    static int n;
    static long cnt;
    static int[] arr;
    static int[] check = new int[100001]; // 배열 내 숫자 개수 체크하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        while (e <= n) {
            if (e < n && check[arr[e]] == 0) {
                check[arr[e]]++;
                e++;
            } else {
                check[arr[s]]--;
                cnt += (e - s);
                s++;
                if (s == n) break;
            }
        }
        System.out.println(cnt);
    }
}
