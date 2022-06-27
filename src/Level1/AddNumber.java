package Level1;

import java.util.*;

public class AddNumber {
    public static void main(String[] args) {
        //없는 숫자 더하기 (월간 코드 챌린지 시즌3)
        int[] numbers = new int[]{1,2,3,4,6,7,8,0};
        int answer = 0;

        //배열에 있는 값을 담기 위한 해시맵 선언
        Map<Integer, Integer> num = new HashMap<>();

        //배열에 있는 값은 선언한 해시맵 num에 담기
        for (int index = 0; index < numbers.length; index++) {
            num.put(numbers[index], 1);
        }

        /*
            1 ~ 9 숫자 중, 해시맵을 이용하여 배열에 이미 담겨있는 숫자가 아닌 값을 answer에 더한다.
            해시맵의 containsKey을 이용하여, 해당 숫자의 키가 존재하지 않을 경우 해당 값을 answer에 더한다.
         */
        for (int i = 1; i <= 9; i++) {
            if (!num.containsKey(i)) {
                answer += i;
            }
        }

        System.out.println(answer);
    }
}
