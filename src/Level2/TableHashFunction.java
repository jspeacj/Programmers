package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TableHashFunction {
    public static void main(String[] args) {
        /*
            테이블 해시 함수

            문제 설명

            완호가 관리하는 어떤 데이터베이스의 한 테이블은 모두 정수 타입인 컬럼들로 이루어져 있습니다.
            테이블은 2차원 행렬로 표현할 수 있으며 열은 컬럼을 나타내고, 행은 튜플을 나타냅니다.
            첫 번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장됩니다. 완호는 이 테이블에 대한 해시 함수를 다음과 같이 정의하였습니다.

            해시 함수는 col, row_begin, row_end을 입력으로 받습니다.
            테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되,
            만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
            정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
            row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
            테이블의 데이터 data와 해시 함수에 대한 입력 col, row_begin, row_end이 주어졌을 때 테이블의 해시 값을 return 하도록 solution 함수를 완성해주세요.

            제한 사항
            1 ≤ data의 길이 ≤ 2,500
            1 ≤ data의 원소의 길이 ≤ 500
            1 ≤ data[i][j] ≤ 1,000,000
            data[i][j]는 i + 1 번째 튜플의 j + 1 번째 컬럼의 값을 의미합니다.
            1 ≤ col ≤ data의 원소의 길이
            1 ≤ row_begin ≤ row_end ≤ data의 길이

            입출력 예
                            data	            col 	row_begin	    row_end	    result
            [[2,2,6],[1,5,10],[4,2,9],[3,8,3]]	 2	        2	           3	       4

            입출력 예 설명
            정해진 방법에 따라 튜플을 정렬하면 {4, 2, 9}, {2, 2, 6}, {1, 5, 10}, {3, 8, 3} 이 됩니다.
            S_2 = (2 mod 2) + (2 mod 2) + (6 mod 2) = 0 입니다.
            S_3 = (1 mod 3) + (5 mod 3) + (10 mod 3) = 4 입니다.
            따라서 해시 값은 S_2 XOR S_ 3 = 4 입니다.
         */
        
        /* TC 1 result : 4 */
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;

        /*
                     A       B   => reuslt
            XOR :    1   x   1   => 0
                     1   x   0   => 1
                     0   x   1   => 1
                     0   x   0   => 0
                    0000 x  0100 => 0100(4)
        * */
        //삭제 시작
        int[][] check = {{4, 2, 9}, {2, 2, 6}, {1, 5, 10}, {3, 8, 3}};

        System.out.println("ㅡㅡㅡ이전ㅡㅡㅡ");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(" " + data[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                System.out.print(" " + check[i][j] + " ");
            }
            System.out.println();
        }
        //삭제 종료

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        Comparator<int[]> comp = (o1, o2) -> {
            if (o1[col-1] - o2[col-1] == 0) {
                return o2[0] - o1[0];
            } else {
                return o1[col-1] - o2[col-1];
            }
        };

        Arrays.sort(data, comp);

        System.out.println("ㅡㅡㅡ이후ㅡㅡㅡ");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(" " + data[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += (data[i][j] % (i+1));
            }

            list.add(sum);
        }

        System.out.println(list);
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.parseInt("100", 2));

        if (list.size() > 1) {
            for (int num : list) {
                String str = Integer.toBinaryString(num);
                if (sb.length() == 0) {
                    sb.append(str);
                } else {
                    setHash(sb, str);
                }
            }

            System.out.println(Integer.parseInt(sb.toString(), 2));
        } else {
            System.out.println(list.get(0));
        }
    }

    private static void setHash(StringBuilder sb, String str) {
        char[] sbArray = sb.toString().toCharArray();
        char[] strArray = str.toCharArray();

        if (sbArray.length > strArray.length) {
            strArray = Arrays.copyOf(strArray, sbArray.length);
        } else {
            sbArray = Arrays.copyOf(sbArray, strArray.length);
        }

        System.out.println("sbArray : " + Arrays.toString(sbArray));
        System.out.println("strArray : " + Arrays.toString(strArray));
    }
}
