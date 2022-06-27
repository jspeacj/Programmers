package Level1;

public class NegativePositiveNum {
    public static void main(String[] args) {
        //음양더하기 (월간 코드 챌린지 시즌2)
        int[] absolutes = new int[]{4, 7, 12};
        boolean[] signs = new boolean[]{true, false, true};
        int answer = 0;

        for (int index = 0; index < absolutes.length; index++) {
            if (signs[index]) {
                //양수일 경우
                answer += absolutes[index];
            } else {
                //음수일 경우
                answer -= absolutes[index];
            }
        }

        System.out.println(answer);
    }
}
