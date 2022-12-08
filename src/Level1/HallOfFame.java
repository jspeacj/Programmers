package Level1;

import java.util.*;

public class HallOfFame {
    public static void main(String[] args) {
        /*
            명예의 전당 (1)
            문제 설명
            "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다.
            매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다.
            즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다.
            k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면,
            출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

            이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다.
            예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면,
            명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
            (이미지 생략)
            명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때, 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.

            제한사항
            3 ≤ k ≤ 100
            7 ≤ score의 길이 ≤ 1,000
            0 ≤ score[i] ≤ 2,000

            입출력 예
            k	                score	                                    result
            3	[10, 100, 20, 150, 1, 100, 200]	                [10, 10, 10, 20, 20, 100, 100]
            4	[0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]	[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
            입출력 예 설명
            입출력 예 #1
            문제의 예시와 같습니다.

            입출력 예 #2
            [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]을 return합니다.
            (이미지 생략)
         */

        /* TC 1 */
        /*int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};*/

        /* TC 2 */
        /*int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};*/

        /* TC 3 */
        int k = 5;
        int[] score = {2, 3, 1};

        List<Integer> list = new ArrayList<>();
        int[] result = new int[score.length];

        // k가 score의 길이보다 크거나 같을 경우 해당 값 기준으로만 반복 조건 세팅 후 종료.
        if (k > score.length) {
            for (int i = 0; i < score.length; i++) {
                list.add(score[i]);
                list.sort(Comparator.naturalOrder()); // 오름차순 정렬 (Java 8 이후), 내림차순 : list.sort(Comparator.reverseOrder())
                result[i] = list.get(0); // 오름차순으로 정렬 됐으므로, 첫번째 값은 최소 값이다.
            }
        } else {
            //k번째 까지는 모든 가수의 점수가 명예의 전당에 올라가므로, 해당 값의 최소 값만 result 배열에 저장한다.
            for (int i = 0; i < k; i++) {
                list.add(score[i]);
                list.sort(Comparator.naturalOrder()); // 오름차순 정렬 (Java 8 이후), 내림차순 : list.sort(Comparator.reverseOrder())
                result[i] = list.get(0); // 오름차순으로 정렬 됐으므로, 첫번째 값은 최소 값이다.
            }

            //k번째 이후 검토. 저장된 list의 첫번째 값(최소 값)보다 클 경우, 해당 첫번째 값을 제거하고 해당 값을 넣는다.
            for (int j = k; j < score.length; j++) {
                int min = list.get(0);
                if (min < score[j]) {
                    list.remove(0); // 최소값보다 큰 값이 나왔으므로 해당 최소 값은 삭제
                    list.add(score[j]); // 새로운 값을 명예의 전당에 추가한다.
                    list.sort(Comparator.naturalOrder()); // 오름차순 정렬 (Java 8 이후), 내림차순 : list.sort(Comparator.reverseOrder())
                    result[j] = list.get(0);
                } else {
                    result[j] = list.get(0);
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
