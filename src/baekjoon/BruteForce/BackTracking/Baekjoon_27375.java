package baekjoon.BruteForce.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 수강할 수 있는 n개의 수업
 * 요일 w는 월요일부터 금요일까지 각각 1부터 5까지의 정수
 * 수업의 시작 교시 s, 끝 교시 e는 1부터 10까지의 정수, 수업의 학점은 e - s + 1
 * 정확히 k 학점을 들으면서 금요일에 수업이 하나도 없는 시간표의 가짓수
 * 같은 요일, 같은 교시에 열리는 두 수업은 동시에 수강할 수 없음
 */

public class Baekjoon_27375 {

    static int n, k, res;
    static Schedule[] courses;
    static boolean[] visited;
    static boolean[][] time = new boolean[6][11];
    static ArrayList<Schedule> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        courses = new Schedule[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            courses[i] = new Schedule(s, e, w);
        }
        recursive(0, 0);
        System.out.println(res);
    }

    public static void recursive(int sum, int start) {
        if (sum == k) {
            res++;
        } else {

            for (int i = start; i < n; i++) {
                if (visited[i]) continue; // 이미 선택한 수업
                if (courses[i].weekDay == 5) continue; // 금요일
                // 동일한 요일의 수업 시간이 겹치는 경우
                if (!checkTime(time[courses[i].weekDay], courses[i].s, courses[i].e)) continue;

                selected.add(courses[i]);
                visited[i] = true;
                Arrays.fill(time[courses[i].weekDay], courses[i].s, courses[i].e + 1, true);

                recursive(sum + (courses[i].e - courses[i].s + 1), i + 1);

                selected.remove(selected.size() - 1); // 가장 마지막에 선택한 수업
                visited[i] = false;
                Arrays.fill(time[courses[i].weekDay], courses[i].s, courses[i].e + 1, false);
            }
        }
    }

    public static boolean checkTime(boolean[] time, int s, int e) {
        for (int i = s; i <= e; i++) {
            if (time[i]) return false;
        }
        return true;
    }
}

class Schedule {
    int s;
    int e;
    int weekDay;

    public Schedule(int s, int e, int weekDay) {
        this.s = s;
        this.e = e;
        this.weekDay = weekDay;
    }
}
