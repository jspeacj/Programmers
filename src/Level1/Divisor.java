package Level1;

public class Divisor {
    //약수 구하기
    public static void main(String[] args) {
        int n = 5;

        int answer = 1; // 약수의 합
        int num = 2;

        while(true) {
            if (n == 1) break;

            if (n == 0) {
                answer = 0;
                break;
            }

            if (num == n) {
                answer += num;
                break;
            }

            if (n % num == 0) {
                answer += num;
            }

            num++;
        }

        System.out.println(answer);
    }
}
