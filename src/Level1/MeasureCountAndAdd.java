package Level1;

public class MeasureCountAndAdd {
    public static void main(String[] args) {
        /*
            약수의 개수와 덧셈
            문제 설명
            두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

            제한사항
            1 ≤ left ≤ right ≤ 1,000
            입출력 예
            left	right	result
             13	      17	  43
             24	      27	  52
         */

        int left = 24;
        int right = 27;

        int odd = 0; // 홀수
        int even = 0; // 짝수
        int count = 1; // 약수 개수 (n이 1인 경우는 미리 개수로 취급)

        for (int index = left; index <= right; index++) {
            count = 1; // 약수 개수 초기화
            for (int n = 2; n <= index; n++) {
                if (index % n == 0) count++;
            }

            if (count % 2 == 0) { //약수 개수가 짝수 일 경우
                even += index;
            } else { //약수 개수가 홀수 일 경우
                odd += index;
            }
        }

        System.out.println(even - odd);
    }
}
