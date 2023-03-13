package Level2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindDecimal {
    public static void main(String[] args) {
        /*
            소수 찾기

            문제 설명
            한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
            흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

            각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
            종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

            제한사항
            numbers는 길이 1 이상 7 이하인 문자열입니다.
            numbers는 0~9까지 숫자만으로 이루어져 있습니다.
            "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

            입출력 예
            numbers	return
             "17"	  3
             "011"	  2

            입출력 예 설명
            예제 #1
            [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

            예제 #2
            [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
            11과 011은 같은 숫자로 취급합니다.
         */

        /* TC 1 return : 3 */
        //String numbers = "17";

        /* TC 2 return : 2 */
        String numbers = "011";

        Set<Integer> set = new HashSet<>();
        dfs(numbers.toCharArray(), set, new boolean[numbers.length()], "");
        System.out.println(checkDecimal(set));
    }

    private static int checkDecimal(Set<Integer> set) {
        int answer = 0;
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            boolean flag = false;
            int num = iterator.next();

            if (num == 0 || num == 1) continue;

            for (int i = 2; i <= (int)Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            answer++;
        }

        return answer;
    }

    private static void dfs(char[] chars, Set<Integer> set, boolean[] used, String str) {
        for (int index = 0; index < chars.length; index++) {
            if (!used[index]) {
                str += String.valueOf(chars[index]);
                set.add(Integer.parseInt(str));
                used[index] = true;
                dfs(chars, set, used, str);
                str = str.substring(0, str.length() - 1);
                used[index] = false;
            } else {
                set.add(Integer.parseInt(str));
            }
        }
    }
}
