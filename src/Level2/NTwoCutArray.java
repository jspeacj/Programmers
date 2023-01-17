package Level2;

public class NTwoCutArray {
    public static void main(String[] args) {
        /*
            n^2 배열 자르기
            문제 설명
            정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.

            n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
            i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
            1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
            1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
            새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
            정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ n ≤ 107
            0 ≤ left ≤ right < n2
            right - left < 105
            입출력 예
            n	    left	right	    result
            3	     2	      5	       [3,2,2,3]
            4	     7	      14	[4,3,3,3,4,4,4,4]
         */

        /*
            n : 1     1


            n : 2     1   2
                      2   2

            n : 3     1   2   3  =>   arr : [1, 2, 3, 2, 2, 3, 3, 3, 3]  : arr[2] ~ arr[5] => [3, 2, 2, 3]
                      2   2   3
                      3   3   3

            1 2 3 4 8 15
            2 2 3 4
            3 3 3 4
            4 4 4 4

        * */
        
        /*
        *  규칙 :
        *  1. 해당 2차원 배열의 첫번째 시작값은 행의 인덱스 + 1과 같다.
        *  2. (left + 1) / n) : 시작 행의 위치 값
        *  3. (left + 1) % n : 시작 열의 위치(0일 경우 값은 n이다.)
        *  4. 현재 행의 위치 값 >= 현재 열의 위치 : 행의 위치 값
        *  5. 현재 행의 위치 값 < 현재 열의 위치 : 현재 열의 위치 값
        * */


        /* TC 1  result : [3,2,2,3] */
        int n = 3;
        int left = 2;
        int right = 5;

        /* TC 2  result : [4,3,3,3,4,4,4,4] */
        //int n = 4;
        //int left = 7;
        //int right = 14;

        int[] result = new int[right - left + 1];
        int strRow = (left + 1) / n;
        int strCol = (left + 1) % n == 0? n : (left + 1) % n;

        System.out.println(strRow);
        System.out.println(strCol);

        for (int i = 0; i < result.length + 1; i++) {
            if (strCol >= n) strCol = ++strRow;

        }
    }
}
