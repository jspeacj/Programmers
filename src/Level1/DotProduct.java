package Level1;

public class DotProduct {
    public static void main(String[] args) {
        //내적 (월간 코드 챌린지 시즌1)
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{-3, -1, 0, 2};
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }

        System.out.println(answer);
    }
}
