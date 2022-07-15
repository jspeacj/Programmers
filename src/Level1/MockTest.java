package Level1;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        // 모의고사
        /*
            1번 수포자가 찍는 방식: 1, 2, 3, 4, 5
            2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5
            3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
         */
        int[] answers = new int[]{1, 3, 2, 4, 2};

        //제일 많이 점수를 얻은 수포자의 번호를 원활하게 저장하기 위한 List 변수 선언
        List<Integer> result = new ArrayList<>();

        //1번, 2번, 3번 수포자의 정답 개수를 저장하기 위한 변수 선언
        int totalNumOne = 0;
        int totalNumTwo = 0;
        int totalNumThree = 0;

        //해당 배열의 값과 각 수포자들의 값을 비교하여 동일할 경우 +1, 동일하지 않을 경우 0을 더한다.
        for (int i = 0; i < answers.length; i++) {
            totalNumOne += numOne(i+1, answers[i]);
            totalNumTwo += numTwo(i+1, answers[i]);
            totalNumThree += numThree(i+1, answers[i]);
        }

        //각 수포자들이 얻은 최대 점수 중, 제일 많이 맞은 점수를 구하기 위한 max변수 선언
        int max = Math.max(Math.max(totalNumOne, totalNumTwo), totalNumThree);

        //최대 점수를 맞은 사람이 여러 명일 수 잇으므로, 최대 점수 max와 각 수포자들이 맞은 점수를 비교해서 동일할 경우 List변수에 포함시킨다.
        if (max == totalNumOne) {
            result.add(1);
        }

        if (max == totalNumTwo) {
            result.add(2);
        }

        if (max == totalNumThree) {
            result.add(3);
        }

        //result는 Integer형이므로, stream을 통해서 Int 배열로 만든다
        int[] answer = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int k : answer) System.out.println(k);
    }

    public static int  numOne(int index, int num) {
        /*
            5번을 기준으로 동일한 패턴이므로 5로 나눈 나머지를 받는다.
            ex) 6번쨰 = 1번째 = 1
         */
        index = index % 5;

        //마지막번째일경우 마지막 순서로 지정
        if (index == 0) index = 5;

        //1번 수포자가 찍은 정답과 다를 경우 0 반환
        switch (index) {
            case 1 : // 1번째
                if (num != 1)  return 0;
                break;

            case 2 : // 2번째
                if (num != 2)  return 0;
                break;

            case 3 : // 3번째
                if (num != 3)  return 0;
                break;

            case 4 : // 4번째
                if (num != 4)  return 0;
                break;

            case 5 : // 5번째
                if (num != 5)  return 0;
                break;
        }
    
        //1번 수포자가 찍은 정답과 일치 할 경우 1 반환
        return 1;
    }

    public static int numTwo(int index, int num) {
        /*
            홀 수 일 경우 2, 짝 수 일 경우 규칙에 따라 1, 3, 4, 5순서이다.
            8번을 기준으로 동일한 패턴이므로 8로 나눈 나머지를 받는다.
            ex) 10번쨰 = 2번째 = 1
         */
        if (index % 2 == 1) { // 홀 수 일 경우, 정답이 2일 경우 1반환, 아닐 경우 0반환
            if (num == 2) return 1;
            else return 0;
        } else { // 짝수 일 경우
            index = index % 8;

            //마지막번째일경우 마지막 순서로 지정
            if (index == 0) index = 8;

            //2번 수포자가 찍은 정답과 다를 경우 0 반환
            switch (index) { //짝수 기준 찍은 순서({}만 짝수이므로 해당 부분 검토) : 2, {1}, 2, {3}, 2, {4}, 2, {5}
                case 2: // 짝수 기준 1번째 (2번 수포자 찍은 답 : 1)
                    if (num != 1) return 0;
                    break;

                case 4: // 짝수 기준 2번째 (2번 수포자 찍은 답 : 3)
                    if (num != 3) return 0;
                    break;

                case 6: // 짝수 기준 3번째 (2번 수포자 찍은 답 : 4)
                    if (num != 4) return 0;
                    break;

                case 8: // 짝수 기준 4번째 (2번 수포자 찍은 답 : 5)
                    if (num != 5) return 0;
                    break;
            }

            //2번 수포자가 찍은 정답과 일치 할 경우 1 반환
            return 1;
        }
    }

    public static int numThree(int index, int num) {
        /*
            10번을 기준으로 동일한 패턴이므로 5로 나눈 나머지를 받는다.
            ex) 11번쨰 = 1번째 = 3
         */
        index = index % 10;

        //마지막번째일경우 마지막 순서로 지정
        if (index == 0) index = 10;

        //3번 수포자가 찍은 정답과 다를 경우 0 반환
        switch (index) {
            case 1 : // 1번째
                if (num != 3)  return 0;
                break;

            case 2 : // 2번째
                if (num != 3)  return 0;
                break;

            case 3 : // 3번째
                if (num != 1)  return 0;
                break;

            case 4 : // 4번째
                if (num != 1)  return 0;
                break;

            case 5 : // 5번째
                if (num != 2)  return 0;
                break;

            case 6 : // 6번째
                if (num != 2)  return 0;
                break;

            case 7 : // 7번째
                if (num != 4)  return 0;
                break;

            case 8 : // 8번째
                if (num != 4)  return 0;
                break;

            case 9 : // 9번째
                if (num != 5)  return 0;
                break;

            case 10 : // 10번째
                if (num != 5)  return 0;
                break;
        }

        //1번 수포자가 찍은 정답과 일치 할 경우 1 반환
        return 1;
    }
}
