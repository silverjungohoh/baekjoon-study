package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 n까지 자연수 중 m개를 고른 수열 (중복 허용)
 */

public class Baekjoon_15651 {

    static int n, m;
    static int[] selected; // m개를 고른 수열울 담을 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m+1];

        recursive(1);
        System.out.println(sb);
    }

    static void recursive (int k) {
        if(k == m + 1) { // 종료 조건 → m개를 다 골랐을 때
            for(int i = 1; i<= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        } else {
            for(int c = 1; c<=n; c++) {
                selected[k] = c;
                recursive(k+1);
                selected[k] = 0;
            }
        }
    }
}
