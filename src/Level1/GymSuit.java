package Level1;

import java.util.*;

public class GymSuit {
    public static void main(String[] args) {

        //체육복
    /* 전체 잃어버림  여벌     결과값
        n	lost	reserve	return
        5	[2, 4]	[1, 3, 5]	5
        5	[2, 4]	[3]     	4
        3	[3]	    [1]	        2
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
