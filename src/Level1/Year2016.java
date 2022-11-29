package Level1;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Year2016 {
    public static void main(String[] args) {
        /*
            2016년
            문제 설명
            2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
            두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
            요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
            예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

            제한 조건
            2016년은 윤년입니다.
            2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
            입출력     예
            a	b	result
            5	24	"TUE"
         */

        int a = 5;
        int b = 24;

        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);

        int dayNumber = date.getDayOfWeek().getValue(); // 월요일 ~ 일요일 : 1 ~ 7 (숫자로 전달 받음)

        switch (dayNumber) {
            case 1 :
                answer = "MON";
                break;
            case 2 :
                answer ="TUE";
                break;
            case 3 :
                answer ="WED";
                break;
            case 4 :
                answer ="THU";
                break;
            case 5 :
                answer ="FRI";
                break;
            case 6 :
                answer ="SAT";
                break;
            case 7 :
                answer ="SUN";
                break;
        }

        System.out.println(answer);
    }
}
