package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 각 계란에는 무게와 내구도가 존재
 * 계란으로 계란을 칠 경우 상대 계란의 무게만큼 내구도가 깎임
 * 계란의 내구도가 0 이하가 되는 순간 계란은 깨지게 됨
 * 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 것
 */

public class Baekjoon_16987 {

    static int n, res;
    static Egg[] eggs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];
        visited = new boolean[n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dur = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(dur, w);
        }

        // 계란이 1개인 경우 -> 깰 수 있는 계란의 최대는 0
        if (n == 1) {
            System.out.println(0);
            return;
        }

        recursive(0);
        System.out.println(res);
    }

    public static void recursive(int now) {

        if (now == n) { // 최근에 든 계란이 가장 오른쪽에 위치한 경우
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].dur <= 0) cnt++; // 내구도가 0 이하인 경우 > 계란이 깨진 상태
            }
            res = Math.max(cnt, res);
        } else {

            boolean flag = false; // 두 계란을 쳤는지 여부
            for (int i = 0; i < n; i++) {
                if (now == i) continue; // 두 계란이 똑같은 경우
                if (eggs[i].dur <= 0) continue; // 이미 깨진 계란인 경우

                if (eggs[i].dur > 0 && eggs[now].dur > 0) {
                    eggs[i].dur -= eggs[now].w;
                    eggs[now].dur -= eggs[i].w;
                    flag = true; // 계란을 친 경우

                    recursive(now + 1);

                    eggs[i].dur += eggs[now].w;
                    eggs[now].dur += eggs[i].w;
                }
            }
            if (!flag) recursive(now + 1); // 계란을 치지 못한 경우
        }
    }
}

class Egg {
    int dur;
    int w;

    public Egg(int dur, int w) {
        this.dur = dur;
        this.w = w;
    }
}