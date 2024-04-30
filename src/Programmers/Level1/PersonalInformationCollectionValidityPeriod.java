package Programmers.Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class PersonalInformationCollectionValidityPeriod {
    public static void main(String[] args) {
        /*
            개인정보 수집 유효기간 (2023 KAKAO BLIND RECRUITMENT)

            문제 설명
            고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다.
            약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
            당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다.
            수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.

            예를 들어, A라는 약관의 유효기간이 12 달이고,
            2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면
            해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
            당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
            모든 달은 28일까지 있다고 가정합니다.
            다음은 오늘 날짜가 2022.05.19일 때의 예시입니다.

            약관 종류	유효기간
                A	      6 달
                B	      12 달
                C	      3 달

            번호	개인정보 수집 일자	 약관 종류
             1	   2021.05.02	    A
             2	   2021.07.01	    B
             3	   2022.02.19	    C
             4	   2022.02.20	    C

            첫 번째 개인정보는 A약관에 의해 2021년 11월 1일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
            두 번째 개인정보는 B약관에 의해 2022년 6월 28일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
            세 번째 개인정보는 C약관에 의해 2022년 5월 18일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
            네 번째 개인정보는 C약관에 의해 2022년 5월 19일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.

            따라서 파기해야 할 개인정보 번호는 [1, 3]입니다.
            오늘 날짜를 의미하는 문자열 today,
            약관의 유효기간을 담은 1차원 문자열 배열 terms와 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가 매개변수로 주어집니다.
            이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            today는 "YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.
            1 ≤ terms의 길이 ≤ 20
            terms의 원소는 "약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열입니다.
            약관 종류는 A~Z중 알파벳 대문자 하나이며, terms 배열에서 약관 종류는 중복되지 않습니다.
            유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하입니다.

            1 ≤ privacies의 길이 ≤ 100
            privacies[i]는 i+1번 개인정보의 수집 일자와 약관 종류를 나타냅니다.
            privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열입니다.
            날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어집니다.
            privacies의 약관 종류는 항상 terms에 나타난 약관 종류만 주어집니다.
            today와 privacies에 등장하는 날짜의 YYYY는 연도, MM은 월, DD는 일을 나타내며 점(.) 하나로 구분되어 있습니다.

            2000 ≤ YYYY ≤ 2022
            1 ≤ MM ≤ 12
            MM이 한 자릿수인 경우 앞에 0이 붙습니다.
            1 ≤ DD ≤ 28
            DD가 한 자릿수인 경우 앞에 0이 붙습니다.
            파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어집니다.

            입출력 예
                today	            terms	                                    privacies	                                                result
            "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	                    [1, 3]
            "2020.01.01"	["Z 3", "D 5"]	        ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	    [1, 4, 5]

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            약관 종류	유효기간
                Z	      3 달
                D	      5 달

            번호	개인정보 수집 일자	약관 종류
             1	    2019.01.01  	D
             2	    2019.11.15  	Z
             3	    2019.08.02  	D
             4	    2019.07.01  	D
             5	    2018.12.28  	Z

            오늘 날짜는 2020년 1월 1일입니다.

            첫 번째 개인정보는 D약관에 의해 2019년 5월 28일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
            두 번째 개인정보는 Z약관에 의해 2020년 2월 14일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
            세 번째 개인정보는 D약관에 의해 2020년 1월 1일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
            네 번째 개인정보는 D약관에 의해 2019년 11월 28일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
            다섯 번째 개인정보는 Z약관에 의해 2019년 3월 27일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
         */

        /* TC 1 result :  [1, 3]*/
        //String today = "2022.05.19";
        //String[] terms = {"A 6", "B 12", "C 3"};
        //String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        /* TC 2 result : [1, 4, 5] */
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        /* 중요 규칙 및 풀이 방법
            1. 주어진 문자 배열 terms는 "월" 기준으로 주어지기 떄문에 주어진 privacies에다가 해당 유효기간(월)을 더하면 된다.
            2. 모든 요일은 28일까지만 존재한다고 가정한다.
            3. 유효기간이 12보다 크거나 같을 경우 년도를 그만큼 더한다. (계산을 진행해서 "일"부터 진행한다.)
            4. 문제 예시에서 주어다시피, 보관 가능 기간에서 "일" 기준은 "개인정보 수집일자의 '일'" - 1을 기준이다.
            (뺸 값이 1보다 작을 경우 이전 달로 이동해야 하므로 28일로 세팅하며  "월"을 계산할 때 1을 추가로 뺴준다.)

            위 내용을 토대로 다음과 같이 문제를 풀이한다.
            1. 주어진 문자열 배열 "terms"의 각 약관 종류 및 유효기간을 map에다가 할당
            2. 보관일자 중, "day" 계산 : "개인정보 수집일자의 day" - 1
            (뺸 값이 1보다 작을 경우 이전 달로 이동해야 하므로 day : 28,  month + 1 추가)
            3. 보관일자 중, "month" 계산 : "개인정보 수집일자의 month" + (유효기간 % 12)
            (12보다 클 경우 다음년도로 이동해야 하므로 "month" : (계산값 % 12), "year" + 1 추가
            4. 보관일자 중, "year" 계산 : "개인정보 수집일자의 year" + (유효기간 / 12)
        */

        List<Integer> expList = new ArrayList<>();
        Map<String, Integer> type = new HashMap<>();
        String[] todayDate = today.split("[.]");

        for (String str : terms ) {
            String[] arr = str.split(" ");
            type.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            String[] date = arr[0].split("[.]");
            addDate(date, type.get(arr[1]));
            if (checkValidity(todayDate, date)) expList.add(i + 1);
        }

        int[] answer = new int[expList.size()];
        for (int index = 0; index < expList.size(); index++) answer[index] = expList.get(index);
        System.out.println(Arrays.toString(answer));
    }

    public static void addDate(String[] date, int expDate) {
        int year =  Integer.parseInt(date[0]);
        int month =  Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        if (day == 1) {
            day = 28;
            month--;
        } else {
            day--;
        }

        if (month + (expDate % 12) > 12) {
            month = month + (expDate % 12) - 12;
            year++;
        } else {
            month = month + (expDate % 12);
        }

        year += expDate / 12;

        date[0] = String.valueOf(year);
        date[1] = String.valueOf(month);
        date[2] = String.valueOf(day);
    }

    public static boolean checkValidity(String[] todayDate, String[] date) {
        /*
        파기대상을 찾아야하므로 파기안되는 대상만 골라서 false로 체크
        파기안되는대상 : 지정된 년도가 오늘 년도보다 크거나 같아야하며,
         */
        int todayYear = Integer.parseInt(todayDate[0]);
        int todayMonth = Integer.parseInt(todayDate[1]);
        int todayDay = Integer.parseInt(todayDate[2]);

        if (Integer.parseInt(date[0]) >= todayYear) {
            if (Integer.parseInt(date[1]) >= todayMonth) {
                if (Integer.parseInt(date[2]) >= todayDay) {
                    return false;
                }
            }
        }

        return true;
    }
}
