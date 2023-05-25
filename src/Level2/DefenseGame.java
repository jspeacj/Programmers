package Level2;

import java.util.PriorityQueue;

public class DefenseGame {
    public static void main(String[] args) {
        /*
            디펜스 게임

            문제 설명

            준호는 요즘 디펜스 게임에 푹 빠져 있습니다.
            디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임입니다.
            디펜스 게임은 다음과 같은 규칙으로 진행됩니다.

            준호는 처음에 병사 n명을 가지고 있습니다.
            매 라운드마다 enemy[i]마리의 적이 등장합니다.
            남은 병사 중 enemy[i]명 만큼 소모하여 enemy[i]마리의 적을 막을 수 있습니다.
            예를 들어 남은 병사가 7명이고, 적의 수가 2마리인 경우, 현재 라운드를 막으면 7 - 2 = 5명의 병사가 남습니다.
            남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료됩니다.
            게임에는 무적권이라는 스킬이 있으며, 무적권을 사용하면 병사의 소모없이 한 라운드의 공격을 막을 수 있습니다.
            무적권은 최대 k번 사용할 수 있습니다.
            준호는 무적권을 적절한 시기에 사용하여 최대한 많은 라운드를 진행하고 싶습니다.

            준호가 처음 가지고 있는 병사의 수 n, 사용 가능한 무적권의 횟수 k, 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열 enemy가 매개변수로 주어집니다. 준호가 몇 라운드까지 막을 수 있는지 return 하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ n ≤ 1,000,000,000
            1 ≤ k ≤ 500,000
            1 ≤ enemy의 길이 ≤ 1,000,000
            1 ≤ enemy[i] ≤ 1,000,000
            enemy[i]에는 i + 1 라운드에서 공격해오는 적의 수가 담겨있습니다.
            모든 라운드를 막을 수 있는 경우에는 enemy[i]의 길이를 return 해주세요.

            입출력 예
            n	k	        enemy	            result
            7	3	[4, 2, 4, 5, 3, 3, 1]	      5
            2	4	    [3, 3, 3, 3]	          4

            입출력 예 설명

            입출력 예#1
            1, 3, 5 라운드의 공격을 무적권으로 막아내고, 2, 4 라운드에 각각 병사를 2명, 5명 소모하면 5라운드까지 공격을 막을 수 있습니다.
            또, 1, 3, 4번째 공격을 무적권으로 막아내고, 2, 5 번째 공격에 각각 병사를 2명, 3명 소모하여 5라운드까지 공격을 막을 수 있습니다.
            그보다 많은 라운드를 막는 방법은 없으므로 5를 return 합니다.

            입출력 예#2
            준호는 모든 공격에 무적권을 사용하여 4라운드까지 막을 수 있습니다.
         */

        /*
           알고리즘 구현 순서 :
            1. 반복문을 통해 enemy의 값을 선언한 num값에다가 더하고, 내림차순으로 선언해둔 우선순위 큐(Priority Queue)에다가도 담는다.
            2. num의 값을 k와 비교해서 아래 두가지 케이스 중 하나를 수행한다.
               (1) k >= num : continue
               (2) k < num :
                   => k값이 0보다 클 경우 : k값을 1 감소시키고, 우선순위 큐에서 값을 하나 뺸 뒤 해당 값을 num에서도 뺸다.
                   => k값이 0일 경우 : 반복문을 종료한다.
            3. 반복문을 수행하면서 증가시킨 answer를 반환시킨다.
         */

        /* TC 1 result : 5 */
        //int n = 7;
        //int k = 3;
        //int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        /* TC 2 result : 4 */
        int n = 2;
        int k = 4;
        int[] enemy = {3, 3, 3, 3};

        int answer = 0, num = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        if (k >= enemy.length) {
            System.out.println(enemy.length);
        } else {
            for (int i = 0; i < enemy.length; i++) {
                num += enemy[i];
                pq.add(enemy[i]);

                if (n >= num) {
                    answer++;
                    continue;
                } else {
                    if (k > 0) {
                        answer++;
                        k--;
                        int deleteNum = pq.poll();
                        num -= deleteNum;
                        continue;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
