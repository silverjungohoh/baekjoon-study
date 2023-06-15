package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L을 고르는 경우 / 자음을 고르는 경우 / 모음을 고르는 경우
 */

public class Baekjoon_2922 {

    static String str;
    static char[] arr;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        recursive(0, false, 0, 0, 1);
        System.out.println(ans);
    }

    public static void recursive(int idx, boolean l, int vowel, int consonant, long cnt) {

        if (vowel >= 3 || consonant >= 3) { // 모음이나 자음이 연속해서 3번 이상인 경우
            return;
        }

        if (idx == arr.length) {
            if (l) { // L을 포함한 경우
                ans += cnt;
            }
            return;
        }

        if (arr[idx] != '_') {
            if (isVowel(arr[idx])) { // 모음인 경우 > 연속되는 자음의 개수는 0으로 reset
                recursive(idx + 1, l, vowel + 1, 0, cnt);
            } else if (arr[idx] == 'L') { // L인 경우 > 연속되는 모음의 개수는 0으로 reset
                recursive(idx + 1, true, 0, consonant + 1, cnt);
            } else { // L이 아닌 자음인 경우 > 연속되는 모음의 개수는 0으로 reset
                recursive(idx + 1, l, 0, consonant + 1, cnt);
            }
        } else {
            // _에 L을 넣는 경우 > 연속되는 모음의 개수는 0으로 reset
            recursive(idx + 1, true, 0, consonant + 1, cnt);
            // _에 모음을 넣는 경우 > 연속되는 자음의 개수는 0으로 reset
            recursive(idx + 1, l, vowel + 1, 0, cnt * 5);
            // _에 자음을 넣는 경우 > 연속되는 모음의 개수는 0으로 reset
            recursive(idx + 1, l, 0, consonant + 1, cnt * 20);
        }
    }

    // 모음인지 판별
    public static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
