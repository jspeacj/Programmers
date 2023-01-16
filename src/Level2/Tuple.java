package Level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tuple {
    public static void main(String[] args) {
        /*
            튜플
            문제 설명
            셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다.
            n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

            (a1, a2, a3, ..., an)
            튜플은 다음과 같은 성질을 가지고 있습니다.

            중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
            원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
            튜플의 원소 개수는 유한합니다.
            원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수),
            이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

            {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
            예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

            {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
            와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

            {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
            {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
            {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
            는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

            특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

            [제한사항]
            s의 길이는 5 이상 1,000,000 이하입니다.
            s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
            숫자가 0으로 시작하는 경우는 없습니다.
            s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
            s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
            return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.
            [입출력 예]
                        s	                       result
            "{{2},{2,1},{2,1,3},{2,1,3,4}}"	    [2, 1, 3, 4]
            "{{1,2,3},{2,1},{1,2,4,3},{2}}"	    [2, 1, 3, 4]
            "{{20,111},{111}}"	                [111, 20]
            "{{123}}"	                        [123]
            "{{4,2,3},{3},{2,3,4,1},{2,3}}"	    [3, 2, 4, 1]
            입출력 예에 대한 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            문제 예시와 같습니다.

            입출력 예 #3
            (111, 20)을 집합 기호를 이용해 표현하면 {{111}, {111,20}}이 되며, 이는 {{20,111},{111}}과 같습니다.

            입출력 예 #4
            (123)을 집합 기호를 이용해 표현하면 {{123}} 입니다.

            입출력 예 #5
            (3, 2, 4, 1)을 집합 기호를 이용해 표현하면 {{3},{3,2},{3,2,4},{3,2,4,1}}이 되며, 이는 {{4,2,3},{3},{2,3,4,1},{2,3}}과 같습니다.
        * */

        /* 문제 주어진 조건 및 이해하기
        *  (1). 튜플 원소는 중복되는 값이 없다.
        *  (2). 튜플 원소는 주어지는 순서는 동일하다. {a1, a2, a3 ... an}
        *  (3). (1) ~ (2)번을 취합한다면, 주어진 튜플을 표현하는 집합 s에서 하나의 원소만 주어진 숫자가 튜플의 첫번쨰 원소이다. (순서가 정해져있기 떄문)
        *  (4). 이후 주어진 튜플을 표현하는 집합들 중, 집합의 길이가 작은 순서대로 기존에 없던 원소가 튜플의 다음 값이 된다.
        *  (5). 중복을 허용하지 않으면서 순서가 보장되는 LinkedHashSet 이용하기 (HashSet은 중복을 허용하지 않지만 순서도 보장하지 않는다.)
        * */


        /*
        * 문제점 :
        * 1. s의 배열들을 나눠야함..
        * 2. 배열들을 나눈다고 하더라도 이후에 가장 큰 사이즈가 무엇인지 어떻게 찾을건지??
        *
        * */
        /* TC 1 */
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        /* TC 2 */
        //String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        /* TC 3 */
        //String s = "{{20,111},{111}}";

        /* TC 4 */
        //String s = "{{123}}";

        /* TC 5 */
        //String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        Set<Integer> set = new LinkedHashSet<>();

        s = s.substring(1, s.length() - 1);

        String[] strArray = s.replace("{", "").replace("},", " ").replace("}", "").split(" ");

        Arrays.sort(strArray, new CustomComparator());

       for (String str : strArray) {
           String[] split = str.split(",");

           for (String splitStr : split) {
                set.add(Integer.parseInt(splitStr));
            }
        }

        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;

        while (iterator.hasNext()) result[index++] = iterator.next();

        System.out.println(Arrays.toString(result));
    }
}
    class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }