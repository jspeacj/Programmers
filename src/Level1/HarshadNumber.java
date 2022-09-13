package Level1;

public class HarshadNumber {
    public static void main(String[] args) {
        //하샤드 수
        int x = 12;

        int n = x;
        int sum = 0;

        while (true) {
            if(n >= 10) {
                sum = sum + (n % 10);
                n /= 10;
            } else {
                sum += n;
                break;
            }
        }

        if (x % sum == 0) System.out.println(true);
        else System.out.println(false);
    }
}
