package BackJoon.Bronze;

import java.util.Scanner;

/*
    진법 변환 (브론즈 2)

    B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

    입력
    첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)

    B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

    출력
    첫째 줄에 B진법 수 N을 10진법으로 출력한다.

    예제 입력 1
    ZZZZZ 36

    예제 출력 1
    60466175

    풀이 :
    N진법을 10진법으로 변환하는 방법 :
    ex. 54236 (5진법)
    =>  (5 * 5(4)) + (4 * 5(3)) + (2 * 5(2)) + (3 * 5(1)) + (6 * 5(0))
 */
public class ChangeBinary_2745 {
    public static void main(String[] args) {
        String num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int x = 1;
        int total = 0;
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        String[] strArr = arr[0].split("");
        int binary = Integer.parseInt(arr[1]);

        for (int i = strArr.length - 1; i >= 0; i--) {
            total += num.indexOf(strArr[i]) * x;
            x *= binary;
        }

        System.out.println(total);
    }
}
