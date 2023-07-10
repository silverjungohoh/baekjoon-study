package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3개의 연속된 문제의 답은 같지 않게 한다
 * 영재의 점수가 5점 이상일 경우의 수
 * 문제의 점수는 1문제당 1점
 */

public class Baekjoon_19949 {

    static int result;
    static int[] answer = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        recursive(0, 0, 0, 1);
        System.out.println(result);
    }

    public static void recursive(int idx, int score, int before, int cnt) {
        if (idx == 10) {
            if (score >= 5) {
                result++;
            }
        } else {

            for (int i = 1; i <= 5; i++) {
                if (answer[idx] == i) { // 찍은 답이 정답인 경우

                    if (cnt == 2 && i == before) continue;

                    if (i == before) {
                        recursive(idx + 1, score + 1, before, cnt + 1);
                    } else {
                        recursive(idx + 1, score + 1, i, 1);
                    }

                } else { // 정답이 아닌 경우

                    if (cnt == 2 && i == before) continue;

                    if (i == before) {
                        recursive(idx + 1, score, before, cnt + 1);
                    } else {
                        recursive(idx + 1, score, i, 1);
                    }
                }
            }
        }
    }
}
