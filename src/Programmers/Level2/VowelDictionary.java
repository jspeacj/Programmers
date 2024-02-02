package Programmers.Level2;

public class VowelDictionary {
    public static void main(String[] args) {
        /*
            모음 사전
            문제 설명
            사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
            사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

            단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

            제한사항
            word의 길이는 1 이상 5 이하입니다.
            word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.

            입출력 예
             word	result
            "AAAAE"	  6
            "AAAE"	  10
            "I"	     1563
            "EIO"	 1189

            입출력 예 설명
            입출력 예 #1
            사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어입니다.

            입출력 예 #2
            "AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.

            입출력 예 #3
            "I"는 1563번째 단어입니다.

            입출력 예 #4
            "EIO"는 1189번째 단어입니다.
         */

        /*
        * 순서
        * A AA AAA AAAA AAAAA AAAAE AAAAI AAAAO AAAAU
        * AAAIA => A AA AAA AAAA AAAAA AAAAE AAAAI AAAAO AAAAU
        *                   AAAE AAAEA AAAEE AAAEI AAAEO AAAEU
        *                   AAAI AAAIA AAAIE AAAII AAAIO AAAIU
          {0, 0, 0, 0, 0}
          5 : 0 + 1 = 1
          4 : 5 + 1 = 6
          3 : 5 * 5 + 1 = 25 + 1 = 26
          2 : (7 * 5) * 5 + 1 = 35 * 5 + 1 = 155 + 1 = 156
          1 : (8 * 5) * 5 + 1 = 40 * 5 + 1 = 201
          * int[] nums = {781, 156, 31, 6, 1}; // 각 자리수에 대한 단어 개수
          AAAAA = 1
          AAAA = AAAAA * 5 + 1 = 1 * 5 + 1 = 6
          AAA = AAAA * 5 + 1 = 6 * 5 + 1 = 31
          AA = AAA * 5 + 1 = 31 * 5 + 1 = 156
          A = AA * 5 + 1 = 156 * 5 + 1 = 781
        * */

        /* TC 1 result : 6 */
        //String word = "AAAAE";

        /* TC 2 result : 10 */
        //String word = "AAAE";

        /* TC 3 result : 1563 */
        //String word = "I";

        /* TC 4 result : 1189 */
        String word = "EIO";

        /*
            AAAAA = 1
            AAAA = AAAAA * 5 + 1 = 1 * 5 + 1 = 6
            AAA = AAAA * 5 + 1 = 6 * 5 + 1 = 31
            AA = AAA * 5 + 1 = 31 * 5 + 1 = 156
            A = AA * 5 + 1 = 156 * 5 + 1 = 781
        */
        int[] nums = {781, 156, 31, 6, 1}; // 각 자리수에 대한 단어 개수
        int answer = 0;

        for (int index = 0; index < word.length(); index++) {
            int num = "AEIOU".indexOf(word.charAt(index));
            answer += num * nums[index] + 1;
        }

        System.out.println(answer);
    }
}
