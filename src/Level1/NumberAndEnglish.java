package Level1;

public class NumberAndEnglish {
    static String answer = "";
    public static void main(String[] args) {
        //숫자 문자열과 영단어(2021 카카오 채용연계형 인턴십)
        String s = "one4seveneight";

        answer = s;
        String alphabet = "";

        for (int index = 0; index < s.length(); index++) {
            //숫자일 경우 아래 로직 수행안하고 다음으로 넘어감
            if (s.substring(index, index + 1).matches("[0-9]")) continue;

            alphabet += s.substring(index, index + 1);
            if (checkAlphabet(alphabet, s)) {
                //알파벳을 숫자로 변경 했으므로 해당 문자열 초기화
                alphabet = "";
            }
        }

        System.out.println(Integer.parseInt(answer));
    }

    public static boolean checkAlphabet(String alphabet, String s) {
        switch (alphabet) {
            case "zero" :
                answer = answer.replace(alphabet, "0");
                return true;

            case "one" :
                answer = answer.replace(alphabet, "1");
                return true;

            case "two" :
                answer = answer.replace(alphabet, "2");
                return true;

            case "three" :
                answer = answer.replace(alphabet, "3");
                return true;

            case "four" :
                answer = answer.replace(alphabet, "4");
                return true;

            case "five" :
                answer = answer.replace(alphabet, "5");
                return true;

            case "six" :
                answer = answer.replace(alphabet, "6");
                return true;

            case "seven" :
                answer = answer.replace(alphabet, "7");
                return true;

            case "eight" :
                answer = answer.replace(alphabet, "8");
                return true;

            case "nine" :
                answer = answer.replace(alphabet, "9");
                return true;
        }
        return false;
    }
}
