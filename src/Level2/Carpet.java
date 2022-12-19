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

        /*
        *       o o o o (yellow : 2)
        *       o x x o
        *       o o o o
        *
        *      o o o o o (yellow : 3)
        *      o x x x o
        *      o o o o o
        *
        *      o o o o        o o o o o o (yellow : 4)
        *      o x x o        o x x x x o
        *      o x x o    OR  o o o o o o
        *      o o o o
        *
        *     o o o o o      o o o o o o o o o o o
        *     o x x x o      o x x x x x x x x x o (yellow : 9)
        *     o x x x o   OR o o o o o o o o o o o
        *     o x x x o
        *     o o o o o
        *
        *
        *
        *    x x x x x x
        *    x x x x x x
        *    x x x x x x
        *    x x x x
        * */

        /* TC 3 */
        int brown = 24;
        int yellow = 24;

       /*
        규칙 : 가로 * 세로 = brown + yellow
        brown     yellow    return
          10         2      [4, 3]
          12         3      [5, 3]
          12(or 14)  4      [4, 4](or [6, 3])

          정사각형이 되는 기준 : 1, 4, 9 .. 제곱근일 경우
          세로의 길이 : (정수형)yellow의 제곱근 + 2
       */

        int[] answer = new int[2];

        if (Math.sqrt(yellow) == (int)Math.sqrt(yellow)) {
            answer[1] = (int)Math.sqrt(yellow) + 2; // 세로의 길이 : (정수형)yellow의 제곱근 + 2
            answer[0] = (brown + yellow) / answer[1]; // 가로 = (brown + yellow) / 세로 길이//
        } else {
        answer[1] = 3; // 세로의 길이 : (정수형)yellow의 제곱근 + 2
        answer[0] = (brown + yellow) / answer[1]; // 가로 = (brown + yellow) / 세로 길이//
        }

        System.out.println(Arrays.toString(answer));

    }
}
