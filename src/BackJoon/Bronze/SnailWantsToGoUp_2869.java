package BackJoon.Bronze;

/*
    달팽이는 올라가고 싶다 (브론즈 1)

    문제
    땅 위에 달팽이가 있다.
    이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
    달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다.
    또, 정상에 올라간 후에는 미끄러지지 않는다.
    달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

    출력
    첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

    예제 입력 1
    2 1 5
    예제 출력 1
    4

    예제 입력 2
    5 1 6
    예제 출력 2
    2

    예제 입력 3
    100 99 1000000000
    예제 출력 3
    999999901
 */
import java.util.Scanner;

public class SnailWantsToGoUp_2869 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int now = 0;
        int up = scan.nextInt();
        int down = scan.nextInt();
        int goal = scan.nextInt();
        long cnt = 0; // 조건에 인풋값이 10억까지 주어지므로, 구해야하는 횟수가 21억이 최대한 int타입의 범위를 넘을 수 있기 때문에 long타입으로 지정

        /* 첫번째 풀이 : 시간초과 발생
            while (now < goal) {
            cnt++;
            now += up;
            if (now >= goal) break; // 이미 정상을 올라갔을 경우, 미끄러지지 않는다고 조건에 나와있기 떄문에 바로 종료
            now -= down;
        }
        */

        // 두번째 풀이 : 주어진 예제에서 목표지점 V까지 걸리는 기간은 다음과 같이 유추할 수 있다. => 걸리는 기간(일) : 목표지점(V) - 올라갈 A미터 + 내려갈 B미터
        int num = (up - down) > down ? down : (up - down);
        cnt = goal - up + num;
        System.out.println(cnt);
    }
}
