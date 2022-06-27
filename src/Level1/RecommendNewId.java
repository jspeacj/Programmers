package Level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendNewId {
    public static void main(String[] args) {
        //신규 아이디 추천
        //테스트 케이스 Input
        String new_id = "z-+.^.";
        String answer = "";

        //대문자를 소문자로 치환 및 알파벳 소문자 또는 숫자 또는 뺴기(-), 밑줄(_), 마침표(.)를 제외한 문자는 필터 처리
        String splitNewId = Arrays.stream(new_id.toLowerCase().split(""))
                .filter(p -> {
                    return Character.isLowerCase(p.charAt(0)) || Character.isDigit(p.charAt(0)) || "-".equals(p) || "_".equals(p) || ".".equals(p);
                }).collect(Collectors.joining());

        while(splitNewId.indexOf("..") > -1) {
            //마침표가 2번이상 연속됐을 경우 하나의 마침표로 치환(존재하지 않을 때까지 반복)
            splitNewId = splitNewId.replace("..", ".");
        }

        List<String> newIdList = Arrays.stream(splitNewId.split(""))
                .collect(Collectors.toList());

        //newIdList가 비어있을 경우 "a"를 대입한다.
        if (newIdList.size() == 0) newIdList.add("a");

        //마침표가 처음이나 끝에 위치한다면 제거
        if (".".equals(newIdList.get(0))) newIdList.remove(0);

        //newIdList가 비어있을 경우 "a"를 대입한다.
        if (newIdList.size() == 0) newIdList.add("a");

        if (".".equals(newIdList.get(newIdList.size() - 1))) newIdList.remove(newIdList.size() -1 );

        //문자열 길이가 16자 이상일 경우, 15자리까지만 냅두고 나머지는 제거한다. 제거했을 때 끝자리가 마침표(.)일 경우, 해당 문자도 제거한다.
        if (newIdList.size() > 15) {
            for (int j = newIdList.size() - 1; j >= 15; j--) {
                newIdList.remove(j);

                //15자리이후 문자 전부 삭제 후, 마지막 끝자리가 마침표(.)일 경우
                if (j == 15 && ".".equals(newIdList.get(14))) {
                    newIdList.remove(14);
                }
            }
        }

        //new_id의 길이가 2자리 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        if (newIdList.size() <= 2) {
            for (int index = newIdList.size(); index < 3; index++) {
                newIdList.add(index, newIdList.get(index-1));
            }
        }

        for (String k : newIdList) {
            answer += k;
        }

        System.out.println("answer = " + answer);
    }
}
