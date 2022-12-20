package Level2;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        /*
            카펫
            문제 설명
            Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

            Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

            Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

            제한사항
            갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
            노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
            카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
            입출력 예
            brown	yellow	return
             10	      2	    [4, 3]
             8	      1	    [3, 3]
             24	      24	[8, 6]
         */

        /* TC 1 */
        //int brown = 10;
        //int yellow = 2;

        /* TC 2 */
        //int brown = 8;
        //int yellow = 1;

        /* TC 3 */
        int brown = 24;
        int yellow = 24;

        /* Case 1 : 일부 케이스 에러로 인해 실패
        int[] answer = new int[2];

        if (Math.sqrt(yellow) == (int)Math.sqrt(yellow)) {
            answer[1] = (int)Math.sqrt(yellow) + 2; // 세로의 길이 : (정수형)yellow의 제곱근 + 2
            answer[0] = (brown + yellow) / answer[1]; // 가로 = (brown + yellow) / 세로 길이//
        } else {
            answer[1] = yellow + 2; // 세로의 길이 : (정수형)yellow의 제곱근 + 2
            answer[0] = (brown + yellow) / answer[1]; // 가로 = (brown + yellow) / 세로 길이//
        }

        System.out.println(Arrays.toString(answer));
        */

        /* Case 2 : 규칙 두가지를 찾아서, 해당 두 규칙을 조합하여 구한 세로의 식을 이용하여 세로를 구한 뒤, 가로도 구하는 방식
        규칙 (1) : 가로 * 세로 = brown + yellow
            (2) : (가로-2)(세로-2) = yellow

            규칙 (1), (2)번을 서로 조합하여 아래와 같이 식을 계산
            ① yellow = 가로 * 세로 - 2가로 - 2세로 + 4 = 가로 * 세로 - brown
            ② brown = 2가로 + 2세로 + 4
            ③ 가로 + 세로 = (brown / 2) + 2
            ④ 가로 = (brown / 2) + 2 - 세로
            ⑤ 가로 = (brown + yellow) / 세로 = (brown / 2) + 2 - 세로
            ⑥ (brown + yellow) / 세로 = (brown / 2) + 2 - 세로
            ⑦ (brown + yellow) / 세로 + 세로 = (brown / 2) + 2 => 같지 않을 경우 같을 때까지 세로를 증가시키면 세로 값을 찾을 수 있다.
       */

        int[] result = new int[2];
        int y = 1; // 제한 사항에서 주어진 세로의 최소 길이 선언

        while (true) {
            //정수형으로 처리를 할 경우, 소수점을 제외하고 처리가 되어 부적절하게 맞는 경우가 존재하여 올림 함수 이용하여 계산 처리
            if (Math.ceil((double)(brown + yellow) / y) + y != (brown / 2) + 2) y++;
            else break;
        }

        result[0] = (brown + yellow) / y;
        result[1] = y;
        System.out.println(Arrays.toString(result));
    }
}
