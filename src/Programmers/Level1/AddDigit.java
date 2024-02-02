package Programmers.Level1;

public class AddDigit {
    //자리수 더하기
    public static void main(String[] args) {
        int n = 987;

        int answer = 0;
        String[] arrayNum = String.valueOf(n).split("");

        for (String s : arrayNum) {
            answer += Integer.parseInt(s);
        }

        System.out.println(answer);
    }
}
