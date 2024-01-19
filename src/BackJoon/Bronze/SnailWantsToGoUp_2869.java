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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnailWantsToGoUp_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        long day = 0; // 조건에 인풋값이 10억까지 주어지므로, 구해야하는 횟수가 21억이 최대한 int타입의 범위를 넘을 수 있기 때문에 long타입으로 지정

        /* 첫번째 방법 : 시간 초과 발생
        while (now < goal) {
            day++;
            now += up;
            if (now >= goal) break; // 이미 정상을 올라갔을 경우, 미끄러지지 않는다고 조건에 나와있기 떄문에 바로 종료
            now -= down;
        }
         */

        /*
            두번째 풀이 :
         1. 첫번째 시도 => 주어진 예제에서 목표지점 V까지 걸리는 기간은 다음과 같이 유추할 수 있다. => 걸리는 기간(일) : 목표지점(V) - 올라갈 A미터 + 내려갈 B미터
         예제) 100 99 1000000000 => 999999901
         반례) 6 1 8 => 2 (예상정답) < = > 8 - 6 + 1 = 3 (답이다름)

         2. 두번쨰 시도 => 변수 k => 올라갈 높이 - 내려갈 높이 { 명칭 지정 : 올라갈 높이 : up, 내려갈 높이 : down, 목표 높이 : goal }
            num = ((up - down) > down ? down : (up - down));
            
            cnt = (goal / k) + num
            특이사항 :
            예제1 : 6 1 8 => 2(예상정답) == (8/5) + (1) = 2
            예제2:  100 99 1,000,000,000 => 999,999,901(예상정답) < = > (1,000,000,000 / 1) + (1) = 1,000,000,001
         */

        day = (goal - down) / (up - down);
        if ((goal - down) % (up - down) != 0) day++;

        System.out.println(day);
    }
}
