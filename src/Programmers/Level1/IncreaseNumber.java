package Programmers.Level1;

public class IncreaseNumber {
    public static void main(String[] args) {
        //x만큼 간격이 있는 x개의 숫자
        long x = 5;
        int n = 4;

        long index = x;
        long[] answer = new long[n];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = index * (i + 1);
        }
    }
}
