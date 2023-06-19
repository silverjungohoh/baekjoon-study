package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력받은 영단어의 철자들로 만들 수 있는 모든 단어를 출력
 * 알파벳 순서로 출력
 */

public class Baekjoon_6443 {

    static int n;
    static int[] alphabet;
    static char[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            alphabet = new int[26];
            for (int j = 0; j < s.length(); j++) {
                alphabet[s.charAt(j) - 'a']++;
            }
            selected = new char[s.length()];
            recursive(0);
        }
        System.out.println(sb);
    }

    public static void recursive(int idx) {
        if (idx == selected.length) {
            StringBuilder tmp = new StringBuilder();
            for (char c : selected) {
                tmp.append(c);
            }
            sb.append(tmp).append('\n');
        } else {

            for (int i = 0; i < 26; i++) {
                if (alphabet[i] == 0) continue;
                alphabet[i]--;
                selected[idx] = (char) (i + 'a');

                recursive(idx + 1);

                selected[idx] = ' ';
                alphabet[i]++;
            }
        }
    }
}
