package Level1;

public class MakeDecimal {
    public static void main(String[] args) {
        //소수만들기 (Summber/Winter Coding(~2018)
        int[] nums = new int[]{1,2,7,6,4};
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int index = nums[i] + nums[j] + nums[k];
                    answer += checkDecimal(index);
                }
            }
        }
        System.out.println(answer);
    }

    public static int checkDecimal (int index) {
        //소수인지 체크
        for (int i = 2; i < index; i++) {
            if (index % i == 0) {
                //나누어지는 것이 존재할 경우 소수가 아님
                return 0;
            }
        }
        return 1;
    }
}