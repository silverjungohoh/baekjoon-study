package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정렬
 * 국어 내림차순 → 영어 오름차순 → 수학 내림차순 → 이름 사전순 증가
 */

public class Baekjoon_10825 {

    static int n;
    static Student[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        students = new Student[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);
    }
}

class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student s) {
        if (s.korean == this.korean) {
            if (s.english == this.english) {
                if (s.math == this.math) {
                    return this.name.compareTo(s.name); // 이름 사전 순 증가 정렬
                }
                return s.math - this.math; // 수학 내림차순 정렬
            }
            return this.english - s.english; // 영어 오름차순 정렬
        }
        return s.korean - this.korean; // 국어 내림차순 정렬
    }
}