package Programmers.Level1;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        /*
            비밀지도
            네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
            그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
            다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

            지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
            전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자.
            지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
            지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
            "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
            암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
         */

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String arr1ToBinary = "";
        String arr2ToBinary = "";
        String[] answer = new String[n];

        //Integer.toBinaryString(int i); // 10진수를 2진법으로 변환
        //Integer.toOctalString(int i); // 10진수를 8진법으로 변환
        //Integer.toHexString(int i); // 10진수를 16진법으로 변환

        for (int i = 0; i < n; i++) {
            String checkValue = "";
            arr1ToBinary = convertNotation(arr1[i], 2, n);
            arr2ToBinary = convertNotation(arr2[i], 2, n);

            for (int j = 0; j < arr1ToBinary.length(); j++) {
                int i1 = Integer.parseInt(arr1ToBinary.substring(j, j + 1));
                int i2 = Integer.parseInt(arr2ToBinary.substring(j, j + 1));
                if (i1 + i2 >= 1) {
                     checkValue += "#";
                } else {
                     checkValue += " ";
                }
            }

            answer[i] = checkValue;
        }

        System.out.println(Arrays.toString(answer));

        //######","###  #","##  ##","#### ","#####","### #
        //######","###  #","##  ##"," #### "," #####","### #
        String[] answer1 = new String[5];
        for (int a = 0; a < n; a++) {
            answer1[a] = Integer.toBinaryString(arr1[a] | arr2[a]);
            answer1[a] = answer1[a].replaceAll("1", "#");
            answer1[a] = answer1[a].replaceAll("0", " ");
        }

        System.out.println(Arrays.toString(answer1));
    }

    /*
        10진법 => N진법 변환 함수.
        정사각형이기 때문에 자리수를 맞춰야하므로 정사각형의 가로(세로)길이 n에 맞춰서 값을 채운다.
     */
    public static String convertNotation(int num, int notation, int n) {
        StringBuffer sb = new StringBuffer();

        while (true) {
            if (num < notation) {
                sb.insert(0, num);
                break;
            }

            sb.insert(0, num % notation);
            num /= notation;
        }

        // 정사각형이기 때문에 자리수를 맞춰야하므로 정사각형의 가로(세로)길이 n에 맞춰서 값을 채운다.
        while (sb.length() < n) sb.insert(0, 0);

        return sb.toString();
    }
}
