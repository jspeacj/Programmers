package Level1;

public class lotto {
    public static void main(String[] args) {
        //로또의 최고 순위와 최저 순위를 구하시오
        //테스트 케이스 input 선언
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};
        int[] answer = new int[2];

        //지워진 숫자가 어느정도 인지 체크하기위한 변수 선언
        int zeroCnt = 0;
        //당첨번호와 동일한 로또번호가 몇개인지 구하기 위한 변수 선언
        int lottoCnt = 0;

        //최고 당첨 횟수와 최저 당첨 횟수를 저장하기 위한 변수 선언
        int lottoNum = 0;

        for (int i : lottos) {
            // 동생이 낙서한 번호 일 경우, count 횟수를 증가시키고 다음 순서로 이동
            if (i == 0 ) {
                zeroCnt++;
                continue;
            }

            for (int j : win_nums) {
                if (i == j) {
                    //당첨 번호와 동일할 경우 lottoCnt를 증가시키고 해당 반복문 빠져나오기
                    lottoCnt++;
                    break;
                }
            }
        }

        for (int index = 0; index < answer.length; index++) {
            if (index == 0) {
                //당첨될 수 있는 로또 최고 순위
                lottoNum = lottoCnt + zeroCnt;
            } else {
                //당첨될 수 있는 로또 최저 순위
                lottoNum = lottoCnt;
            }

            switch (lottoNum) {
                case 6 :
                    answer[index] = 1;
                    break;

                case 5 :
                    answer[index] = 2;
                    break;

                case 4 :
                    answer[index] = 3;
                    break;

                case 3 :
                    answer[index] = 4;
                    break;

                case 2 :
                    answer[index] = 5;
                    break;

                default :
                    answer[index] = 6;
                    break;
            }
        }

        System.out.println(" 로또 최고 순위 : " + answer[0]);
        System.out.println(" 로또 최저 순위 : " + answer[1]);
    }
}
