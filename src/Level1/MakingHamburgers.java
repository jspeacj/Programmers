package Level1;

import java.util.Stack;

public class MakingHamburgers {
    public static void main(String[] args) {
        /*
            햄버거 만들기
            문제 설명
            햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.
            함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
            상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.
            상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
            상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,
            재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.

            예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때,
            세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때,
            두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.

            상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때,
            상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.

            제한사항
            1 ≤ ingredient의 길이 ≤ 1,000,000
            ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
            입출력 예
            ingredient	                        result
            [2, 1, 1, 2, 3, 1, 2, 3, 1]	          2
            [1, 3, 2, 1, 2, 1, 3, 1, 2]	          0
            입출력 예 설명
            입출력 예 #1

            문제 예시와 같습니다.
            입출력 예 #2

            상수가 포장할 수 있는 햄버거가 없습니다.
         */

        /* TC 1 */
        //int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        // 야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵
        
        /* TC 2 */
        //int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        // 빵, 고기, 야채, 빵, 야채, 빵, 고기, 빵, 야채

        /* TC 3 */
        int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
        // 빵, 고기, 야채, 빵, 야채, 빵, 고기, 빵, 야채

        /*
        첫번째 시도 : 두개 테스트 케이스 시간 초과로 실패
        StringBuilder sb = new StringBuilder();
        for (int i : ingredient) sb.append(i);
        int result = 0; // 상수가 만든 햄버거 개수

        while (true) {
            int i = sb.indexOf("1231");
            if (i > -1) {
                sb.replace(i, i + 4, "");
                result++;
                continue;
            }
            break;
        }

        System.out.println(result);
        */

        /* 두번째 시도 : 스택의 FILO(FirstInputLastOutput)을 이용하여 시도해보기*/
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            if (stack.size() >= 3) {
                if (ingredient[i] == 1) { //넣을 값이 1(빵)일 경우
                    if (stack.peek() == 3) { //현재 스택에 담겨져 있는 마지막 값이 고기일 경우
                        if (stack.get(stack.size() - 2) == 2) { // 스택의 마지막 두번째 인덱스에 담겨져 있는 값이 야채일 경우
                            if (stack.get(stack.size() - 3) == 1) { // 스택의 마지막 세번째 인덱스에 담겨져 있는 값이 빵일 경우
                                result++;
                                stack.pop();
                                stack.pop();
                                stack.pop();
                                continue;
                            }
                        }
                    }
                }
            }

            stack.push(ingredient[i]); // 스택 안에 내용물이 햄버거 조합 개수보다 적거나, 조합에 맞지 않을 경우 해당 재료를 쌓는다.
        }

        System.out.println(result);
    }
}
