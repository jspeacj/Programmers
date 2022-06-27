package Level1;

import java.util.*;
import java.util.stream.Collectors;

public class PuppetDraw {
    public static void main(String[] args) {
        //크레인 인형뽑기(2019 카카오 개발자 겨울 인턴십)
        int[][] board = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = new int[]{1,5,3,5,1,2,1,4};
        int answer = 0;

        //바구니를 표현할 arrayList 선언 (삭제를 용이하게 하기 위해 리스트로 선언)
        List<Integer> basket = new ArrayList<>();

        //basket의 연속된 인형이 존재하지 않을 때까지 반복문을 돌리기 위한 flag변수 선언
        boolean checkFlag = true;

        /*
            1.이중 반복문을 이용하며, moves -1 의 값을 열로 지정하며, 해당 열의 제일 상단 행의 값을 장바구니 basket에 넣기
            2.바구니에 해당 인형을 넣었을 경우, 해당 위치의 인형은 더이상 존재하지 않으므로, 0으로 변환한다.
         */

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int index = board[j][moves[i]-1];
                if (index != 0) {
                    basket.add(index);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }

        /*
            연속된 인형을 제거했을 경우, 기존에는 연속되지 않았으나 제거된 인형이 사라지면서 연속된 인형이 될 수도 있으므로,
            flag변수를 이용하여, 더이상 연속된 인형이 존재하지 않을때까지 반복문을 수행한다.
         */
        while(checkFlag) {
            checkFlag = false;
            for (int index = 0; index < basket.size(); index++) {
                if (index != 0) {
                    if (basket.get(index) == basket.get(index - 1)) {
                        answer += 2;
                        basket.remove(index);
                        basket.remove(index - 1);
                        checkFlag = true;
                        break;
                    }
                }
            }
        }
    }
}
