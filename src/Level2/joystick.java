package Level2;

public class joystick {
    private static int MIDDLE = 78; // N
    private static int answer = Integer.MAX_VALUE;
    private static char[] nameChar;
    private static char[] answerChar;
    private static boolean[] visited;
    public static void main(String[] args) {
        /*
            조이스틱

            문제 설명

            조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
            ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

            조이스틱을 각 방향으로 움직이면 아래와 같습니다.

            ▲ - 다음 알파벳
            ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
            ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
            ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
            예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

            - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
            - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
            - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
            따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
            만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

            제한 사항
            name은 알파벳 대문자로만 이루어져 있습니다.
            name의 길이는 1 이상 20 이하입니다.

            입출력 예
              name	   return
            "JEROEN"	56
            "JAN"	    23

            출처
            ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
            ※ 공지 - 2022년 1월 14일 지문 수정 및 테스트케이스가 추가되었습니다. 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.
         */

        /*
          ※ 문제 핵심 파악하기
            1. 주의해야하는 경우의 수 :
             =>한쪽방향으로만 가는 것이 아닌 중간에 반대편으로 가는게 더 빠를 경우
            (ex. EFAAAAAAZ : 오른쪽방향으로 한칸이동한뒤 왼쪽으로 이동해서 끝자락으로 이동한다.)
            => 구현하는 방법 : 반대방향으로 이동하는 경우 다시 원래방향으로 돌아가는 경우를 방지하기 위하여,
               boolean타입 flag를 선언하여 true일 경우 해당 방향으로만 이동하도록 구현한다. (무한루프 방지)

        * */
        /* TC 1 return : 56 */
        String name = "JEROEN";

        /* TC 2 return : 23 */
        //String name = "JAN";
        //EROENJEROEN

        nameChar = name.toCharArray();;
        answerChar = new char[nameChar.length];
        visited = new boolean[nameChar.length];

        dfs(name, 0, false, 0);
        System.out.println(answer);
    }

    public static void dfs(String name, int cnt, boolean flag, int reverseIndex) {
        if (flag) {
            for (int i = reverseIndex; i >= 0; i--) {
                if (visited[i]) {
                    cnt++;
                    continue;
                }

                visited[i] = true;
                cnt++;
                dfs(name, cnt, true, --reverseIndex);
                cnt--;
                visited[i] = false;
            }
        } else {
            for (int i = 0; i < nameChar.length; i++) {
                if (visited[i]) {
                    cnt++;
                    continue;
                }

                visited[i] = true;
                cnt++;
                reverseIndex = i - 1 < 0 ?
                dfs(name, cnt, true, reverseIndex);
                dfs(name, cnt, false, reverseIndex);
                cnt--;
                visited[i] = false;

            }
        }

    }

    /*
                 A B C D
                 E F G H
                 I J K L
                 M N O P
                 Q R S T
                 U V W X
                 Y Z
                * */

    private static int selectName(char c) {
        int cnt = 0;
            if ((int)c > MIDDLE) {
                cnt += (int)'Z' - (int)c + 1;
            } else {
                cnt += (int)c - (int)'A';
            }

        return cnt;
    }
}
