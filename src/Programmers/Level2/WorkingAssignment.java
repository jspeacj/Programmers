package Programmers.Level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class WorkingAssignment {
    public static void main(String[] args) {
        /*
            과제 진행하기(성공 코드... 혼자 구현한 코드로는 66.6점으로 통과 못해서 참고해서 구현한 코드. 실패한 코드는 WorkingAssignmentFail에서 확인하기)

            문제 설명
            과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.
            과제는 시작하기로 한 시각이 되면 시작합니다.
            새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
            진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
            만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
            멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
            과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.

            제한사항
            3 ≤ plans의 길이 ≤ 1,000
            plans의 원소는 [name, start, playtime]의 구조로 이루어져 있습니다.

            name : 과제의 이름을 의미합니다.
            2 ≤ name의 길이 ≤ 10
            name은 알파벳 소문자로만 이루어져 있습니다.
            name이 중복되는 원소는 없습니다.

            start : 과제의 시작 시각을 나타냅니다.
            "hh:mm"의 형태로 "00:00" ~ "23:59" 사이의 시간값만 들어가 있습니다.
            모든 과제의 시작 시각은 달라서 겹칠 일이 없습니다.
            과제는 "00:00" ... "23:59" 순으로 시작하면 됩니다. 즉, 시와 분의 값이 작을수록 더 빨리 시작한 과제입니다.

            playtime : 과제를 마치는데 걸리는 시간을 의미하며, 단위는 분입니다.
            1 ≤ playtime ≤ 100
            playtime은 0으로 시작하지 않습니다.
            배열은 시간순으로 정렬되어 있지 않을 수 있습니다.
            진행중이던 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우 진행중이던 과제는 끝난 것으로 판단합니다.

            입출력 예
                                                plans	                                                                                      result
            [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]	                                ["korean", "english", "math"]
            [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
            [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]	                                        ["bbb", "ccc", "aaa"]

            입출력 예 설명

            입출력 예 #1
            "korean", "english", "math"순으로 과제를 시작합니다.

            "korean" 과제를 "11:40"에 시작하여 30분 후인 "12:10"에 마치고, 즉시 "english" 과제를 시작합니다.
            20분 후인 "12:30"에 "english" 과제를 마치고, 즉시 "math" 과제를 시작합니다.
            40분 후인 "01:10"에 "math" 과제를 마칩니다.
            따라서 "korean", "english", "math" 순으로 과제를 끝내므로 차례대로 배열에 담아 반환합니다.

            입출력 예 #2
            "music", "computer", "science", "history" 순으로 과제를 시작합니다.

            시각	진행 중 과제	잠시 멈춘 과제	설명
            "12:20"	"music"	[ ]	"music"을 시작합니다.
            "12:30"	"computer"	["music"]	"music"을 잠시 멈추고(남은 시간 30분) "computer"를 시작합니다
            "12:40"	"science"	["music", "computer"]	"computer"를 잠시 멈추고(남은 시간 90분) "science"를 시작합니다
            "13:30"	"computer"	["music"]	"science"를 끝내고 가장 최근에 멈춘 "computer"를 다시 시작합니다
            "14:00"	"history"	["music", "computer"]	"computer"를 잠시 멈추고(남은 시간 60분) "history"를 시작합니다
            "14:30"	"computer"	["music"]	"history"를 끝내고 가장 최근에 멈춘 "computer"를 다시 시작합니다"
            "15:30"	"music"	[ ]	"computer"를 끝내고 가장 최근에 멈춘 "music"을 다시 시작합니다"
            "16:00"	-	[ ]	"music"을 끝냅니다
            따라서 ["science", "history", "computer", "music"] 순서로 과제를 마칩니다.

            입출력 예 #3
            설명 생략
         */

        /* TC 1 result : ["korean", "english", "math"] */
        //String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

        /* TC 2 result : ["science", "history", "computer", "music"] */
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        /* TC 3 result : ["bbb", "ccc", "aaa"] */
        //String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};

        /* TC 4 result : */
        // String[][] plans=  {{"A", "12:00", "30"}, {"B", "12:10", "20"}, {"C", "15:00", "40"}, {"D", "15:10", "30"}};

        /* TC 4 result : */
        //String[][] plans= {{"1", "00:00", "30"}, {"2", "00:10", "10"}, {"3", "00:30", "10"}, {"4", "00:50", "10"}};

        /*
            문제 규칙 이해하기 및 적용해야할 알고리즘 및 로직 판단하기
            1. 배열은 정렬되어 있지 않다.
            => 우선순위 큐(Priority Queue)를 이용하여 시간을 기준으로 오름차순으로 배열이 자동 정렬되도록 지정한다.

            2. 새로운 과제가 시작이 되었을 떄, 기존에 했던건 멈추고 새로운 과제를 시작한다.
            => 우선순위 큐에서 peek()함수를 이용하여 다음 과제의 시간을 알아낸 뒤,
            다음 과제의 시간이 현재 과제에 걸리는 시간보다 작을 경우(현재 과제 수행하는 시간보다 새로운 과제를 해야하는 시간이 먼저 올 경우)
            현재 과제 배열 playtime 남은 시간으로 변경한 뒤 미리 선언해둔 대기(Wait) 큐(Queue) 에다가 집어 넣은 후 다음 과제를 시작한다.
            (멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제(가장 마지막으로 담아둔 과제)부터 시작해야하기 떄문에 큐로 선언)

            3. 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행한다.
            => 위 2번 케이스에 해당하지 않아서 다음 과제가 시작하기 전에 현재 과제를 모두 끝냈을 때 아래와 같이 수행한다.
            1. 만약 다음 과제가 존재할 경우, 다음 과제를 먼저 수행한다. (멈춰둔 과제는 신경 X)
            2. 다음 과제가 없고 멈춰둔 과제가 있을 경우, 멈춰둔 과제를 수행한다.
        */

        int index = 0, currentTime = 0;
        PriorityQueue<homeWork> plan = new PriorityQueue<>((a, b) -> Integer.compare(a.startTime, b.startTime));
        Stack<homeWork> later = new Stack<>();

        for (String[] arr : plans) plan.add(new homeWork(arr));

        String[] answer = new String[plans.length];

        while (!plan.isEmpty() || !later.isEmpty()) {
            if (plan.isEmpty()) {
                // 새 작업이 없을 경우 : 진행중인 작업 하나씩 처리 (현재시간 갱신없이 stack만 비어내면 된다.)
                answer[index++] = later.pop().subject;
            } else if (later.isEmpty()) {
                // 진행중인 작업이 없음 : 새 작업의 시작시간까지 기다린 후 새 작업 시작
                currentTime = plan.peek().startTime;
                later.push(plan.poll());
            } else {
                // 새 작업과 진행중인 작업이 모두 있을 경우 : 시간 비교 필요
                if (plan.peek().startTime < currentTime + later.peek().remainTime) {
                    // 새 작업 시작 전에 진행중인 작업 완료 불가 : 진행 중 작업 잔여시간 갱신 및 새 작업 시작
                    later.peek().remainTime -= plan.peek().startTime - currentTime;
                    currentTime = plan.peek().startTime;
                    later.push(plan.poll());
                } else {
                    // 새 작업 시작 전에 진행중인 작업 완료 : 진행중인 작업 완료 및 현재시간 갱신
                    currentTime += later.peek().remainTime;
                    answer[index++] = later.pop().subject;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }

    public static class homeWork {
        String subject;
        int startTime, remainTime;

        public homeWork(String[] info) {
            this.subject = info[0];
            String[] split = info[1].split(":");
            this.startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            this.remainTime = Integer.parseInt(info[2]);
        }
    }
}
