package Programmers.Level1;

public class NickNameRule {
    public static void main(String[] args) {
        /*
            [PCCE 기출문제] 8번 / 닉네임 규칙

            문제 설명
            온라인 서비스를 이용하기 위해서 닉네임이 필요합니다. 이때 닉네임이 될 수 있는 조건은 다음과 같습니다.

            닉네임의 길이가 4자 이상 8자 이하여야합니다.
            닉네임에는 소문자 l과w, 대문자 O와 W를 사용할 수 없습니다.
            이외의 영어 대소문자와 숫자는 모두 사용이 가능합니다.
            주어진 solution 함수는 사용할 수 없는 닉네임 nickname을 받아 사용할 수 있는 닉네임으로 바꿔주는 함수입니다. 이때 닉네임을 변경하는 규칙은 다음과 같으며 첫 번째 규칙부터 순서대로 적용합니다.

            소문자 l을 대문자 I로 변경합니다.
            소문자 w를 두 개의 소문자 v, 즉 vv로 변경합니다.
            대문자 W를 두 개의 대문자 V, 즉 VV로 변경합니다.
            대문자 O를 숫자 0으로 변경합니다.
            수정된 닉네임의 길이가 4 미만일 경우 뒤에 소문자 o를 길이가 4가 될때까지 이어붙입니다.
            수정된 닉네임의 길이가 8보다 클 경우 8번째 문자까지만 사용합니다.
            주어진 solution 함수에는 위의 규칙 중 올바르게 적용되지 않는 것이 있습니다. solution 함수가 올바르게 작동하도록 한 줄을 수정해주세요.

            제한사항
            1 ≤ nickname의 길이 ≤ 10
            nickname은 영어 대소문자와 숫자로만 이루어져있습니다.
            입출력 예
            nickname	    result
            "WORLDworld"	"VV0RLDvv"
            "GO"	        "G0oo"
            입출력 예 설명
            입출력 예 #1

            닉네임 "WORLDworld"는 1, 2, 3, 4, 6 단계를 거쳐 "VV0RLDvv"가 됩니다.
            "WORLDworld" -> "WORLDworId" -> "WORLDvvorId" -> "VVORLDvvorId" -> "VV0RLDvvorId" -> "VV0RLDvv"
            입출력 예 #2

            닉네임 "GO"는 4, 5 단계를 거쳐 "G0oo"가 됩니다.
            "GO" -> "G0" -> "G0oo"
            cpp를 응시하는 경우 리스트는 배열과 동일한 의미이니 풀이에 참고해주세요.
            ex) 번호가 담긴 정수 리스트 numbers가 주어집니다. => 번호가 담긴 정수 배열 numbers가 주어집니다.
            java를 응시하는 경우 리스트는 배열, 함수는 메소드와 동일한 의미이니 풀이에 참고해주세요.
            ex) solution 함수가 올바르게 작동하도록 한 줄을 수정해 주세요. => solution 메소드가 올바르게 작동하도록 한 줄을 수정해 주세요.
         */

        /* TC 1 result : VV0RLDvv */
        //String nickname = "WORLDworld";

        /* TC 2 result : G0oo */
        String nickname = "GO";

        String answer = "";
        for(int i=0; i<nickname.length(); i++){
            if(nickname.charAt(i) == 'l'){
                answer += "I";
            }
            else if(nickname.charAt(i) == 'w'){
                answer += "vv";
            }
            else if(nickname.charAt(i) == 'W'){
                answer += "VV";
            }
            else if(nickname.charAt(i) == 'O'){
                answer += "0";
            }
            else{
                answer += nickname.charAt(i);
            }
        }
        if(answer.length() < 3){
            // answer += "o"; // 수정 전
            answer = (answer + "ooo").substring(0, 4);
            // answer += "o".repeat(4 - answer.length()); JAVA 11 이상일 경우 repeat 함수를 이용하여 풀이 가능
        }
        if(answer.length() > 8){
            answer = answer.substring(0, 8);
        }

        System.out.println(answer);
    }
}
