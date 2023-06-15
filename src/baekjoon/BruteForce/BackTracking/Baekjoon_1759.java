package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 암호는 서로 다른 알파벳 소문자들
 * 최소 한 개의 모음과 최소 두 개의 자음으로 구성
 * 암호는 증가하는 순서로 배열됨
 */

public class Baekjoon_1759 {

    static int l, c;
    static char[] arr, selected;
    static boolean[] visited;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        visited = new boolean[c];
        selected = new char[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recursive(0, 0, 0, 0);
        System.out.println(ans);
    }

    public static void recursive(int idx, int v_cnt, int c_cnt, int start) {
        if (idx == l) {
            if (v_cnt >= 1 && c_cnt >= 2) {
                StringBuilder sb = new StringBuilder();
                for (char c : selected) {
                    sb.append(c);
                }
                ans.append(sb).append('\n');
            }
        } else {
            for (int i = start; i < c; i++) {

                selected[idx] = arr[i];
                visited[i] = true;

                if (isVowel(selected[idx])) {
                    recursive(idx + 1, v_cnt + 1, c_cnt, i + 1);
                } else {
                    recursive(idx + 1, v_cnt, c_cnt + 1, i + 1);
                }

                selected[idx] = 0;
                visited[i] = false;
            }
        }
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
