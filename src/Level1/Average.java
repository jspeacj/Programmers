package Level1;

import java.util.Arrays;

public class Average {
    public static void main(String[] args) {
        //평균 구하기
        int[] arr = new int[]{1, 2, 3, 4};
        double answer = 0;

        System.out.println(Arrays.stream(arr).average().getAsDouble());
    }
}
