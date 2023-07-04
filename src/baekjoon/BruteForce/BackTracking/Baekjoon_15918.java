package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n개의 n 사이에는 정확히 n개의 수가 있음 > 랭퍼드 수열
 * x번째 수와 y번째 수는 같음 > x, y번째 수가 모두 y-x-1 (x와 y 사이에 있는 숫자의 개수)
 */

public class Baekjoon_15918 {

    static int n, x, y, cnt;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        selected = new int[2 * n + 1];
        visited = new boolean[n + 1];

        selected[x] = y - x - 1;
        selected[y] = y - x - 1;
        visited[y - x - 1] = true; // 이미 선택한 숫자 (중복 방지)

        recursive(1);
        System.out.println(cnt);
    }

    public static void recursive(int idx) {
        if (idx == 2 * n + 1) { // 모든 수를 다 선택 (재귀 종료)
            cnt++;
        } else {
            if (selected[idx] == 0) {
                for (int i = 1; i <= n; i++) {
                    if (idx + i + 1 > 2 * n) continue;
                    if (selected[idx + i + 1] != 0) continue;
                    if (visited[i]) continue; // 이미 사용한 숫자인 경우

                    selected[idx] = i;
                    selected[idx + 1 + i] = i;
                    visited[i] = true;

                    recursive(idx + 1);

                    selected[idx] = 0;
                    selected[idx + i + 1] = 0;
                    visited[i] = false;
                }
            } else {
                recursive(idx + 1); // 이미 값이 존재하므로 pass
            }
        }
    }
}
