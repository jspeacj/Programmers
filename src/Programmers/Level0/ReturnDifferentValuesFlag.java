package Programmers.Level0;

public class ReturnDifferentValuesFlag {
    public static void main(String[] args) {
        /*
            flag에 따라 다른 값 반환하기

            문제 설명
            두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때, flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.

            제한사항
            -1,000 ≤ a, b ≤ 1,000

            입출력 예
            a	b	flag	result
            -4	7	true	3
            -4	7	false	-11

            입출력 예
            입출력 예 #1
            예제 1번에서 flag가 true이므로 a + b = (-4) + 7 = 3을 return 합니다.

            입출력 예 #2
            예제 2번에서 flag가 false이므로 a - b = (-4) - 7 = -11을 return 합니다.
         */

        /* TC 1 result : 3 */
        //int a = -4;
        //int b = 7;
        //boolean flag = true;

        /* TC 2 result : -11 */
        int a = -4;
        int b = 7;
        boolean flag = false;

        System.out.println(flag ? (a + b) : (a - b));
    }
}
