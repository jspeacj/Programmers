package Level1;

import java.util.*;
import java.util.stream.Collectors;

public class ResultReport {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());
        List<String> reportedList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> MessageSentMap = new HashMap<>();
        String reported = null;
        int[] result = new int[id_list.length];

        for (String str : reportList) {
            reported = str.substring(str.indexOf(" "));
            map.put(reported, map.getOrDefault(reported, 0) + 1);
        }

        System.out.println(map.values());
        for (String key : map.keySet()) {
            //정지당하는 회원
            if (map.get(key) >= k) {
                reportedList.add(key);
            }
        }

        for (String rpter : reportList) {
            for(String rpted : reportedList) {
                String str = rpter.substring(rpter.indexOf(" "));
                if (str.equals(rpted)) { //신고된 사람과 정지당하는 사람이 일치할 경우 신고자한테 메세지 전달해야함
                    String reporter = rpter.substring(0, rpter.indexOf(" "));
                    MessageSentMap.put(reporter, MessageSentMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        System.out.println("MessageSentMap = " + MessageSentMap);
        for (int i = 0; i < id_list.length; i++) {
            result[i] = MessageSentMap.getOrDefault(id_list[i], 0);
        }
    }
}