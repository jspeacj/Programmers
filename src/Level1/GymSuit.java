package Level1;

import java.util.*;

public class GymSuit {
    public static void main(String[] args) {
        /*
            체육복
            문제 설명
            점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
            학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
            예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

            전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
            체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

            제한사항
            전체 학생의 수는 2명 이상 30명 이하입니다.
            체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
            여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
            여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
            여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
            입출력 예
            전체 잃어버림  여벌     결과값
            n	lost	reserve	return
            5	[2, 4]	[1, 3, 5]	5
            5	[2, 4]	[3]	4
            3	[3]	[1]	2
            입출력 예 설명
            예제 #1
            1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

            예제 #2
            3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
        */

        //예제 Input
        final int n = 5;
        final int[] lost = new int[]{2, 4};
        final int[] reserve = new int[]{1, 3, 5};

        //문제 풀이
        //전달받은 input 배열들을 map에 담아두기 위한 Map 선언
        Map<Integer, Integer> lostMap = new HashMap<>();
        Map<Integer, Integer> reserveMap = new HashMap<>();
        
        //최종적으로 수업에 참여가능한 학생을 나타내기 위한 리턴 값 result 선언
        int result = n-lost.length;

        //정렬이 보장이 안되어 있기 때문에 정렬 처리
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //잃어버린 학생의 번호를 lostMap에 0값으로, 여유분을 가지고있는 학생의 번호를 reserveMap에 1값으로 저장
        for (Integer index : lost) lostMap.put(index, 0);
        for (Integer index : reserve) reserveMap.put(index, 1);

        /*
            여유분을 가지고 있는 학생이 체육복을 잃어버렸을 경우,
            빌려줄순없지만, 수업 참여는 가능하므로 result값 1증가 및 해당 학생 번호의 reserveMap값을 0으로 변경
         */
        for (Integer i : lost) {
            for (Integer j : reserve) {
                if (i == j) {
                    result++;
                    reserveMap.put(j, 0);
                }
            }
        }

        /*
            여유분을 가지고 있는 학생은 자기 앞번호나 뒷번호일 경우에만 빌려 줄 수 있으며,
            체육복을 잃어버린 학생이 여유분을 가지고 있는 학생이 아니며, 아직 여유분을 가지고 있는 학생일 경우에만
            체육복을 빌려주도록 로직 적용
         */
        for (Integer i : lost) {
            for (Integer j : reserve) {
                boolean check = (j+1) == i || (j-1) == i;
                if (check && lostMap.get(i) == 0 && !reserveMap.containsKey(i) && reserveMap.get(j) == 1) {
                    result++;
                    lostMap.put(i, 1);
                    reserveMap.put(j, 0);
                }
            }
        }

        System.out.println(result);
    }
}
