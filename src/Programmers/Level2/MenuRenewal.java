package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MenuRenewal {
    public static void main(String[] args) {
        /*
            메뉴 리뉴얼

            문제 설명
            레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
            기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다.
            어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
            단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다.
            또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

            예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
            (각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)

            손님 번호	주문한 단품메뉴 조합
            1번 손님	         A, B, C, F, G
            2번 손님	         A, C
            3번 손님	         C, D, E
            4번 손님	         A, C, D, E
            5번 손님	         B, C, F, G
            6번 손님	         A, C, D, E, H
            가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

            코스 종류	   메뉴 구성	                           설명
            요리 2개 코스	    A, C	        1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
            요리 3개 코스	    C, D, E	        3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
            요리 4개 코스	    B, C, F, G	    1번, 5번 손님으로부터 총 2번 주문됐습니다.
            요리 4개 코스	    A, C, D, E	    4번, 6번 손님으로부터 총 2번 주문됐습니다.

            [문제]
            각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders,
            "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
            "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

            [제한사항]
            orders 배열의 크기는 2 이상 20 이하입니다.
            orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
            각 문자열은 알파벳 대문자로만 이루어져 있습니다.
            각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
            course 배열의 크기는 1 이상 10 이하입니다.
            course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
            course 배열에는 같은 값이 중복해서 들어있지 않습니다.
            정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
            배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
            만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
            orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.

            [입출력 예]
            orders	                                            course	        result
            ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	   [2,3,4]	    ["AC", "ACDE", "BCFG", "CDE"]
            ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]  [2,3,5]	    ["ACD", "AD", "ADE", "CD", "XYZ"]
            ["XYZ", "XWY", "WXA"]	                           [2,3,4]	    ["WX", "XY"]

            입출력 예에 대한 설명
            입출력 예 #1
            문제의 예시와 같습니다.

            입출력 예 #2
            AD가 세 번, CD가 세 번, ACD가 두 번, ADE가 두 번, XYZ 가 두 번 주문됐습니다.
            요리 5개를 주문한 손님이 1명 있지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.

            입출력 예 #3
            WX가 두 번, XY가 두 번 주문됐습니다.
            3명의 손님 모두 단품메뉴를 3개씩 주문했지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 3개로 구성된 코스요리는 새로 추가하지 않습니다.
            또, 단품메뉴를 4개 이상 주문한 손님은 없으므로, 요리 4개로 구성된 코스요리 또한 새로 추가하지 않습니다.
         */

        /*
          - 문제 이해하기 -
          1. 음식은 A ~ Z이며, A부터 순서대로 조합
          2. 정답은 마지막에 오름차순으로 정렬한다음에 반환
          3. 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬

          - 알고리즘 설계 -
          1. 해시맵을 선언
          2. 모든 경우의 수를 구해야한다. (순서는 고정. 깊이우선탐색(DFS)기법사용하기)
          3. 배열의 각문자열을 반복문을 통해 나열
          4. 문자열을 앞문자부터 course의 값만큼 문자를 잘라낸다.
          (반복문을 이용하며, 잘라내는 길이보다 course의 값이 더 클 경우 이후 로직을 수행하지 않고 해당 반복문을 종료처리)
          5. 해당 잘라낸 문자열을 키 값으로하며 밸류 값을 +1증가
          6. 이떄, 각 코스 개수의 최대값을 알고있어야 하므로, 선언해둔 courseArrays의 인덱스 값과 비교하여 현재 밸류값이 더 클 경우 해당 밸류값으로 배열의 값을 변경한다.
          7. course 반복문이 종료되면 다음 문자로 넘어가며 다시 위 3 ~ 4번 케이스를 반복한다.
        * */

        /* TC 1 result : ["AC", "ACDE", "BCFG", "CDE"] */
        //String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        //int[] course = {2, 3, 4};

        /* TC 2 result : ["ACD", "AD", "ADE", "CD", "XYZ"] */
        //String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        //int[] course = {2, 3, 5};

        /* TC 3 result : ["WX", "XY"] */
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        int[] courseArrays = new int[findLength(course)];
        Map<String, Integer> map = new HashMap<>();
        Stack<String>  stack = new Stack<>();
        List<String> answerList = new ArrayList<>();

        for (int num : course) {
            for (String str : orders) dfs(str, 0, num, stack, map, courseArrays);
        }

        for (String str : map.keySet()) {
            if (courseArrays[str.length()] >= 2 && map.get(str) == courseArrays[str.length()]) answerList.add(str);
        }

        answerList.sort(Comparator.naturalOrder());
        System.out.println(Arrays.toString(answerList.toArray(new String[answerList.size()])));
    }

    public static int findLength (int[] course) {
        int max = 0;
        for (int num : course) if (num > max) max = num;
        return course.length > max ? course.length + 1: max + 1;
    }

    private static void dfs(String str, int strIndex, int courseIndex, Stack<String> stack, Map<String, Integer> map, int[] courseArrays) {
        for (int i = strIndex; i < str.length(); i++) {
            stack.push(str.substring(i, i+1));
            if (courseIndex == stack.size() + 1) {
                Iterator iterator = stack.iterator();
                StringBuilder sb = new StringBuilder();

                while (iterator.hasNext()) sb.append(iterator.next());

                for (int j = i + 1; j < str.length(); j++) {
                    String menuBeforeSort = sb + str.substring(j, j + 1);
                    char[] menuArrays = menuBeforeSort.toCharArray();
                    Arrays.sort(menuArrays);
                    String menu = new String(menuArrays);
                    int value = map.getOrDefault(menu, 0) + 1;
                    if (value > courseArrays[courseIndex]) courseArrays[courseIndex] = value;
                    map.put(menu, value);
                }

                stack.pop();
                continue;
            } else if (courseIndex > stack.size()) dfs(str, i + 1, courseIndex, stack, map, courseArrays);
            stack.pop();
        }
    }
}
