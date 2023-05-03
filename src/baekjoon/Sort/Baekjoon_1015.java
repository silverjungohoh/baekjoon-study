package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1015 {

    static int n;
    static Element[] B;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        B = new Element[n];
        ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(st.nextToken());
            B[i] = new Element(n, i);
        }
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            ans[B[i].idx] = i;
        }
        for (int i : ans) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}

class Element implements Comparable<Element> {
    int n;
    int idx;

    Element(int n, int idx) {
        this.n = n;
        this.idx = idx;
    }

    @Override
    public int compareTo(Element e) {
        if (this.n == e.n) {
            return this.idx - e.idx;
        }
        return this.n - e.n;
    }
}