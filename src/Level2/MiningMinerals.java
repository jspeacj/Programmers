package Level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class MiningMinerals {
    public static void main(String[] args) {
        /*
            광물 캐기

            문제 설명

            마인은 곡괭이로 광산에서 광석을 캐려고 합니다.
            마인은 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이를 각각 0개에서 5개까지 가지고 있으며,
            곡괭이로 광물을 캘 때는 피로도가 소모됩니다. 각 곡괭이로 광물을 캘 때의 피로도는 아래 표와 같습니다.

            image

            예를 들어, 철 곡괭이는 다이아몬드를 캘 때 피로도 5가 소모되며, 철과 돌을 캘때는 피로도가 1씩 소모됩니다.
            각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.

            마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.

            사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
            한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
            광물은 주어진 순서대로만 캘 수 있습니다.
            광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
            즉, 곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고, 다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복하며,
            더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캘 때까지 과정을 반복하면 됩니다.

            마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와 광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때,
            마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return 하는 solution 함수를 완성해주세요.

            제한사항
            picks는 [dia, iron, stone]과 같은 구조로 이루어져 있습니다.
            0 ≤ dia, iron, stone ≤ 5
            dia는 다이아몬드 곡괭이의 수를 의미합니다.
            iron은 철 곡괭이의 수를 의미합니다.
            stone은 돌 곡괭이의 수를 의미합니다.
            곡괭이는 최소 1개 이상 가지고 있습니다.

            5 ≤ minerals의 길이 ≤ 50
            minerals는 다음 3개의 문자열로 이루어져 있으며 각각의 의미는 다음과 같습니다.
            diamond : 다이아몬드
            iron : 철
            stone : 돌

            입출력 예
              picks	                                    minerals	                                                                result
            [1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	                              12
            [0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	  50

            입출력 예 설명
            입출력 예 #1
            다이아몬드 곡괭이로 앞에 다섯 광물을 캐고 철 곡괭이로 남은 다이아몬드, 철, 돌을 1개씩 캐면 12(1 + 1 + 1 + 1+ 1 + 5 + 1 + 1)의 피로도로 캘 수 있으며 이때가 최소값입니다.

            입출력 예 #2
            철 곡괭이로 다이아몬드 5개를 캐고 돌 곡괭이고 철 5개를 캐면 50의 피로도로 캘 수 있으며, 이때가 최소값입니다.
         */

        /* TC 1 result : 12 */
        //int[] picks = {1, 3, 2};
        //String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        /* TC 2 result : 50 */
        //int[] picks = {0, 1, 1};
        //String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        /* TC 3 result : 16 */
        //int[] picks = {0, 1, 1};
        //String[] minerals = {"iron", "iron", "stone", "stone", "stone", "iron","iron", "stone"};

        /* TC 4 result : 12 */
        int[] picks = {1, 1, 0};
        String[] minerals = {"iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond"};

        /*
          알고리즘 풀이 순서
           1. 어느 곡괭이를 선택하든, 5개의 광물을 무조건 캐야하므로, 5개씩 묶는다.
           2. 5개씩 묶을 떄, 숫자로 변경한다. (다이아 : 25, 철 : 5, 돌 : 1)
           3. 이후 두가지 경우에 따라 알고리즘을 적용한다.
              (1)모든 광물을 캘 수 있을 경우(곡괭이가 더 많을 경우) :
              => 모든 광물을 5묶음을 기준으로 우선순위 큐(내림차순 정렬)을 이용하여 큰 가치의 곡괭이를 먼저 사용한다.
                 이떄 마지막으로 묶은 광물은 5묶음이 아닐수도 있는데, 해당 광물 묶음은 젤 마지막으로 수행되도록 한다.
                 (곡괭이는 사용할 경우 무조건 5개의 광물을 캐야하기 떄문에)
              (2)모든 광물을 캘 수 없을 경우(광물이 더 많을 경우)
              => 앞에서부터 순서대로 곡괭이 개수 * 5만큼의 광물만을 5묶음으로 묶은뒤 우선순위 큐(내림차순 정렬)을 이용하여 큰 가치의 곡괭이를 먼저 사용한다.
            4. 최소 피로도를 반환한다.
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        boolean checkFlag = false;
        int lastMinerals = 0;
        int length = 0;
        int picksLength = 0;
        int lastMineSize = 0;
        for (int i : picks) {
            if (i > 0) picksLength += i;
        }

        if (picksLength * 5 >= minerals.length) { // 모든 광물을 캘 수 있을 경우(곡괭이가 더 많거나 같을 경우)
            length = minerals.length;
            checkFlag = true;

        } else { // 모든 광물을 캘 수 없을 경우(광물이 더 많을 경우)
            length = picksLength * 5;
        }

        for (int i = 0; i < length; i += 5) {
            if (i + 5 >= length) {
                if(checkFlag) {
                    lastMinerals = checkMinerals(minerals, i, length);
                    lastMineSize = length - i;
                    pq.add(lastMinerals);
                } else {
                    pq.add(checkMinerals(minerals, i, length));
                }
            } else {
                pq.add(checkMinerals(minerals, i, i+5));
            }
        }

        System.out.println(mineMinerals(picks, pq, checkFlag, lastMinerals, lastMineSize));
    }

    private static int mineMinerals(int[] picks, Queue<Integer> queue, boolean checkFlag, int lastMinerals, int lastMineSize) {
        int fatigue = 0;

        while (!queue.isEmpty()) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            int mineral = queue.poll();

            if (checkFlag && mineral == lastMinerals) {
                // 마지막 광물 세트일 경우, 제일 마지막에 수행하기 위해 넘어간다.
                checkFlag = false;
                fatigue += mine(picks, lastMinerals, lastMineSize, true);
            } else {
                fatigue += mine(picks, mineral, lastMineSize, false);
            }
        }
        return fatigue;
    }

    private static int mine(int[] picks, int mineral, int lastMineSize, boolean lastMineCheck) {
        int stamina = 0;
        int mine = 0;

        if (picks[0] > 0) {
            if (lastMineCheck) mine = lastMineSize;
            else mine = 5;
            stamina = mine;
            picks[0]--;
        } else if (picks[1] > 0) {
            mine = (mineral / 5) + (mineral % 5);
            if (lastMineCheck && mine < lastMineSize) {
                mine = lastMineSize;
            } else if (!lastMineCheck && mine < 5) {
                mine = 5;
            }
            stamina = mine;
            picks[1]--;
        } else if (picks[2] > 0) {
            stamina = mineral;
            picks[2]--;
        }

        return stamina;
    }

    private static int checkMinerals(String[] minerals, int startIndex, int lastIndex) {
        int num = 0;
        for (int i = startIndex; i < lastIndex; i++) {
            switch (minerals[i]) {
                case "diamond" :
                    num += 25;
                    break;
                case "iron" :
                    num += 5;
                    break;
                default :
                    num += 1;
                    break;
            }
        }

        return num;
    }
}