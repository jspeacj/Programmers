package Level2;

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
AUUUU
B
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
        *                   AAAI AAAIA AAAIE AAAII AAAIO AAAAIU
        * */

        /* TC 1 result : 6 */
        String word = "AAAAE";

        /* TC 2 result : 10 */
        //String word = "AAAE";

        /* TC 3 result : 1563 */
        //String word = "I";

        /* TC 4 result : 1189 */
        //String word = "EIO";

        /*
        재귀함수 이용하여 문제 풀이하기! 끝에서부터 문자하나의 switch문을 적용해서 시도..??
        (시도한 문자는 제거하고, 재귀함수로 재호출하는 방식으로 문제 풀이해보기!)
         */
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        System.out.println(sb);
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
        System.out.println(dictionary(sb));
    }

    public static int dictionary (StringBuilder word){
        int answer = 0;
            int length = 5 - word.length();
            String lastWord = word.substring(word.length()-1);
            if (length > 0) {
                switch (lastWord) {
                    case "A":
                        answer += 0 * Math.pow(5, length);
                        break;

                    case "E":
                        answer += 1 * Math.pow(5, length);
                        break;

                    case "I":
                        answer += 2 * Math.pow(5, length);
                        break;

                    case "O":
                        answer += 3 * Math.pow(5, length);
                        break;

                    case "U":
                        answer += 4 * Math.pow(5, length);
                        break;
                }
            }

            if (word.length() > 1) {
                word.delete(word.length()-1, word.length());
                System.out.println(word);
                answer += dictionary(word);
                System.out.println("추가 : " + answer);
            }
        return answer;
    }
}
