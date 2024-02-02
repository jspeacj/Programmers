package Programmers.Level1;

import java.util.Arrays;

public class NumberToArray {
    public static void main(String[] args) {
        //자연수 뒤집어 배열로 만들기
        long n = 12345;

        StringBuffer sb = new StringBuffer(Long.toString(n));
        System.out.println(Arrays.stream(sb.reverse().toString().split("")).mapToInt(Integer::parseInt).toArray());
    }
}
