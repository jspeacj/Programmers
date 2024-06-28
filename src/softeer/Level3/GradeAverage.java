package softeer.Level3;

import java.util.Scanner;

public class GradeAverage {
    public static void main(String[] args) {
        /*
            성적 평균

            난이도
            Lv. 3

            제출
            3,077 명
            참가자
            2,262 명

            정답률
            75.61 %

            지원 언어
            C
            C++
            Java
            Python
            JavaScript

            문제설명
            제출 이력
            연습문제 톡 7
            언어별 시간/메모리
            언어	시간	메모리
            JavaScript	2초	256MB
            C	1초	256MB
            C++	1초	256MB
            Java	2초	256MB
            Python	2초	256MB

            N명의 학생들의 성적이 학번순서대로 주어졌다.
            학번 구간 [A, B]가 주어졌을 때 이 학생들 성적의 평균을 구하는 프로그램을 작성하라.

            제약조건
            1 ≤ N ≤ 106 인 정수
            1 ≤ K ≤ 104 인 정수
            1 ≤ Si ≤ 100 인 정수
            1 ≤ Ai ≤ Bi ≤ N

            입력형식
            첫 번째 줄에 학생 수 N과 구간 수 K가 주어진다.
            두 번째 줄에는 학생의 성적 Si (1 ≤ i ≤ N)가 주어진다. i + 2 (1 ≤ i ≤ K)번째 줄에는 i번째 구간 Ai, Bi가 주어진다.

            출력형식
            i번째 줄에 i번째 구간의 성적평균(소수셋째자리에서 반올림)을 출력한다.
            차이가 0.01이하이면 정답으로 채점됨.

            입력예제1
            5 3
            10 50 20 70 100
            1 3
            3 4
            1 5

            출력예제1
            26.67
            45.00
            50.00
         */

        Scanner scan = new Scanner(System.in);
        int[] student = new int[scan.nextInt()];
        int index = scan.nextInt();

        for (int i = 0; i < student.length; i++) student[i] = scan.nextInt();
        for (int j = 0; j < index; j++) {
            System.out.println(String.format("%.2f",Math.round(average(student,scan.nextInt(), scan.nextInt()) * 100) / 100.0));
        }
    }

    public static double average(int[] student, int start, int end) {
        float result = 0.00f;
        for (int i = start - 1; i < end; i++) result += student[i];
        return result / (end - start + 1);
    }
}
