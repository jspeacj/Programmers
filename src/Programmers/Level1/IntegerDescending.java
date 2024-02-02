package Programmers.Level1;

import java.util.*;

public class IntegerDescending {
    public static void main(String[] args) {
        //정수 내림차순으로 배치하기
        long n = 118372;

        String[] split = Long.toString(n).split("");
        Arrays.sort(split, Comparator.reverseOrder());

        System.out.println(Long.parseLong(String.join("", split)));
    }
}
