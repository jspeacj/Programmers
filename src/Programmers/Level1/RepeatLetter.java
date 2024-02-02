package Programmers.Level1;

public class RepeatLetter {
    public static void main(String[] args) {
        // 문자 반복하기(수박수박수박수박수박...)

        int n = 4;

        StringBuilder sb = new StringBuilder();
        for (int index = 1; index <= n; index++) {
            if (index % 2 != 0) { //홀수
                sb.append("수");
            } else { // 짝수
                sb.append("박");
            }
        }

        System.out.println(sb.toString());
    }
}
