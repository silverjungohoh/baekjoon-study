package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * a 배열의 가장 작은 값 x b 배열의 가장 큰 값
 */

public class Baekjoon_1026 {

    static int n;
    static int[] a;
    static Integer[] b;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        Arrays.sort(a); // 배열 a 오름차순 정렬
        Arrays.sort(b, Collections.reverseOrder()); // 배열 b 내림차순 정렬

        for (int i = 0; i < n; i++) {
            sum += a[i] * b[i];
        }
        System.out.println(sum);
    }
}
