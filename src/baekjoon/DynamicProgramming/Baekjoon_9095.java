package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baekjoon_9095 {

    static int test, n;
    static int[] dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(br.readLine());
        preprocess();

        for (int i = 0; i < test; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dy[n]).append('\n');
        }
        System.out.println(sb);
    }

    public static void preprocess() {
        dy = new int[11];
        // 초기값 구하기
        dy[1] = 1; // 1
        dy[2] = 2; // 1 + 1 , 2
        dy[3] = 4; // 1 + 1 + 1 , 1 + 2 , 2 + 1 , 3

        // 점화식을 토대로 배열 채우기
        for (int i = 4; i < 11; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }
    }
}
