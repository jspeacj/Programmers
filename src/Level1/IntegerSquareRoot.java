package Level1;

public class IntegerSquareRoot {
    public static void main(String[] args){
        //정수 제곱근 판별
        long n = 121;
        long result = 0;

        for (long i = 1; i <= n; i++) {
            if (i * i == n) {
                System.out.println((i + 1) * ( i + 1));
                break;
            }
        }

        System.out.println(-1);
    }
}
