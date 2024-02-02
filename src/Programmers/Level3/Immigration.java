package Programmers.Level3;

import java.util.*;
import java.util.stream.Collectors;

public class Immigration {
    public static void main(String[] args) {
        //input으로 전달받는 테스트 케이스 값 선언
        int n = 6;
        int[] times = new int[]{7, 10};
        long answer = 0; //모든 심사가 끝나는 최소 시간

        int getTakenTime = 0; //심사관이 심사 시 소요하는 시간을 저장하기 위한 변수
        int getCntPeople = 0; //심사관이 현재 심사 중인 심사의 남은 시간을 저장하기 위한 변수
        long minTakenTime = 1000000000; //마지막 심사를 진행 할 떄, 최소 소요 시간이 걸리는 시간을 저장하기 위한 변수
        int sortedTimesIndex = 0; //마지막 심사대에 새로 대기인원이 들어갔을 때, 대기인원이 두명 이상(마지막 인원이 아닐 경우), 처음 심사대로 돌아가기 위한 변수 선언

        //처음 심사를 진행할 때 모든 심사대는 비어 있으므로 해당 심사대만큼 전체 인원에서 뺴기 (대기 시간 X)
        n = n - times.length;

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
                    examiner examiner = new examiner(e, 1);
                    examinerList.add(examiner);
                });

        //입국심사를 바로 시작한 인원을 제외한 나머지 대기인원을 기준으로 반복문을 수행한다.
        for (int i = 0; i < n; i++) {
            if(i != n-1) { //마지막 대기 인원이 아닐 경우
                //해당 심사대의 심사 가 종료 되었으므로, 해당 심사 종료 소요 시간을 answer에 저장한다.
                getTakenTime = examinerList.get(sortedTimesIndex).getTakenTime();
                getCntPeople = examinerList.get(sortedTimesIndex).getCntPeople();

                answer =  getTakenTime * getCntPeople;
                examinerList.get(sortedTimesIndex).setCntPeople(++getCntPeople);

                if (sortedTimesIndex != sortedTimes.size() - 1) {
                    //마지막 심사대가 아닐 경우, 다음 심사대로 이동하기 위해 1을 더한다.
                    sortedTimesIndex++;
                } else {
                    //마지막 심사대일 경우, 처음 심사대로 가기 위해 0으로 초기화 한다.
                    sortedTimesIndex = 0;
                }
            } else { //마지막 대기 인원일 경우
                //마지막 대기인원이 투입될 때이므로, 해당 심사대에 인원 +1을 증가
                examinerList.get(sortedTimesIndex).setCntPeople(--getCntPeople);
                getTakenTime = examinerList.get(sortedTimesIndex).getTakenTime();
                getCntPeople = examinerList.get(sortedTimesIndex).getCntPeople();
                answer =  getTakenTime * getCntPeople;
                /*
                    각 심사관이 진행하는 심사의 남은 시간 + 심사진행시간이 가장 짧은 시간을 찾아서
                    해당 심사대가 현재 비어있는 심사대에서 진행 하는 것보다 더 빠를 경우
                    대기하다가 해당 심사대에서 진행하며, 비어있는 심사대가 더 빠를 경우 대기없이 해당 심사대에서 진행
                 */
                for (examiner examiner : examinerList) {
                    getTakenTime = examiner.getTakenTime();
                    long getRemainedTime = getTakenTime - (answer % examiner.getTakenTime());
                    long totalTakenTime = 0;

                    if (getRemainedTime == getTakenTime) {
                        //비어있는 심사대일 경우 심사 처리 시간으로만 적용
                        totalTakenTime = getRemainedTime;
                    } else {
                        //비어있는 심사대가 아닐 경우 심사 처리 시간 + 남아 있는 시간으로 적용
                        totalTakenTime = getTakenTime + getRemainedTime;
                    }

                    if (minTakenTime > totalTakenTime) {
                        //저장되어 있는 최소 소요 시간보다 현재 심사대의 최소 소요시간이 더 짧을 경우, 해당 심사대의 소요시간으로 변경
                        minTakenTime = totalTakenTime;
                    }
                }
                    answer += minTakenTime;
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
