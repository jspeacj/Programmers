package Level2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TruckCrossingBridge {
    public static void main(String[] args) {
        /*
            다리를 지나는 트럭
            문제 설명
            트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
            모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
            다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

            예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
            무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

            경과 시간	다리를 지난 트럭	 다리를 건너는 트럭	    대기 트럭
            0	             []	                []	            [7,4,5,6]
            1~2	             []	                [7]	            [4,5,6]
            3	             [7]	            [4]	            [5,6]
            4	             [7]	            [4,5]	        [6]
            5	             [7,4]	            [5]	            [6]
            6~7	             [7,4,5]	        [6]	            []
            8	             [7,4,5,6]	        []	            []

            따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

            solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
            이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

            제한 조건
            bridge_length는 1 이상 10,000 이하입니다.
            weight는 1 이상 10,000 이하입니다.
            truck_weights의 길이는 1 이상 10,000 이하입니다.
            모든 트럭의 무게는 1 이상 weight 이하입니다.

            입출력 예
            bridge_length	weight	     truck_weights	                      return
            2	              10	     [7,4,5,6]	                          8
            100	              100	     [10]	                              101
            100	              100	     [10,10,10,10,10,10,10,10,10,10]	  110
         */

        /* TC 1 return 8 */
        //int bridge_length = 2;
        //int weight = 10;
        //int[] truck_weights = {7, 4, 5, 6};

        /* TC 2 return 101 */
        //int bridge_length = 100;
        //int weight = 100;
        //int[] truck_weights = {10};

        /* TC 3 return 110 */
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        /*
            문제 이해 및 알고리즘 작성
            - 문제 이해 -
            1. 다리에는 주어진 무게(weight)이하 만큼 트럭이 순차적으로 갈 수 있다.
            2. 다음 무게(weight)를 초과할 경우 현재 다리에 있는 가장 앞에있는 트럭이 지나갈때까지 반복문을 수행한다 (시간초는 주어줘야함)
            3. 가장 앞에있는 트럭이 다리를 지났을 떄, 현재 무게 + 다음 트럭 무게가 주어진 무게보다 클 경우 반복문을 동일 조건으로 계속 수행한다.
            (주어진 무게보다 작을 경우까지 반복문 수행)
            4. 마지막 트럭이 다리를 지난 시간이 주어진 도로 거리 보다 클 경우 로직을 종료한다.
            5. 총 시간 answer 를 반환한다.

            - 선언해야하는 부분 -
            1. prWeight : 현재 다리의 무게
            2. List<Integer> weightList : 현재 다리를 건너고 있는 트럭들의 순서 및 무게
               (prWeight는 list 인덱스들의 합)
            3. List<Integer> timeList : 현재 다리를 건너고 있는 트럭들의 순서 및 시간
               (첫번쨰 행의 시간이 주어진 다리 길이보다 클 경우 weightList와 함꼐 remove시킨다.)
            4. Queue<Integer> queue : 다리를 지나갈 트럭들의 무게를 순서대로 집어넣는다.
            5. answer : 모든 트럭이 지나간 시간(초)
        * */

        int prWeight = 0; // 현재 다리의 무게
        int answer = 0; // 모든 트럭이 지나간 시간(초)
        List<Integer> weightList = new ArrayList<>(); // 현재 다리를 건너고 있는 트럭들의 순서 및 무게 (prWeight는 list 인덱스들의 합)
        List<Integer> timeList = new ArrayList<>(); // 현재 다리를 건너고 있는 트럭들의 순서 및 시간
        Queue<Integer> queue = new LinkedList<>();

        // 다리를 지나갈 트럭들의 무게를 순서대로 집어넣는다.
        for (int n : truck_weights) queue.add(n);

        Iterator<Integer> iterator = queue.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            answer++;
            prWeight = inBridgeTime(weightList, timeList, prWeight, bridge_length);

            if (prWeight + next > weight) {
                while (true) {
                    if (prWeight + next <= weight) break;
                    answer++;
                    prWeight = inBridgeTime(weightList, timeList, prWeight, bridge_length);
                }
            }

            weightList.add(next);
            timeList.add(1);
            prWeight += next;

            if (!iterator.hasNext()) {
                while (prWeight > 0) {
                    answer++;
                    prWeight = inBridgeTime(weightList, timeList, prWeight, bridge_length);
                }
                break;
            }
        }

        System.out.println(answer);
    }

    private static int inBridgeTime(List<Integer> weightList, List<Integer> timeList, int prWeight, int bridge_length) {
        for (int index = 0; index < timeList.size(); index++) {
            timeList.set(index, timeList.get(index) + 1);
            if (timeList.get(index) > bridge_length) {
                prWeight -= weightList.get(index);
                weightList.remove(index);
                timeList.remove(index);
                index--;
            }
        }

        return prWeight;
    }
}
