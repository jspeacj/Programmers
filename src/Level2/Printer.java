package Level2;

import javafx.collections.transformation.SortedList;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Printer {
    public static void main(String[] args) {
        /*
            프린터
            문제 설명
            일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
            그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
            이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
            이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

            1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
            2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
            3. 그렇지 않으면 J를 인쇄합니다.
            예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

            내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

            현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가
            현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
            내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

            제한사항
            현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
            인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
            location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
            입출력 예
              priorities	    location	    return
            [2, 1, 3, 2]	       2	          1
            [1, 1, 9, 1, 1, 1]	   0	          5
            입출력 예 설명
            예제 #1
            문제에 나온 예와 같습니다.

            예제 #2
            6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
         */

        /* TC 1 return : 1 */
        //int[] priorities = {2, 1, 3, 2};
        //int location = 2;

        /* TC 2 return : 5 */
        //int[] priorities = {1, 1, 9, 1, 1, 1};
        //int location = 0;

        /* TC 3 return : 6 */
        int[] priorities = {2, 3, 3, 2, 9, 3, 3};
        int location = 3;

        Deque<Integer> deque = new LinkedList<>(); //priorities배열의 값을 담아둘 양방향 큐 선언
        Deque<Integer> order = new LinkedList<>(); //priorities배열의 순서를 담아둘 양방향 큐 선언
        List<Integer> list = new ArrayList<>(); // 정렬및 중복제거를 위한 ArrayList선언
        int answer = 1;
        int value = priorities[location]; // 대기목록에서 찾는 문서 중요도 값

        for (int i = 0; i < priorities.length; i ++) {
            deque.add(priorities[i]);
            list.add(priorities[i]);
            if (i == location) order.add(1); // 찾아야하는 값
            else order.add(0); // 나머지 찾지 않는 값
        }

        // stream함수 이용하여 중복 제거 및 내림차순으로 정렬
        List<Integer> sortedList = list.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        while (true) {
            int index = sortedList.get(0); // 가장 큰 중요도 값
            int priorityNum = deque.pollFirst(); // 현재 대기목록의 첫번째 서류의 중요도 값
            int presentOrder = order.pollFirst(); // 찾는 값일 경우 : 1, 찾는 값이 아닐 경우 : 0

            if (index > priorityNum) { //중요도가 높은 값이 대기목록에 존재할 경우
                deque.addLast(priorityNum);
                order.addLast(presentOrder);
                continue;
            } else {
                if (presentOrder == 1) break; // 중요도가 더 높은 값이 대기목록에 없으면서, 찾는 값일 경우 종료.
                else {
                    if (index == value) { //중요도가 더 높은 값이 대기목록에 없으면서 찾는 서류가 아니지만, 찾는 서류와 중요도가 동일할 경우
                        deque.addLast(priorityNum);
                        order.addLast(presentOrder);
                        answer++;
                        continue;
                    } else if (deque.contains(index)) { // 해당 중요도 값과 동일한 서류가 아직 존재할 경우
                        answer++;
                        continue;
                    } else { // 중요도가 더 높은 값이 대기목록에 없지만, 찾는 서류가 아니면서 중요도도 다를 경우
                        sortedList.remove(0); //가장 중요도가 높은 값이 인쇄 됐으므로, 높은 값은 삭제 처리
                        answer++; // 찾는 값이 아닌 다른 값이 인쇄됐으므로, 반환 값 증감 처리
                        continue;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
