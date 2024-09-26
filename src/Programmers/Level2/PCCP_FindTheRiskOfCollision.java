package Programmers.Level2;

import java.util.Map;
import java.util.HashMap;

public class PCCP_FindTheRiskOfCollision {
    public static int crashCnt = 0;
    public static boolean[] arrive;
    public static Map<Integer, Integer[]> location = new HashMap<>();
    public static Map<Integer, Integer> checkCrash = new HashMap<>();
    public static void main(String[] args) {
        /*
            [PCCP 기출문제] 3번 / 충돌위험 찾기

            문제 설명
            어떤 물류 센터는 로봇을 이용한 자동 운송 시스템을 운영합니다. 운송 시스템이 작동하는 규칙은 다음과 같습니다.

            물류 센터에는 (r, c)와 같이 2차원 좌표로 나타낼 수 있는 n개의 포인트가 존재합니다. 각 포인트는 1~n까지의 서로 다른 번호를 가집니다.
            로봇마다 정해진 운송 경로가 존재합니다. 운송 경로는 m개의 포인트로 구성되고 로봇은 첫 포인트에서 시작해 할당된 포인트를 순서대로 방문합니다.
            운송 시스템에 사용되는 로봇은 x대이고, 모든 로봇은 0초에 동시에 출발합니다. 로봇은 1초마다 r 좌표와 c 좌표 중 하나가 1만큼 감소하거나 증가한 좌표로 이동할 수 있습니다.
            다음 포인트로 이동할 때는 항상 최단 경로로 이동하며 최단 경로가 여러 가지일 경우, r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.
            마지막 포인트에 도착한 로봇은 운송을 마치고 물류 센터를 벗어납니다. 로봇이 물류 센터를 벗어나는 경로는 고려하지 않습니다.
            이동 중 같은 좌표에 로봇이 2대 이상 모인다면 충돌할 가능성이 있는 위험 상황으로 판단합니다.
            관리자인 당신은 현재 설정대로 로봇이 움직일 때 위험한 상황이 총 몇 번 일어나는지 알고 싶습니다.
            만약 어떤 시간에 여러 좌표에서 위험 상황이 발생한다면 그 횟수를 모두 더합니다.

            운송 포인트 n개의 좌표를 담은 2차원 정수 배열 points와 로봇 x대의 운송 경로를 담은 2차원 정수 배열 routes가 매개변수로 주어집니다.
            이때 모든 로봇이 운송을 마칠 때까지 발생하는 위험한 상황의 횟수를 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            2 ≤ points의 길이 = n ≤ 100
            points[i]는 i + 1번 포인트의 [r 좌표, c 좌표]를 나타내는 길이가 2인 정수 배열입니다.

            1 ≤ r ≤ 100
            1 ≤ c ≤ 100
            같은 좌표에 여러 포인트가 존재하는 입력은 주어지지 않습니다.
            2 ≤ routes의 길이 = 로봇의 수 = x ≤ 100
            2 ≤ routes[i]의 길이 = m ≤ 100
            routes[i]는 i + 1번째 로봇의 운송경로를 나타냅니다. routes[i]의 길이는 모두 같습니다.
            routes[i][j]는 i + 1번째 로봇이 j + 1번째로 방문하는 포인트 번호를 나타냅니다.
            같은 포인트를 연속으로 방문하는 입력은 주어지지 않습니다.
            1 ≤ routes[i][j] ≤ n

            입출력 예
                        points	                            routes	                      result
            [[3, 2], [6, 4], [4, 7], [1, 4]]	        [[4, 2], [1, 3], [2, 4]]	        1
            [[3, 2], [6, 4], [4, 7], [1, 4]]	        [[4, 2], [1, 3], [4, 2], [4, 3]]	9
            [[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]]	[[2, 3, 4, 5], [1, 3, 4, 5]]	    0

            입출력 예 설명
            입출력 예 #1
            충돌위험1.gif
            그림처럼 로봇들이 움직입니다.
            3초가 지났을 때 1번 로봇과 2번 로봇이 (4, 4)에서 충돌할 위험이 있습니다.
            따라서 1을 return 해야 합니다.

            입출력 예 #2
            충돌위험2.gif
            그림처럼 로봇들이 움직입니다.
            1, 3, 4번 로봇의 경로가 같아 이동하는 0 ~ 2초 내내 충돌 위험이 존재합니다.
            3초에는 1, 2, 3, 4번 로봇이 모두 (4, 4)를 지나지만 위험 상황은 한 번만 발생합니다.

            4 ~ 5초에는 1, 3번과 2, 4번 로봇의 경로가 각각 같아 위험 상황이 매 초 2번씩 발생합니다.
            6초에 2, 4번 로봇의 충돌 위험이 발생합니다. 따라서 9를 return 해야 합니다.

            입출력 예 #3
            충돌위험3.gif
            그림처럼 로봇들이 움직입니다.
            두 로봇의 경로는 같지만 한 칸 간격으로 움직이고 2번 로봇이 5번 포인트에 도착할 때 1번 로봇은 운송을 완료하고 센터를 벗어나 충돌 위험이 없습니다.
            따라서 0을 return 해야 합니다.
         */

        /* TC 1 result :  1 */
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {2, 4}};

        /* TC 2 result :  9 */
        //int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        //int[][] routes = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};

        /* TC 3 result :  0 */
        //int[][] points = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        //int[][] routes = {{2, 3, 4, 5}, {1, 3, 4, 5}};

        /* 풀이 방법 :
            모든 로봇이 요구한 모든 운송지점 포인트에 도착했을 경우 종료한다.
            1. Map 타입의 location 변수로 현재 로봇이 위치한 포인트의 좌표를 저장한다.
            2. boolean[] 타입의 arrive 변수로 각 로봇이 지정된 모든 운송 포인트에 도착했는지 판단한다.
            3. Map 타입의 nextPoint 변수로 각 로봇이 다음 포인트가 존재하는지 체크한다. (존재하지 않을 경우 모든 운송을 마친 상황이라는 의미이므로 해당 인덱스 값을 기준으로 arrive 변수에 true를 할당한다.)
            4. 조건에 주어진 대로, x좌표를 이동할 수 있으면 x좌표를 이동시키며, x좌표가 목표 포인트와 동일할 경우 y 좌표를 이동시킨다.
            => 주의할점 : 주어진 테스트 케이스 3처럼 하나의 로봇이 여러개의 운송지점을 지나갈 수 있기 떄문에
            특정 로봇이 이미 운송포인트에 도착한 상황에서 다른 로봇은 이동해야할 경우, 이미 도착한 운송포인트에서 다음 운송포인트가 있을 경우 다음 포인트로 이동되도록 로직을 구현해야한다.
            5. Map 타입의 checkCrash 변수로 각 로봇들이 움직인 다음 좌표 기준으로 충돌한 곳이 있는지 체크한다.
            => 체크 방법 : Key에 해당하는 checkCrash값이 x좌표, Value에 해당하는 checkCrash값이 y좌표이며,
                         각 로봇들의 x좌표 기준으로 value에 해당하는 y값이 있는지 getOrDefault함수를 이용하여 체크하며 결과 값에 따라 아래 로직 진행
                         1. value 값이 없을 경우 : 현재 로봇 기준 해당 좌표에는 어떠한 로봇도 없는 상황이라 충돌이 아니며 해당 값에 y좌표 값을 넣은 다음 다음 로봇으로 진행
                         2. value 값이 존재할 경우 : 이미 value값이 존재할 경우 해당 좌표에는 다른 로봇이 존재한 상황이기 때문에 충돌 상황이므로 충돌 횟수 변수인 crashCnt값을 증가시키고 반복문 종료
         

        */
        init(points, routes);
        move(points, routes);
        System.out.println(crashCnt);
    }

    public static void init(int[][] points, int[][] routes) {
        arrive = new boolean[routes.length];
        for (int i = 0; i < routes.length; i++) {
            int pointX = routes[i][0] - 1;
            location.put(i, new Integer[]{points[pointX][0],points[pointX][1]});
        }
    }

    public static void move(int[][] points, int[][] routes) {
        boolean checkCrash = false;
        boolean finished = true;
        while (finished) {


            // 아직 운송이 끝나지 않는 로봇이 하나라도 존재할 경우 다음으로 진행
            for (int i = 0; i < arrive.length; i++) {
                if (!arrive[i]) {
                    finished = true;
                    break;
                } else {
                    finished = false;
                }
            }
        }
    }
}
