package Level2;

import java.util.Arrays;
public class joystick {
    private static char MIDDLE_ALPHABET = 'N';
    private static String finalName;
    private static int answer = Integer.MAX_VALUE;
    private static StringBuilder sb = new StringBuilder();
    private static char[] lMoveChar;
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
            알고리즘 풀이 :
             1. 오른쪽으로 커서를 이동한다.
             2. 이동한 자리의 문자를 주어진 문자에 맞게 맞춘다.
             3. 해당 위치를 기준으로 왼쪽으로 커서를 계속 이동해서 주어진 name에 맞을떄까지 커서를 이동하며 이름을 바꾼다.
             4. 1번 케이스를 통해 name과 동일해질떄까지 1 ~ 3번 케이스를 반복한다.

        * */
        /* TC 1 return : 56 */
        //String name = "JEROEN";

        /* TC 2 return : 23 */
        //String name = "JAN";

        /* TC 3 return : 11 */
        //String name = "JAZ";

        /* TC 4 return :  10 */
        //String name = "ABABAAAAABA";

        /* TC 5 return : 12 */
        String name = "BBBBAAAABA";
        /*
                 A B C D
                 E F G H
                 I J K L
                 M N O P
                 Q R S T
                 U V W X
                 Y Z 11 +
        */

        finalName = name;
        char[] nickName = new char[finalName.length()];
        char[] nameChar = name.toCharArray();
        lMoveChar = new char[name.length()];

        Arrays.fill(nickName, 'A');
        leftDfs(nameChar, nickName, 0, 0);
        Arrays.fill(nickName, 'A');
        rightDfs(nameChar, nickName, 0, 0);
        System.out.println(answer);
    }

    public static void leftDfs(char[] nameChar, char[] nickName, int index, int cnt) {
        if (index < 0) index = nameChar.length - 1;

        if ((int)nameChar[index] < (int)MIDDLE_ALPHABET) {
            cnt += (int)nameChar[index] - (int)'A';
        } else {
            cnt += (int)'Z' - (int)nameChar[index] + 1;
        }
        nickName[index] = nameChar[index];

        if (checkName(nickName)) {
            if (answer > cnt) answer = cnt;
            return;
        } else {
            rightMove(nameChar, nickName, index, cnt);
            leftDfs(nameChar, nickName, index - 1, ++cnt);
        }
    }

    public static void rightDfs(char[] nameChar, char[] nickName, int index, int cnt) {
        if ((int)nameChar[index] < (int)MIDDLE_ALPHABET) {
            cnt += (int)nameChar[index] - (int)'A';
        } else {
            cnt += (int)'Z' - (int)nameChar[index] + 1;
        }
        nickName[index] = nameChar[index];

        if (checkName(nickName)) {
            if (answer > cnt) answer = cnt;
            return;
        } else {
            leftMove(nameChar, nickName, index, cnt);
            rightDfs(nameChar, nickName, index + 1, ++cnt);
        }
    }

    public static boolean checkName(char[] nickName) {
        sb.setLength(0);
        for(char c : nickName) sb.append(c);

        return finalName.equals(sb.toString());
    }

    public static void leftMove(char[] nameChar, char[] nickName, int startIndex, int cnt) {
        for (int i = 0; i < nickName.length; i++) lMoveChar[i] = nickName[i];
        while (true) {
            cnt++;
            startIndex = startIndex > 0 ? --startIndex : (nameChar.length - 1);

            if (lMoveChar[startIndex] != nameChar[startIndex]) {
                if ((int) nameChar[startIndex] < (int) MIDDLE_ALPHABET) {
                    cnt += (int) nameChar[startIndex] - (int) 'A';
                } else {
                    cnt += (int) 'Z' - (int) nameChar[startIndex] + 1;
                }

                lMoveChar[startIndex] = nameChar[startIndex];
            }

            if(checkName(lMoveChar)) {
                if (answer > cnt) answer = cnt;
                break;
            }
        }
    }

    public static void rightMove(char[] nameChar, char[] nickName, int startIndex, int cnt) {
        for (int i = 0; i < nickName.length; i++) lMoveChar[i] = nickName[i];
        while (true) {
            cnt++;
            startIndex = startIndex < (nameChar.length - 1) ? ++startIndex : 0;

            if (lMoveChar[startIndex] != nameChar[startIndex]) {
                if ((int) nameChar[startIndex] < (int) MIDDLE_ALPHABET) {
                    cnt += (int) nameChar[startIndex] - (int) 'A';
                } else {
                    cnt += (int) 'Z' - (int) nameChar[startIndex] + 1;
                }

                lMoveChar[startIndex] = nameChar[startIndex];
            }

            if(checkName(lMoveChar)) {
                if (answer > cnt) answer = cnt;
                break;
            }
        }
    }
}
