package Programmers.Level2;

import java.util.Arrays;

public class PerfectCrime {
    public static int minAEvidence = -1;
    public static int[] evidenceArr = new int[2];
    public static void main(String[] args) {
        /*
            완전 범죄 (2025 프로그래머스 코드챌린지 2차 예선)

            문제 설명
            A도둑과 B도둑이 팀을 이루어 모든 물건을 훔치려고 합니다.
            단, 각 도둑이 물건을 훔칠 때 남기는 흔적이 누적되면 경찰에 붙잡히기 때문에,
            두 도둑 중 누구도 경찰에 붙잡히지 않도록 흔적을 최소화해야 합니다.

            물건을 훔칠 때 조건은 아래와 같습니다.

            물건 i를 훔칠 때,
            A도둑이 훔치면 info[i][0]개의 A에 대한 흔적을 남깁니다.
            B도둑이 훔치면 info[i][1]개의 B에 대한 흔적을 남깁니다.
            각 물건에 대해 A도둑과 B도둑이 남기는 흔적의 개수는 1 이상 3 이하입니다.
            경찰에 붙잡히는 조건은 아래와 같습니다.

            A도둑은 자신이 남긴 흔적의 누적 개수가 n개 이상이면 경찰에 붙잡힙니다.
            B도둑은 자신이 남긴 흔적의 누적 개수가 m개 이상이면 경찰에 붙잡힙니다.
            각 물건을 훔칠 때 생기는 흔적에 대한 정보를 담은 2차원 정수 배열 info,
            A도둑이 경찰에 붙잡히는 최소 흔적 개수를 나타내는 정수 n,
            B도둑이 경찰에 붙잡히는 최소 흔적 개수를 나타내는 정수 m이 매개변수로 주어집니다.
            두 도둑 모두 경찰에 붙잡히지 않도록 모든 물건을 훔쳤을 때,
            A도둑이 남긴 흔적의 누적 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요.
            만약 어떠한 방법으로도 두 도둑 모두 경찰에 붙잡히지 않게 할 수 없다면 -1을 return해 주세요.

            제한사항
            1 ≤ info의 길이 ≤ 40
            info[i]는 물건 i를 훔칠 때 생기는 흔적의 개수를 나타내며, [A에 대한 흔적 개수, B에 대한 흔적 개수]의 형태입니다.
            1 ≤ 흔적 개수 ≤ 3
            1 ≤ n ≤ 120
            1 ≤ m ≤ 120

            테스트 케이스 구성 안내
            아래는 테스트 케이스 구성을 나타냅니다.
            각 그룹 내의 테스트 케이스를 모두 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.

            그룹	총점	테스트 케이스 그룹 설명
            #1	15%	info[i][1] = 1
            #2	40%	info의 길이 ≤ 20
            #3	45%	추가 제한 사항 없음

            입출력 예
                    info	            n	m	result
            [[1, 2], [2, 3], [2, 1]]	4	4	  2
            [[1, 2], [2, 3], [2, 1]]	1	7	  0
            [[3, 3], [3, 3]]	        7	1	  6
            [[3, 3], [3, 3]]	        6	1	  -

            입출력 예 설명
            입출력 예 #1
            첫 번째와 세 번째 물건을 B도둑이 훔치고 두 번째 물건을 A도둑이 훔치면,
            A도둑에 대한 흔적은 총 2개이고 B도둑에 대한 흔적은 총 3개입니다.
            목표를 달성하면서 A도둑에 대한 흔적 개수를 2보다 더 낮게 만들 수 없습니다.
            따라서 2를 return 해야 합니다.

            입출력 예 #2
            B도둑이 모든 물건을 훔쳐도 B의 흔적이 7개 이상 쌓이지 않습니다.
            따라서 A도둑의 흔적은 최소 0이 되며, 0을 return 해야 합니다.

            입출력 예 #3
            B도둑이 한 번이라도 물건을 훔치면 B의 흔적이 최소 1개 이상 남습니다.
            따라서 모든 물건을 A도둑이 훔쳐야 하며, 이 경우에도 A의 흔적은 7개 미만입니다.
            따라서, A도둑이 모든 물건을 훔칠 때의 흔적 개수 6을 return 해야 합니다.

            입출력 예 #4
            어떤 방법으로도 두 도둑 모두 경찰에 붙잡히지 않고 모든 물건을 훔칠 수 없습니다.
            따라서 -1을 return 해야 합니다.
         */

        /* TC  1 result : 2 */
        //int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        //int n = 4;
        //int m = 4;

        /* TC  2 result : 0 */
        //int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        //int n = 1;
        //int m = 7;

        /* TC  3 result : 6 */
        //int[][] info = {{3, 3}, {3, 3}};
        //int n = 7;
        //int m = 1;

        /* TC  4 result : -1 */
        //int[][] info = {{3, 3}, {3, 3}};
        //int n = 6;
        //int m = 1;

        /* TC  5 result : 4 */
        int[][] info = {{1, 3}, {1, 3}, {1, 1}, {1, 1}, {1, 1}, {2, 3}, {2, 3}};
        int n = 6;
        int m = 7;
        
        /*
            풀이 방법 :
            1. 완전 탐색 기법으로 모든 경우의 수를 계산해야한다. (재귀 함수 이용)
            2. 전달받은 인덱스 인풋 파라미터를 기준으로 순차적으로 A부터 훔칠 수 있다면 A가 훔칠 수 있는지 체크한다.
            (A가 훔칠 수 없다면 B가 훔칠 수 있는지 체크하며 만약 둘 다 훔칠 수 없다면 재귀 함수 호출 없이 종료한다.)
            3. A 또는 B가 훔칠 수 있다면 해당 훔친 값의 흔적을 넣으며 재귀 함수를 호출한다. (호출 이후에는 훔친 값의 흔적값을 원상 복구한다.)
            (이때, 인풋 파라미터는 다음 인덱스로 진행할 수 있도록 해야한다.)
            4. 만약 호출 받은 인덱스 값이 info의 길이보다 클 경우(= 모두 훔치기 완료),
            전역 변수 minAEvidence 값보다 작을 경우 해당 값을 세팅한다.
            (만약 minAEvidence 값이 -1인 상태일 경우 최초 세팅이므로 체크 없이 바로 세팅한다.)
            5. 완전 탐색 완료 이후 A의 최소 흔적 값인 minAEvidence 값을 리턴한다.
        */
        
        Arrays.sort(info, (int[] a, int[] b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        //System.out.println(chkSteal(info, n, m));
        System.out.println(Arrays.deepToString(info));

        if (chkPossibleSteal(info, n, m)) bfs(info, n, m, evidenceArr[0], 0, info.length);
        System.out.println(minAEvidence);
    }

    public static int chkSteal(int[][] info, int n, int m) {
        int minA = 0;
        int minB = 0;

        for (int[] arr : info) {
            if (minB + arr[1] < m) minB += arr[1];
            else if (minA + arr[0] < n) minA += arr[0];
            else return -1;
        }

        return minA;
    }

    public static boolean chkPossibleSteal(int[][] info, int n, int m) {
        int sumA = 0, sumB = 0;
        for (int[] arr : info) {
            if (sumB + arr[1] < m) sumB += arr[1];
            else if (sumA + arr[0] < n) sumA += arr[0];
            else return false;
        }

        if (sumA == 0) minAEvidence = sumA;
        return true;
    }

    public static void bfs(int[][] info, int n, int m, int minA, int index, int maxLength) {
        if (minAEvidence != -1 && minAEvidence <= minA) return;
        else if (minAEvidence == 0) return;
        else if (index >= maxLength) {
            if (minAEvidence == -1) minAEvidence = evidenceArr[0];
            else if (minAEvidence > evidenceArr[0]) minAEvidence = evidenceArr[0];
            return;
        }

        if (evidenceArr[1] + info[index][1] < m) {
            evidenceArr[1] += info[index][1];
            bfs(info, n, m, evidenceArr[0], index + 1, maxLength);
            evidenceArr[1] -= info[index][1];
        }
        
        if (evidenceArr[0] + info[index][0] < n) {
            evidenceArr[0] += info[index][0];
            bfs(info, n, m, evidenceArr[0], index + 1, maxLength);
            evidenceArr[0] -= info[index][0];
        }
    }
}
