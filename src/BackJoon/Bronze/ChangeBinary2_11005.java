package BackJoon.Bronze;

/*
    진법 변환 2 (브론즈 1)

    10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

    입력
    첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 10진법 수 N을 B진법으로 출력한다.

    예제 입력 1
    60466175 36

    예제 출력 1
    ZZZZZ
 */

import java.util.Scanner;

public class ChangeBinary2_11005 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputArr = scan.nextLine().split(" ");
        int num = Integer.parseInt(inputArr[0]);
        int binary = Integer.parseInt(inputArr[1]);

        System.out.println(convertBinary(num, binary));
    }

    public static String convertBinary(int num, int binary) {
        StringBuilder sb = new StringBuilder();
        String[] list = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M", "N", "L", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        while (true) {
            if (num < binary) {
                sb.insert(0, list[num]);
                break;
            }

            int value = num % binary;
            sb.insert(0, list[value]);
            num /= binary;
        }

        return sb.toString();
    }
}
