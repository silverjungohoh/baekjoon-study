package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 각각의 포지션에서의 능력을 0부터 100까지의 정수
 * 모든 포지션에 선수를 배치
 * 각 선수는 능력치가 0인 포지션에 배치될 수 없음
 */

public class Baekjoon_3980 {

    static int test, max;
    static int[][] players;
    static boolean[] visited; // 중복 여부 확인
    static int[] selected; // 각 포지션에 선수를 선택
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < test; i++) {

            players = new int[12][12];
            visited = new boolean[12];
            selected = new int[12];
            max = Integer.MIN_VALUE;


            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int h = 0; h < 11; h++) {
                    players[j + 1][h + 1] = Integer.parseInt(st.nextToken());
                }
            }
            recursive(1, 0);
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

    public static void recursive(int idx, int total) {
        if (idx == selected.length) {
            max = Math.max(total, max);
        } else {

            for (int i = 1; i <= 11; i++) {
                if (players[i][idx] == 0) continue; // 해당 포지션의 능력이 0인 경우는 뽑힐 수 없음
                if (visited[i]) continue; // 선수가 이미 맡은 포지션이 있다면

                selected[idx] = i;
                visited[i] = true;

                recursive(idx + 1, total + players[i][idx]);

                selected[idx] = 0;
                visited[i] = false;
            }
        }
    }
}