package Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoList {
    public static void main(String[] args) {
        /*
            할일 목록

            문제 설명
            오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때,
            todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

            제한사항
            1 ≤ todo_list의 길이 1 ≤ 100
            2 ≤ todo_list의 원소의 길이 ≤ 20
            todo_list의 원소는 영소문자로만 이루어져 있습니다.
            todo_list의 원소는 모두 서로 다릅니다.
            finished[i]는 true 또는 false이고 true는 todo_list[i]를 마쳤음을, false는 아직 마치지 못했음을 나타냅니다.
            아직 마치지 못한 일이 적어도 하나 있습니다.

            입출력 예
                                        todo_list	                                finished	                    result
            ["problemsolving", "practiceguitar", "swim", "studygraph"]	[true, false, true, false]	["practiceguitar", "studygraph"]

            입출력 예 설명
            입출력 예 #1
            예제 1번의 todo_list 중에서 "problemsolving"과 "swim"은 마쳤고,
            "practiceguitar"와 "studygraph"는 아직 마치지 못했으므로 todo_list에서 나온 순서대로 담은 문자열 배열 ["practiceguitar", "studygraph"]를 return 합니다.
         */

        /* TC 1 result : ["practiceguitar", "studygraph"] */
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        List<String> list = new ArrayList<>();
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) list.add(todo_list[i]);
        }

        String[] answer = new String[list.size()];
        for (int j = 0; j < list.size(); j++) answer[j] = list.get(j);
        System.out.println(Arrays.toString(answer));
    }
}
