package Level2;

import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {
        /*
            올바른 괄호
            문제 설명
            괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
            예를 들어
            "()()" 또는 "(())()" 는 올바른 괄호입니다.
            ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
            '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
            올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

            제한사항
            문자열 s의 길이 : 100,000 이하의 자연수
            문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
            입출력 예
              s	        answer
            "()()"	     true
            "(())()"	 true
            ")()("	     false
            "(()("	     false
            입출력 예 설명
            입출력 예 #1,2,3,4
            문제의 예시와 같습니다.
         */

        /* TC 1 */
        //String s = "()()";

        /* TC 2 */
        //String s = "(())()";

        /* TC 3 */
        //String s = ")()(";

        /* TC 4 */
        String s = "(()(";


        /* Case 1 : 정확성은 모두 정답이지만, 효율성에서는 시간 초과 발생 */
        /*Stack<String> stack = new Stack<>();

        for (String str : s.split("")) {
            if (stack.empty()) stack.push(str);
            else {
                if (")".equals(str) && "(".equals(stack.peek())) stack.pop();
                else stack.push(str);
            }
        }

        System.out.println(stack.empty());*/

        /* Case 2 : char타입 이용하여 수행 */
        Stack<Integer> stack = new Stack<>();

        if (s.length() % 2 == 0) {
            for (int index = 0; index < s.length(); index++) {
                int i = (int) s.charAt(index);

                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }

                if (stack.get(0) == 41) break;

                if (i - stack.peek() == 1) stack.pop();
                else stack.push(i);
            }

            System.out.println(stack.empty());
        } else {
            System.out.println(false);
        }
    }
}

