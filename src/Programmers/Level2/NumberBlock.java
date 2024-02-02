package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberBlock {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        /*
            숫자 블록

            문제 설명
            그렙시에는 숫자 0이 적힌 블록들이 설치된 도로에 다른 숫자가 적힌 블록들을 설치하기로 하였습니다. 숫자 블록을 설치하는 규칙은 다음과 같습니다.

            블록에 적힌 번호가 n 일 때, 가장 첫 블록은 n * 2번째 위치에 설치합니다. 그 다음은 n * 3, 그 다음은 n * 4, ...위치에 설치합니다.
            기존에 설치된 블록은 빼고 새로운 블록을 집어넣습니다.

            블록은 1이 적힌 블록부터 숫자를 1씩 증가시키며 순서대로 설치합니다. 예를 들어 1이 적힌 블록은 2, 3, 4, 5, ... 인 위치에 우선 설치합니다.
            그 다음 2가 적힌 블록은 4, 6, 8, 10, ... 인 위치에 설치하고, 3이 적힌 블록은 6, 9, 12... 인 위치에 설치합니다.

            이렇게 3이 적힌 블록까지 설치하고 나면 첫 10개의 블록에 적힌 번호는 [0, 1, 1, 2, 1, 3, 1, 2, 3, 2]가 됩니다.

            그렙시는 길이가 1,000,000,000인 도로에 1부터 10,000,000까지의 숫자가 적힌 블록들을 이용해 위의 규칙대로 모두 설치 했습니다.

            그렙시의 시장님은 특정 구간에 어떤 블록이 깔려 있는지 알고 싶습니다.

            구간을 나타내는 두 정수 begin, end 가 매개변수로 주어 질 때, 그 구간에 깔려 있는 블록의 숫자 배열을 return하는 solution 함수를 완성해 주세요.

            제한 사항
            1 ≤ begin ≤ end ≤ 1,000,000,000
            end - begin ≤ 5,000

            입출력 예
            begin	end	            result
              1	     10	 [0, 1, 1, 2, 1, 3, 1, 4, 3, 5]

            입출력 예 설명
            입출력 예 #1
            다음과 같이 블럭이 깔리게 됩니다.

            Imgur
         */

        /* TC 1 result : [0, 1, 1, 2, 1, 3, 1, 4, 3, 5] */
        long begin = 1;
        long end = 10;

        /*
            규칙 찾기 :
            각 정수 n값에 따른 인덱스 순서 (n * 2부터 시작) :
            1 : 2, 3, 4, 5, 6, 7, 8, 9, 10, ...
            2 : 4, 6, 8, 10, 12, 14, 16, 18, 20, ...
            3 : 6, 9 ,12, 15, 18, 21, 24, 27, 30, ...
            4 : 8, 12, 16, 20, 24, 28, 32, 36, 40, ...
            12 : 1, 2, 3, 4, 6
            16 : 1, 2, 4, 8
            규칙 :
            1. 각 블록이 소수일 경우 1, 소수가 아닐 경우 자기 자신을 제외한 최대 값을 가집니다.
            (이때, 조건에 10,000,000 숫자까지의 블록으로 정의되어 있기 떄문에, 소수를 구할때 해당 값을 나눴을 떄 10,000,000보다 작을 경우
            해당 값이 자기 자신을 제외한 최대 값이므로 해당 값을 반환합니다.)
         */

        int[] answer = new int[(int)(end - begin) + 1];
        int index = 0;

        for (long i = begin; i <= end; i++)	answer[index++] = getMeasure(i);

        System.out.println(Arrays.toString(answer));
    }

    public static int getMeasure(long begin) {
        if (begin == 1) return 0;
        list.clear();

        for (int i = 2; i <= Math.sqrt(begin); i++) {
            if (begin % i == 0) {
                list.add(i);
                if (begin / i <= 10000000) return (int)begin / i;
            }
        }
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }

        return 1;
    }
}
