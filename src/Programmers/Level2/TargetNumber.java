package Programmers.Level2;

public class TargetNumber {
    public static void main(String[] args) {
        /*
            타겟 넘버
            문제 설명
            n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
            예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

            -1+1+1+1+1 = 3
            +1-1+1+1+1 = 3
            +1+1-1+1+1 = 3
            +1+1+1-1+1 = 3
            +1+1+1+1-1 = 3
            사용할 수 있는 숫자가 담긴 배열 numbers,
            타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

            제한사항
            주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
            각 숫자는 1 이상 50 이하인 자연수입니다.
            타겟 넘버는 1 이상 1000 이하인 자연수입니다.

                           입출력 예
                numbers	      target  return
            [1, 1, 1, 1, 1]	    3	    5
            [4, 1, 2, 1]	    4	    2

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            +4+1-2+1 = 4
            +4-1+2-1 = 4
            총 2가지 방법이 있으므로, 2를 return 합니다.
         */

        /*
        *  문제 이해 및 풀이 방식 정하기
           1.배열 numbers의 순서를 바꾸면 안된다. (정렬 허용 X)
           2. 즉 정렬을 하면 안되니깐 모든 경우의 수를 다해야한다..? 효율성이 괜찮을지 검토해야함.
           3.
        * */

        /* TC 1 return : 5 */
        //int [] numbers = {1, 1, 1, 1, 1};
        //int target = 3;

        /* TC 2 return : 2 */
        int [] numbers = {4, 1, 2, 1};
        int target = 4;

        System.out.println(targetSearch(numbers, 0, 0, target));
    }

    public static int targetSearch(int[] numbers, int index, int total, int target) {
        int num = 0;
        int plusTotal = total + numbers[index];
        int minusTotal = total - numbers[index];

        if (index + 1 < numbers.length) { // 다음 인덱스가 존재할 경우
            index++;

            num += targetSearch(numbers, index, plusTotal, target);
            num += targetSearch(numbers, index, minusTotal, target);
        } else { // 마지막 값일 경우
            if (plusTotal == target) num++;
            if (minusTotal == target) num++;
        }

        return num;
    }
}
