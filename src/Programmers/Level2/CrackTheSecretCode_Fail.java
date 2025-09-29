package Programmers.Level2;

import java.util.*;

public class CrackTheSecretCode_Fail {
    public static Set<String> secretCodeList = new HashSet<>();
    public static boolean[][] visited;
    public static Map<Integer, Boolean> secretCodeMap = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();
    public static int test = 10;
    public static void main(String[] args) {
        /*  비밀 코드 해독 (2025 프로그래머스 코드챌린지 1차 예선) (직접 풀이 실패 버전)
            문제 설명
            당신은 비밀 조직의 보안 시스템을 뚫고 중요한 정보를 해독해야 합니다.
            시스템은 1부터 n까지의 서로 다른 정수 5개가 오름차순으로 정렬된 비밀 코드를 가지고 있으며,
            당신은 이 비밀 코드를 맞혀야 합니다.

            당신은 비밀 코드를 알아내기 위해 암호 분석 도구를 사용하며, m번의 시도를 할 수 있습니다.
            각 시도마다 서로 다른 5개의 정수를 입력하면, 시스템은 그 중 몇 개가 비밀 코드에 포함되어 있는지 알려줍니다.

            만약 비밀 코드가 [3, 5, 7, 9, 10]이고, 입력한 정수가 [1, 2, 3, 4, 5]라면
            비밀 코드에 포함된 정수는 3, 5 두 개이므로 시스템은 2를 응답합니다.
            당신은 m번의 시도 후, 비밀 코드로 가능한 정수 조합의 개수를 알고 싶습니다.

            비밀 코드에 사용된 정수의 범위가 1~10일 때,
            아래와 같이 5번의 시도를 했다고 가정해 보겠습니다.

            입력한 정수	            시스템 응답(일치하는 개수)
            [1, 2, 3, 4, 5]	                2개
            [6, 7, 8, 9, 10]	            3개
            [3, 7, 8, 9, 10]	            4개
            [2, 5, 7, 9, 10]	            3개
            [3, 4, 5, 6, 7]	                3개
            비밀 코드로 가능한 정수 조합은 아래와 같이 3개가 있습니다.

            [3, 4, 7, 9, 10]
            첫 번째 시도에서 비밀 코드에 포함된 정수가 3, 4로 2개 있습니다.
            두 번째 시도에서 비밀 코드에 포함된 정수가 7, 9, 10으로 3개 있습니다.
            세 번째 시도에서 비밀 코드에 포함된 정수가 3, 7, 9, 10으로 4개 있습니다.
            네 번째 시도에서 비밀 코드에 포함된 정수가 7, 9, 10으로 3개 있습니다.
            다섯 번째 시도에서 비밀 코드에 포함된 정수가 3, 4, 7로 3개 있습니다.

            [3, 5, 7, 8, 9]
            첫 번째 시도에서 비밀 코드에 포함된 정수가 3, 5로 2개 있습니다.
            두 번째 시도에서 비밀 코드에 포함된 정수가 7, 8, 9로 3개 있습니다.
            세 번째 시도에서 비밀 코드에 포함된 정수가 3, 7, 8, 9로 4개 있습니다.
            네 번째 시도에서 비밀 코드에 포함된 정수가 5, 7, 9로 3개 있습니다.
            다섯 번째 시도에서 비밀 코드에 포함된 정수가 3, 5, 7로 3개 있습니다.

            [3, 5, 7, 8, 10]
            첫 번째 시도에서 비밀 코드에 포함된 정수가 3, 5로 2개 있습니다.
            두 번째 시도에서 비밀 코드에 포함된 정수가 7, 8, 10으로 3개 있습니다.
            세 번째 시도에서 비밀 코드에 포함된 정수가 3, 7, 8, 10으로 4개 있습니다.
            네 번째 시도에서 비밀 코드에 포함된 정수가 5, 7, 10으로 3개 있습니다.
            다섯 번째 시도에서 비밀 코드에 포함된 정수가 3, 5, 7로 3개 있습니다.
            정수 n, 입력한 정수를 담은 2차원 정수 배열 q와 시스템 응답을 담은 1차원 정수 배열 ans가 매개변수로 주어집니다. 이때, 비밀 코드로 가능한 정수 조합 개수를 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            10 ≤ n ≤ 30

            1 ≤ (q의 길이 = m) ≤ 10
            q[i]의 길이 = 5
            q[i]는 i+1번째 시도에서 입력한 5개의 서로 다른 정수를 담고 있으며, 오름차순으로 정렬되어 있습니다.

            1 ≤ q[i][j] ≤ n
            ans의 길이 = m
            ans[i]는 i+1번째 시도에서 입력한 5개의 정수 중 비밀 코드에 포함된 정수의 개수를 나타냅니다.

            0 ≤ ans[i] ≤ 5
            비밀 코드가 존재하지 않는(답이 0인) 경우는 주어지지 않습니다.
            테스트 케이스 구성 안내
            아래는 테스트 케이스 구성을 나타냅니다. 각 그룹 내의 테스트 케이스를 모두 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.

            그룹	총점	추가 제한 사항
            #1	20%	 m = 1
            #2	80%	 추가 제한 사항 없음
            입출력 예
            n	                                            q	                                                    ans	            result
            10	[[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [3, 7, 8, 9, 10], [2, 5, 7, 9, 10], [3, 4, 5, 6, 7]]	      [2, 3, 4, 3, 3]	  3
            15	[[2, 3, 9, 12, 13], [1, 4, 6, 7, 9], [1, 2, 8, 10, 12], [6, 7, 11, 13, 15], [1, 4, 10, 11, 14]]	  [2, 1, 3, 0, 1]	  5

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            비밀 코드로 가능한 정수 조합은 아래와 같이 5개가 있습니다.
            [1, 2, 3, 5, 8]
            [1, 3, 5, 8, 12]
            [2, 4, 5, 8, 12]
            [2, 5, 8, 9, 10]
            [5, 8, 9, 10, 12]
            따라서 5를 return 해야 합니다.
         */

        /* TC 1 result : 3 */
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};

        /* TC 2 result : 5 */
        //int n = 15;
        //int[][] q = {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}};
        //int[] ans = {2, 1, 3, 0, 1};

        /*
            완전 탐색 기법을 이용하여 모든 경우의 수를 찾아야 한다.
            단. 반복문은 q 배열 길이만큼만 반복한다. (순서는 필요없기 떄문에 순차적으로 한번씩만 반복문 수행)

            선언 :
            1. q와 동일한 크기의 boolean 타입 배열 visited 선언
            2.

            알고리즘
            1. q 배열 길이만큼 반복문 수행
            2.

            각 일차원 배열마다 시스템 응답개수에 맞는 모든 경우의 수를 각각 구한 뒤, 중복되지 않는 값으로 서로 조합한다?

        */

        visited = new boolean[q.length][5];
        for (int i = 0; i < q.length; i++) {
            reset();
            if (i == q.length-1) {
                if (ans[i] == 5) { // 배열 마지막 인덱스 입력 답에 대한 시스템 응답이 5개로 모두 응답값일 경우 리스트에 포함시킨다.
                    for (int num : q[i]) secretCodeMap.put(num, true);
                    addSecretCodeList();
                }
            } else {
                findSecretCode(q, ans, i, 0);
            }
        }

        System.out.println(secretCodeList.size());
    }

    public static void reset() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        secretCodeMap.clear();
    }

    //int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
    //int[] ans = {2, 3, 4, 3, 3};
    /*
        [3, 4, 7, 9, 10]
        [3, 5, 7, 8, 9]
        [3, 5, 7, 8, 10]
     */
    public static void findSecretCode(int[][] q, int[] ans, int index, int cnt) {
        boolean flag = false;
        boolean finish = false;
        for (int i = index; i < q.length; i++) {
            if (finish) break;
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) continue;
                test++;
                if (!secretCodeMap.getOrDefault(q[i][j],false)) { // 해당하는 값이 아직 조합코드에 없을 경우 추가
                    secretCodeMap.put(q[i][j], true);
                    cnt++;
                    flag = true;

                    if (secretCodeMap.size() == 5) {
                        if (test < 50) {
                            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                            System.out.println("^^^ 조합 세팅 : " + secretCodeMap);
                            System.out.println();
                        }
                        if (chkSecretCode(q, ans)) {
                            addSecretCodeList();
                            System.out.println("★★★조합코드 성공!★★★" + secretCodeList);
                        }
                        finish = true;
                        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                        break;
                    }
                }


                visited[i][j] = true;

                if (cnt == ans[i]) { // 시스템 응답의 개수와 일치하므로 개수 초기화 후, 다음 인덱스로 이동
                    if (test < 50) {
                        //System.out.println("!!!visitied!!"  + Arrays.deepToString(visited));
                        System.out.println("i : " + i + " , j : " + j);
                        System.out.println("index : " + index + "  cnt : " + cnt + " 현재 인덱스 시스템 응답 : " + ans[i] + "   조합 : " + secretCodeMap);
                        System.out.println("@@@다음 인덱스 재귀함수 호출");
                    }
                    findSecretCode(q, ans,index+1, 0);
                } else { //시스템 응답 개수가 모자르므로 현재 인덱스에서 재귀함수 호출
                    if (test < 50) {
                        //System.out.println("!!!visitied!!"  + Arrays.deepToString(visited));
                        System.out.println("i : " + i + " , j : " + j);
                        System.out.println("index : " + index + "  cnt : " + cnt + " 현재 인덱스 시스템 응답 : " + ans[i] + "   조합 : " + secretCodeMap);
                        System.out.println("### 현재 인덱스 재귀함수 호출");
                    }
                    findSecretCode(q, ans, index,  cnt);
                }

                visited[i][j] = false;
                if (flag) {
                    flag = false;
                    secretCodeMap.remove(q[i][j]);
                    cnt--;
                }

                if (test < 50) {
                    //System.out.println("!!!visitied!!"  + Arrays.deepToString(visited));
                    System.out.println("!!");
                    System.out.println("i : " + i + " , j : " + j);
                    System.out.println("종료 : index : " + index + "  cnt : " + cnt + " 현재 인덱스 시스템 응답 : " + ans[i] + "   조합 : " + secretCodeMap);
                }

            }
        }
    }

    public static void addSecretCodeList() {
        sb.setLength(0); // 초기화
        Integer[] nums = secretCodeMap.keySet().stream().sorted().toArray(Integer[]::new);
        for (Integer num : nums) sb.append(num+",");
        sb.deleteCharAt(sb.length()-1);
        secretCodeList.add(sb.toString());

    }

    public static boolean chkSecretCode(int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (secretCodeMap.getOrDefault(q[i][j], false)) cnt++;
            }
            if (cnt != ans[i]) return false; // 시스템에서 전달한 힌트 개수가 다를 경우 암호 코드가 아니다.
        }

        return true;
    }
}
