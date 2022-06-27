package Level3;

import java.util.*;
import java.util.stream.Collectors;

public class Immigration_2 {
    public static void main(String[] args) {
        /*
            추가로 고려해야하는 상황 => 해당 테스트 케이스에서는 5분이 걸리는 심사대가 8분으로 넘어가는 심사대보다 더 빠르므로(10->15분) 해당 심사대가 먼저 심사가 끝난다.
            그러므로 단순 반복문으로 순차대로 심사대에 투입하면 최소 소요시간을 구할 수 없으므로, 해당 테스트 케이스에서 해당 로직을 구현한다.
         */

        //input으로 전달받는 테스트 케이스 값 선언
//          int n = 6;
//          int[] times = new int[]{7, 10};
//        int n = 11;
//        int[] times = new int[]{5, 8, 9, 8};
//        int n = 8;
//        int[] times = new int[]{1,9};
        int n = 3;
        int[] times = new int[]{1, 2, 3};
        long answer = 0; //모든 심사가 끝나는 최소 시간

        int getTakenTime = 0; //심사관이 심사 시 소요하는 시간을 저장하기 위한 변수
        int getCntPeople = 0; //심사관이 현재 심사 중인 심사의 남은 시간을 저장하기 위한 변수

        //심사관마다 심사 시 소요되는 시간이 다르므로, 오름차순으로 정렬하기
        List<Integer> sortedTimes = Arrays.stream(times).sorted().boxed().collect(Collectors.toList());

        /*
            takenTime : 심사관이 심사 진행 시 소요되는 시간, remainTime : 현재 심사중인 심사의 남은 시간
            List로 선언한 이유는, 두명 이상의 심사관이 심사 시 소요되는 시간이 동일 할 수 있기 때문에(중복) List로 선언해서 관리하기 위함
         */
        List<examiner> examinerList = new ArrayList<>();
        sortedTimes.stream()
                .forEach(e -> {
                    //처음 시작하자마자 심사 중인 사람이 존재하므로 1로 시작
                    examiner examiner = new examiner(e, 0);
                    examinerList.add(examiner);
                });
        //입국심사를 바로 시작한 인원을 제외한 나머지 대기인원을 기준으로 반복문을 수행한다.
        for (int i = 0; i < n; i++) {
            if (i != n-1) {
                System.out.println("i = " + i);
                //마지막 인원이 아닐 경우
                examiner examiner = examinerList.stream()
                        .min(Comparator.comparing(x -> (x.getTakenTime() * (x.getCntPeople() + 1))))
                        .get();
                System.out.println("examiner.getTakenTime() = " + examiner.getTakenTime());
                getTakenTime = examiner.getTakenTime();
                getCntPeople = examiner.getCntPeople();
                examiner.setCntPeople(++getCntPeople);
                answer = getTakenTime * (getCntPeople);
            } else {
                //마지막 인원일 경우
                examiner examiner = examinerList.stream()
                        .min(Comparator.comparing(x -> (x.getTakenTime() * (x.getCntPeople() + 1)) + x.getTakenTime()))
                        .get();

                System.out.println("examiner.getTakenTime() = " + examiner.getTakenTime());
                getTakenTime = examiner.getTakenTime();
                getCntPeople = examiner.getCntPeople() + 1;
                answer = getTakenTime * getCntPeople;
            }
        }

        System.out.println("answer = " + answer);
    }

    private static class examiner {
        private int takenTime; //심사 시 소요시간
        private int cntPeople; //심사를 진행한 횟수

        public examiner(int takenTime, int remainTime) {
            this.takenTime = takenTime;
            this.cntPeople = remainTime;
        }

        public int getTakenTime() {
            return takenTime;
        }

        public int getCntPeople() {
            return cntPeople;
        }

        public void setTakenTime(int takenTime) {
            this.takenTime = takenTime;
        }

        public void setCntPeople(int cntPeople) {
            this.cntPeople = cntPeople;
        }
    }
}
