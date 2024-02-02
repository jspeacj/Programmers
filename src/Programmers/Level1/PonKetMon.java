package Programmers.Level1;

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

        //가져갈 포켓몬 수 choice, 중복 제거된 배열 nums중 작은 값을 리턴한다.
        System.out.println(Math.min(choice, nums.length));
    }
}
