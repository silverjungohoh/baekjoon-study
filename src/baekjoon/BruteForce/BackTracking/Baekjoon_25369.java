package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1부터 9사이의 정수
 * 같은 정수가 적힌 카드를 여러 개 선택 가능
 */

public class Baekjoon_25369 {

    static int n, total;
    static int[] aSelected, bSelected;
    static boolean flag;
    static String ans;
    static ArrayList<String> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        aSelected = new int[n];
        bSelected = new int[n];
        list = new ArrayList<>();
        flag = true;
        total = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aSelected[i] = Integer.parseInt(st.nextToken());
            total *= aSelected[i];
        }
        recursive(0, 1);
        System.out.println(ans == null ? -1 : ans);
    }

    public static void recursive(int idx, int res) {
        if (idx == bSelected.length) {
            if (total < res && flag) {
                StringBuilder sb = new StringBuilder();
                for (int i : bSelected) {
                    sb.append(i).append(' ');
                }
                flag = false;
                ans = sb.toString();
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                bSelected[idx] = i;
                recursive(idx + 1, res * i);
                bSelected[idx] = 0;
            }
        }
    }
}
