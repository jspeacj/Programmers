package Level2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class EmoticonDiscountEvent {
    private static int[] answer = new int[2]; // 반환할 answer값
    private static int[][] discount; // 적용해야할 할인율을 담아두긴 위한 배열
    private static int[][] emoticonsDntPrice; // 할인된 이모티콘 금액을 적기 위한 배열
    private static int MAX_USER_DISCOUNT = 0; // 사용자들이 요구하는 할인율의 최대 퍼센트
    private static boolean checkDiscountFlag = false; // 사용자들이 요구하는 할인율을 모두 충족했을 경우
    public static void main(String[] args) {
        /*
            이모티콘 할인행사 (2023 KAKAO BLIND RECRUITMENT)

            문제 설명
            카카오톡에서는 이모티콘을 무제한으로 사용할 수 있는 이모티콘 플러스 서비스 가입자 수를 늘리려고 합니다.
            이를 위해 카카오톡에서는 이모티콘 할인 행사를 하는데, 목표는 다음과 같습니다.

            이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
            이모티콘 판매액을 최대한 늘리는 것.
            1번 목표가 우선이며, 2번 목표가 그 다음입니다.

            이모티콘 할인 행사는 다음과 같은 방식으로 진행됩니다.

            n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다.
            이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
            카카오톡 사용자들은 다음과 같은 기준을 따라 이모티콘을 사거나, 이모티콘 플러스 서비스에 가입합니다.

            각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
            각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
            다음은 2명의 카카오톡 사용자와 2개의 이모티콘이 있을때의 예시입니다.

            사용자	비율	     가격
              1	     40	    10,000
              2	     25	    10,000

            이모티콘	가격
               1	7,000
               2	9,000
            1번 사용자는 40%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
            2번 사용자는 25%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.

            1번 이모티콘의 가격은 7,000원, 2번 이모티콘의 가격은 9,000원입니다.

            만약, 2개의 이모티콘을 모두 40%씩 할인한다면, 1번 사용자와 2번 사용자 모두 1,2번 이모티콘을 구매하게 되고, 결과는 다음과 같습니다.

            사용자	구매한 이모티콘	이모티콘 구매 비용	이모티콘 플러스 서비스 가입 여부
            1	        1, 2	            9,600	             X
            2	        1, 2	            9,600	             X
            이모티콘 플러스 서비스 가입자는 0명이 늘어나고 이모티콘 판매액은 19,200원이 늘어납니다.

            하지만, 1번 이모티콘을 30% 할인하고 2번 이모티콘을 40% 할인한다면 결과는 다음과 같습니다.

            사용자	구매한 이모티콘	이모티콘 구매 비용	    이모티콘 플러스 서비스 가입 여부
            1	           2	         5,400	                    X
            2	          1, 2	         10,300	                    O
            2번 사용자는 이모티콘 구매 비용을 10,000원 이상 사용하여 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입하게 됩니다.
            따라서, 이모티콘 플러스 서비스 가입자는 1명이 늘어나고 이모티콘 판매액은 5,400원이 늘어나게 됩니다.

            카카오톡 사용자 n명의 구매 기준을 담은 2차원 정수 배열 users, 이모티콘 m개의 정가를 담은 1차원 정수 배열 emoticons가 주어집니다.
            이때, 행사 목적을 최대한으로 달성했을 때의 이모티콘 플러스 서비스 가입 수와 이모티콘 매출액을 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ users의 길이 = n ≤ 100
            users의 원소는 [비율, 가격]의 형태입니다.
            users[i]는 i+1번 고객의 구매 기준을 의미합니다.
            비율% 이상의 할인이 있는 이모티콘을 모두 구매한다는 의미입니다.
            1 ≤ 비율 ≤ 40
            가격이상의 돈을 이모티콘 구매에 사용한다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입한다는 의미입니다.
            100 ≤ 가격 ≤ 1,000,000
            가격은 100의 배수입니다.
            1 ≤ emoticons의 길이 = m ≤ 7
            emoticons[i]는 i+1번 이모티콘의 정가를 의미합니다.
            100 ≤ emoticons의 원소 ≤ 1,000,000
            emoticons의 원소는 100의 배수입니다.

            입출력 예
                                                 users	                                             emoticons	                result
            [[40, 10000], [25, 10000]]	                                                            [7000, 9000]	            [1, 5400]
            [[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]	[1300, 1500, 1600, 4900]	[4, 13860]

            입출력 예 설명
            입출력 예 #1
            문제의 예시와 같습니다.

            입출력 예 #2
            다음과 같이 할인하는 것이 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법입니다.
            이모티콘	할인율
               1	 40
               2	 40
               3	 20
               4	 40
            위와 같이 할인하면 4명의 이모티콘 플러스 가입자와 13,860원의 판매액을 달성할 수 있습니다.
            다른 할인율을 적용하여 이모티콘을 판매할 수 있지만 이보다 이모티콘 플러스 서비스 가입자를 최대한 늘리면서,
            이모티콘 판매액 또한 최대로 늘리는 방법은 없습니다.
            따라서, [4, 13860]을 return 하면 됩니다.
         */

        /* TC 1 result : [1, 5400] */
        //int[][] users = {{40, 10000}, {25, 10000}};
        //int[] emoticons = {7000, 9000};

        /* TC 2 result : [4, 13860] */
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        /*
            문제 이해하기 및 풀이 방식 고민하기 :
            1. 문제에서 요구하는 결과는, 이모티콘 플러스 가입자가 최대이면서, 이모티콘 판매액인 결과를 반환하는 것이다.
            2. 해당 결과를 만족하려면 할인율을 가장 낮은 10퍼부터 시작하면서 이모티콘 판매액을 최대로 맞춰야하는데, 우선순위는 이모티콘 플러스 가입자이다.

            알고리즘 진행 방식 :
            위 문제 이해한 바를 토대로, 알고리즘은 아래와 같이 진행되어야 한다.
              1. 사용자가 정한 할인 비율의 최소 보다 할인율이 적을 경우, 무조건 0원이기 떄문에 구하는 의미가 없다 (예를 들어 모든 사용자가 40프로 이상을 기준으로 잡는다면, 10, 20, 30퍼 할인율은 의미가 없다.
                => 따라서 최소 비율을 정한 다음, 해당 비율을 기준으로 할인율을 세팅한다. (예를 들어 1번 케이스 같은 경우, 최소 할인율은 30프로 부터 시작해야한다.)
              2. 할인율이 가장 낮은 경우의 수부터 문제를 진행하며 (판매액이 가장 높기 떄문), 해당 경우 일때 나온 플러스 가입자와 판매액을 저장하면서 진행한다.
              3. (2) 경우의 수를 진행하면서, 플러스 가입자가 더 많거나, 플러스 가입자가 같더라도 판매액이 더 높은 경우의 수가 생길 경우 결과를 해당 값으로 교체한다.
              4. (2) ~ (3) 경우의 수를 진행하다가, 모든 사용자의 요구하는 할인율 이상을 모든 이모티콘에 적용했을떄까지만 진행하고 종료한다.
                 (이후 할인율을 높이더라도 플러스 사용자는 같거나 더 작으며, 판매액또한 줄어들기 떄문에 계산할 필요가 없다.)

              위 알고리즘 진행방식에서 (2번) 로직 구현하는 방법 :
               1. 해당 알고리즘을 구현하려면 모든 경우의 수를 찾는 완전 탐색 기법을 이용해야 한다.
               2. 이떄, 순서는 상관없기 떄문에 (중복되는 케이스는 제외해야한다.) 이를 제외하고 처리한다.
        */

        emoticonsDntPrice = new int[emoticons.length][2]; //첫번째 열 : 적용한 할인율, 두번째 열 : 할인적용된 금액
        int minDiscount = findMinDiscount(users);
        discount = new int[emoticons.length][((40-minDiscount) / 10) + 1];
        Stack<Integer> stack = new Stack<>();

        setDiscount(users, minDiscount);

        bfs(users, emoticons, stack);

        System.out.println(Arrays.toString(answer));
    }

    public static void setDiscount(int[][] users, int minDiscount) {
        for (int[] user : users) {
            if (user[0] > MAX_USER_DISCOUNT) {
                if (user[0] == 40) MAX_USER_DISCOUNT = 40;
                else MAX_USER_DISCOUNT = ((user[0] / 10) + 1) * 10;
            }
        }

        for (int[] arr : discount) { // 각 이모티콘에 최소 할인율을 시작으로 각각 지정
            int min = minDiscount;
            int index = 0;
            while (true) {
                if (min > 40) break;
                arr[index++] = min;
                min += 10;
            }
        }
    }

    public static int findMinDiscount(int[][] users) {
        int min = Integer.MAX_VALUE;

        for (int[] arr : users) {
            int num = arr[0] / 10 + 1;
            if (min > num) min = num;//16
        }

        min *= 10;
        return min >= 40 ? 40 : min;
    }

    public static void bfs(int[][] users, int[] emoticons, Stack<Integer> stack) {
        for (int i = 0; i < discount[0].length; i++) {
            if (checkDiscountFlag) break;
            stack.add(discount[0][i]);
            if (stack.size() == discount.length) {
                setDiscountPrice(users, emoticons, stack);
                checkSales(users);
                stack.pop();
            } else {
                bfs(users, emoticons, stack);
                stack.pop();
            }
        }
    }

    public static void setDiscountPrice(int[][] users, int[] emoticons, Stack<Integer> stack) {
        // 스택은 후입선출(LIFO)이지만, Iterator는 넣어진 기준대로 주어지는 선입선출(FIFO)이기 떄문에 주의해야한다.
        Iterator<Integer> iterator = stack.iterator();
        int cnt = 0;
        int checkProdMaxDnt = 0; // 최대 할인율이 적용된 상품의 개수 구하기
        while (iterator.hasNext()) {
            int discountPercent = iterator.next();
            emoticonsDntPrice[cnt][0] = discountPercent;
            emoticonsDntPrice[cnt][1] = emoticons[cnt] - (int)(emoticons[cnt] * (discountPercent / 100.0));

            if (discountPercent >= MAX_USER_DISCOUNT) checkProdMaxDnt++;
            cnt++;
        }

        if (checkProdMaxDnt == emoticons.length) checkDiscountFlag = true;
    }

    public static void checkSales(int[][] users) {
        int total = 0;
        int emoticonPlus = 0;
        for (int[] user : users) {
            int minPercent = user[0];
            int maxPirce = user[1];
            int sum = 0;
            boolean flag = true;
            for (int[] dntPrice : emoticonsDntPrice) {
                if (minPercent > dntPrice[0]) continue; // 사용자 기준 할인율보다 적은 할인율이 적용된 상품은 스킵

                sum += dntPrice[1];
                if (sum >= maxPirce) {
                    emoticonPlus++; //이모티콘 플러스 사용자 증가 후 종료 처리
                    flag = false;
                    break;
                }
            }

            if (flag) total += sum;
        }

        if (emoticonPlus > answer[0]) {
            answer[0] = emoticonPlus;
            answer[1] = total;
        } else if (emoticonPlus == answer[0] && total > answer[1]) {
            answer[1] = total;
        }
    }
}
