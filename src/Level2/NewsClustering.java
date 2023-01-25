package Level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewsClustering {
    public static void main(String[] args) {
        /*
            [1차] 뉴스 클러스터링
            문제 설명
            뉴스 클러스터링
            여러 언론사에서 쏟아지는 뉴스, 특히 속보성 뉴스를 보면 비슷비슷한 제목의 기사가 많아 정작 필요한 기사를 찾기가 어렵다.
            Daum 뉴스의 개발 업무를 맡게 된 신입사원 튜브는 사용자들이 편리하게 다양한 뉴스를 찾아볼 수 있도록 문제점을 개선하는 업무를 맡게 되었다.

            개발의 방향을 잡기 위해 튜브는 우선 최근 화제가 되고 있는 "카카오 신입 개발자 공채" 관련 기사를 검색해보았다.

            카카오 첫 공채..'블라인드' 방식 채용
            카카오, 합병 후 첫 공채.. 블라인드 전형으로 개발자 채용
            카카오, 블라인드 전형으로 신입 개발자 공채
            카카오 공채, 신입 개발자 코딩 능력만 본다
            카카오, 신입 공채.. "코딩 실력만 본다"
            카카오 "코딩 능력만으로 2018 신입 개발자 뽑는다"
            기사의 제목을 기준으로 "블라인드 전형"에 주목하는 기사와 "코딩 테스트"에 주목하는 기사로 나뉘는 걸 발견했다.
            튜브는 이들을 각각 묶어서 보여주면 카카오 공채 관련 기사를 찾아보는 사용자에게 유용할 듯싶었다.

            유사한 기사를 묶는 기준을 정하기 위해서 논문과 자료를 조사하던 튜브는 "자카드 유사도"라는 방법을 찾아냈다.

            자카드 유사도는 집합 간의 유사도를 검사하는 여러 방법 중의 하나로 알려져 있다.
            두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.

            예를 들어 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때, 교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}이 되므로,
            집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다. 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.

            자카드 유사도는 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다. 다중집합 A는 원소 "1"을 3개 가지고 있고,
            다중집합 B는 원소 "1"을 5개 가지고 있다고 하자. 이 다중집합의 교집합 A ∩ B는 원소 "1"을 min(3, 5)인 3개, 합집합 A ∪ B는 원소 "1"을 max(3, 5)인 5개 가지게 된다.
            다중집합 A = {1, 1, 2, 2, 3}, 다중집합 B = {1, 2, 2, 4, 5}라고 하면, 교집합 A ∩ B = {1, 2, 2}, 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}가 되므로, 자카드 유사도 J(A, B) = 3/7, 약 0.42가 된다.

            이를 이용하여 문자열 사이의 유사도를 계산하는데 이용할 수 있다. 문자열 "FRANCE"와 "FRENCH"가 주어졌을 때, 이를 두 글자씩 끊어서 다중집합을 만들 수 있다.
            각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}가 되며, 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로,
            두 문자열 사이의 자카드 유사도 J("FRANCE", "FRENCH") = 2/8 = 0.25가 된다.

            입력 형식
            입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
            입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
            예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
            다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.

            출력 형식
            입력으로 들어온 두 문자열의 자카드 유사도를 출력한다. 유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.

            예제 입출력
             str1	        str2	    answer
            FRANCE	       french	    16384
            handshake	  shake hands	65536
            aa1+aa2	        AAAA12	    43690
            E=M*C^2	        e=m*c^2	    65536
         */

        /*
            ※ 문제 이해 및 풀기
        * 1.입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
        * 2.영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
            (예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.)
          3. A ∪ B = (A + B) - A ∩ B
          4. 즉, 교집합(A ∩ B)을 구하면 합집합의 개수또한 구할 수 있다.
          5. 마지막에 전달할 값 answer에다가 65536을 곱한다.
          6. 곱한 값의 소수점아래는 버리고 반환한다.
          7. ★ 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다. ★
        * */

        /* TC 1 return : 16384 */
        //String str1 = "FRANCE";
        //String str2 = "french";

        /* TC 2 return : 65536 */
        //String str1 = "handshake";
        //String str2 = "shake hands";

        /* TC 3 return : 43690 */
        //String str1 = "aa1+aa2";
        //String str2 = "AAAA12";

        /* TC 4 return : 65536 */
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        /* TC 5 return : 0 */
        //String str1 = "A+C";
        //String str2 = "DEF";

        int emptyValue = 65536;
        if (str1.trim().length() == 0 || str2.trim().length() == 0) System.out.println(emptyValue);

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        int intersection = 0; // 교집합
        int union = 0; // 합집합

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if ((int)c1 < 97 || (int)c1 > 122) continue;
            if ((int)c2 < 97 || (int)c2 > 122) continue;

            str1List.add(str1.substring(i, i+2));
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if ((int)c1 < 97 || (int)c1 > 122) continue;
            if ((int)c2 < 97 || (int)c2 > 122) continue;

            str2List.add(str2.substring(i, i+2));
        }

        if (str1List.size() == 0 && str2List.size() == 0) System.out.println(emptyValue);

        union = str1List.size() + str2List.size();
        str1List.sort(Comparator.reverseOrder());
        str2List.sort(Comparator.reverseOrder());

        for (String s1 : str1List) {
            char c1 = s1.charAt(0);

            for (String s2 : str2List) {
                char c2 = s2.charAt(0);
                if ((int)c2 > (int)c1) continue;
                else if ((int)c2 < (int)c1) break;
                else { // 첫번째 영문자가 같은 경우에만 수행
                    if (s1.charAt(1) == s2.charAt(1)) {
                        str2List.remove(s2);
                        intersection++; // 교집합 증가
                        break;
                    }
                }
            }
        }

        int answer = (int)((double)intersection / (union - intersection) * 65536);

        System.out.println(answer);
    }
}
