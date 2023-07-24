package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 음식의 신맛은 사용한 재료의 신맛의 곱
 * 음식의 쓴맛은 사용한 재료의 쓴맛의 합
 * 신맛과 쓴맛의 차이가 가장 작은 요리
 * 재료는 적어도 하나 이상 사용
 */

public class Baekjoon_2961 {

    static int n, count, min;
    static Ingredient[] ingredients;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ingredients = new Ingredient[n];
        visited = new boolean[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ingredients[i] = new Ingredient(s, e);
        }

        min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            count = i;
            recursive(0, 1, 0);
        }
        System.out.println(min);
    }

    public static void recursive(int idx, int sTotal, int bTotal) {
        if (idx == count) {
            min = Math.min(Math.abs(sTotal - bTotal), min);
        } else {

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;

                Ingredient now = ingredients[i];
                visited[i] = true;
                recursive(idx + 1, now.s * sTotal, now.b + bTotal);
                visited[i] = false;
            }
        }
    }
}

class Ingredient {
    int s, b;

    public Ingredient(int s, int b) {
        this.s = s;
        this.b = b;
    }
}