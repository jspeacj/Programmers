package Level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws ParseException {
        /*
            해당 파일은 프로그래머스에 제출하기 전, 주석문을 제거하기 위해 만든 파일이다. (제출 전 임시 저장용)
         */
        String scantoFrom = "202209012";

        SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMdd");
        Date date = sdfr.parse(scantoFrom);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, 9);
        System.out.println(cal.getTime());

        String abc = sdfr.format(cal.getTime());
        abc = abc +"235959";
        System.out.println(abc);
    }
}
