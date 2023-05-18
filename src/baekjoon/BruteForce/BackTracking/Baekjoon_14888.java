package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(/)
 * 연산자 우선 순위를 무시하고 앞에서부터 진행
 */
public class Baekjoon_14888 {

    static int n, min, max;
    static int[] arr, operator, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        operator = new int[4]; // 각 연산자의 개수를 담는 배열
        arr = new int[n];
        selected = new int[n - 1]; // 선택한 연산자 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        recursive(0);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    static void recursive(int idx) {
        if (idx == n - 1) {
            int ans = calculator();
            min = Math.min(ans, min);
            max = Math.max(ans, max);
        } else {
            for(int i = 0; i<4; i++) {
                if(operator[i] > 0) {
                    operator[i]--;
                    selected[idx] = i;

                    recursive(idx + 1);

                    operator[i]++;
                    selected[idx] = 4;
                }
            }
        }
    }

    static int calculator() {
        int value = arr[0];
        for (int i = 0; i < n - 1; i++) {
            if (selected[i] == 0) { // 연산자가 '+'인 경우
                value += arr[i + 1];
            } else if (selected[i] == 1) { // 연산자가 '-'인 경우
                value -= arr[i + 1];
            } else if (selected[i] == 2) { // 연산자가 '*'인 경우
                value *= arr[i + 1];
            } else { // 연산자가 '/'인 경우
                value /= arr[i + 1];
            }
        }
        return value;
    }
}
