package Level1;

import java.util.*;

public class DivideNumberArray {
    public static void main(String[] args) {
        // 나누어 떨어지는 숫자 배열
        int[] arr = {3, 2, 6};
        int divisor = 10;

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                answerList.add(i);
            }
        }

        if (answerList.size() == 0) answerList.add(-1);
        int[] answer = answerList.stream().mapToInt(x -> x).sorted().toArray();
        System.out.println(Arrays.toString(answer));
    }
}
