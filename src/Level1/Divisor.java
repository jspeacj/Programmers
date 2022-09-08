package Level1;

public class Divisor {
    //약수 구하기
    public static void main(String[] args) {
        int n = 12;

        int answer = 1; // 약수의 합
        int num = 2;

        while(true) {
            System.out.println();
            if (n % num == 0) answer += num;

            if (num == n) {
                answer += num;
                break;
            }

            num++;
        }

        System.out.println(answer);
    }
}
