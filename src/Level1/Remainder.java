package Level1;

public class Remainder {
    //나머지가 1이 되는 수 찾기 (월간 코드챌린지 시즌3)
    public static void main(String[] args) {
        int num = 12;

        System.out.println(num % 2 == 0 ? evenRemainder(num) : oddRemainder(num));

    }

    public static int oddRemainder(int num) {
        int i = 2;

        while(true) {
            if (num % i == 1) break;

            i += 2;
        }

        return i;
    }

    public static int evenRemainder(int num) {
        int i = 3;

        while(true) {
            if (num % i == 1) break;

            i += 2;
        }

        return i;
    }
}
