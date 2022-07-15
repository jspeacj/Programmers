package Level1;

import java.util.Arrays;

public class PonKetMon {
    public static void main(String[] args) {
        // 폰켓몬(Level 1)
        int[] nums = new int[]{3,3,3,2,2,4};
        int answers = 0;

        // 가져갈 폰켓몬 수
        int choice = nums.length / 2;

        // 중복제거
        nums = Arrays.stream(nums).distinct().toArray();

        if (choice >= nums.length) { //선택해야할 폰켓몬 수가 중복 제거 한 배열수보다 크거나 같을 경우
            System.out.println(nums.length);
        } else { // 선택해야할 폰켓몬 수가, 중복 제거 한 배열 수보다 작을 경우
            System.out.println(choice);
        }
    }
}
