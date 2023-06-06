package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 인접해 있는 모든 문자가 같지 않은 문자열을 행운의 문자열
 */

public class Baekjoon_1342 {

    static char[] arr, selected;
    static boolean[] visited;
    static int[] alphabet;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        arr = new char[s.length()];
        selected = new char[s.length()];
        visited = new boolean[s.length()];
        alphabet = new int[26];


        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
            alphabet[arr[i] - 'a']++;
        }
        recursive(0);
        System.out.println(cnt);
    }

    public static void recursive(int idx) {
        if (idx == selected.length) {
            cnt++;
        } else {
            char before = idx > 0 ? selected[idx - 1] : 0;
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] == 0 || before == (char) ('a' + i)) continue;

                selected[idx] = (char) ('a' + i);
                alphabet[i]--;

                recursive(idx + 1);

                selected[idx] = 0;
                alphabet[i]++;
            }
        }
    }
}
