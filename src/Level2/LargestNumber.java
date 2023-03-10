package Level2;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        /*
            가장 큰 수
            문제 설명
            0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

            예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

            0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

            제한 사항
            numbers의 길이는 1 이상 100,000 이하입니다.
            numbers의 원소는 0 이상 1,000 이하입니다.
            정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
            입출력 예
            numbers	                return
            [6, 10, 2]	            "6210"
            [3, 30, 34, 5, 9]	    "9534330"
         */

        /* TC 1 return "6210" */
        //int[] numbers = {6, 10, 2};

        /* TC 2 return "9534330" */
        int[] numbers = {3, 30, 34, 5, 9};
        // {333, 303, 343, 555, 999}
        // 999, 555, 343, 333, 303
        // 9, 5, 34, 3, 30
        // 9534330 ..
        /* TC 3 return "0" */
        //int[] numbers = {0, 0};

        /* TC 4 return 979 97 978 818 81 817 */
        //int[] numbers = {979, 97, 978, 81, 818, 817};

        /* TC 5 return "121312 */
        //int[] numbers = {12, 1213};

        /* TC 6 return  "8989881881110100100000"*/
        //               8988981881110100100000
        // 89/898/818/81/1/10/100/1000/0/0
        // 89/898/818/81/1/10/100/1000/0/0
        // 898 , 89 => 89889 or 89898 (o)
        // 818 , 81 => 81818 or 81881 (o)
        // 1 5 => 111 555
        // 898, 89 => 898, 898
        //int[] numbers = {9, 998};
        // 9, 998 => 9998 9989
        // 9, 912 => 9912 9129

        /*
               - 문제에서 주의할 점 -
               ex) 3, 32 => 323 or 332
               ex) 5, 58 => 558 or 585
               ex) 552, 5527 => 5525527 or 5527552
               ex) 552, 5523 => 5525523 or 5523552
            => 자리수가 다르면서 동일 자리수의 모든 숫자가 동일할 때 :
               1. 작은 값의 다음 자리수를 큰 값의 동일한 자리수 위치에서 찾는다.
               2. 해당 값이 작은값의 첫번째 값보다 클 경우  : 자리수가 많은 게 먼저,
               3. 해당 값이 작은 값의 첫번쨰값보다 작을 경우 : 자리수가 작은값이 먼저

               <알고리즘 개발 순서>
               버블 정렬을 이용해서 문제를 수행..?
               인덱스 위치를 나타내는 배열을 선언..? => 클래스로 만들어서 관리
               각 숫자가 3자리수보다 작을 경우 3자리수로 맞추기..?

       */

        /* Try 1 customSorted를 이용하여 정리 : 특정 테스트 케이스 런타임 에러로 인해 실패 */
        StringBuilder sb = new StringBuilder();
        Integer[] numArrays = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(numArrays, (num1, num2) -> num1 == num2 ? 0 : customSorted(num1, num2));
        for (int n : numArrays) sb.append(n);

        System.out.println("0".equals(sb.toString().substring(0, 1)) ? "0" : sb.toString());

        /* Try 2 class Number를 정의하여 문제를 처리 */
        Number number = new Number();


    }

    public static class Number {
        int originNum;
        int settingNum;
        int location;

        public int getOriginNum() {
            return originNum;
        }

        public void setOriginNum(int originNum) {
            this.originNum = originNum;
        }

        public int getSettingNum() {
            return settingNum;
        }

        public void setSettingNum(int settingNum) {
            this.settingNum = settingNum;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }
    }
    private static Integer customSorted(Integer num1, Integer num2) {
        char[] chars1 = num1.toString().toCharArray();
        char[] chars2 = num2.toString().toCharArray();

        int length = chars1.length < chars2.length ? chars1.length : chars2.length;

        for (int i = 0; i < length; i++) {
            int numericValue1 = Character.getNumericValue(chars1[i]);
            int numericValue2 = Character.getNumericValue(chars2[i]);

            if (numericValue1 == numericValue2) continue;
            else return numericValue2 - numericValue1;
        }

        if (chars1.length != chars2.length) {
            if (Math.max(chars1.length, chars2.length) == 3) {
                if (length == 2) return chars2[0] - chars2[1];
                else if (length == 1) return num1 - num2;
            }

            if (length == chars1.length) {
                return chars1[0] - chars2[length] == 0 ? num2 - num1 : chars1[0] - chars2[length];
            } else {
                return chars2[0] - chars1[length] == 0 ? num2 - num1 : chars2[0] - chars1[length];
            }
        }

        return 0;
    }
}
