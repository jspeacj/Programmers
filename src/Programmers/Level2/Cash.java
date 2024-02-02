package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class Cash {
    public static void main(String[] args) {
        /*
            [1차] 캐시
            문제 설명
            캐시
            지도개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 읽어 보여주는 서비스를 개발하고 있다.
            이 프로그램의 테스팅 업무를 담당하고 있는 어피치는 서비스를 오픈하기 전 각 로직에 대한 성능 측정을 수행하였는데,
            제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다는 것을 알게 되었다.
            어피치는 제이지에게 해당 로직을 개선하라고 닦달하기 시작하였고,
            제이지는 DB 캐시를 적용하여 성능 개선을 시도하고 있지만 캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.

            어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.

            입력 형식
            캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
            cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
            cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
            각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 도시 이름은 최대 20자로 이루어져 있다.

            출력 형식
            입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.

            조건
            캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
            cache hit일 경우 실행시간은 1이다.
            cache miss일 경우 실행시간은 5이다.

            입출력 예제
            캐시크기(cacheSize)	    도시이름(cities)	                                                                                                 실행시간
                3	                ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	                          50
                3	                ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	                                  21
                2	                ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	  60
                5	                ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	  52
                2	                ["Jeju", "Pangyo", "NewYork", "newyork"]	                                                                          16
                0	                ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	                                                                      25
         */

        /*
            문제 이해하기 :
                1. 캐시가 비어있을 경우 다음 도시(city)를 채워 넣는다. (실행시간 + 5)
                2. 다음 도시(city)가 이미 캐시에 있을 경우 실행 시간 + 1
                3. 다음 도시(city)가 캐시 안에 없을 경우 실행 시간 + 5
                4. 만약 해당 도시가 기존에 있었을 경우 해당 도시와 관련된 캐시를 가장 최신으로 업데이트한다. (가장 최근 들어온 것으로 위치 변경)
                   (ex.cacheSize가 4이고 현재 list[2,3,1,4] 인 상태에서 1이 hit되었을때 list[3,1,4,1]가 되면 안되고 list[2,3,4,1] 가 되어야합니다.)
         */

        /* TC 1 결고*/
        //int cacheSize = 3;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        /* TC 2 */
        //int cacheSize = 3;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        /* TC 3 */
        //int cacheSize = 2;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        /* TC 4 */
        //int cacheSize = 5;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        /* TC 5 */
        //int cacheSize = 2;
        //String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        /* TC 6 */
        //int cacheSize = 0;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        /* TC 7 */
        int cacheSize = 3;
        String[] cities = {"A", "B", "A"};

        /*
        * cache hit인 경우 해당값을 가장 최신값으로 업데이트 해주어야 합니다.
          cacheSize가 4이고 현재 cache[2,3,1,4] 인 상태에서 1이 hit되었을때 cache[3,1,4,1]가 되면 안되고 cache[2,3,4,1] 가 되어야합니다.
        * */
        int answer = 0;
        List<String> list = new ArrayList<>();

        if (cacheSize == 0) System.out.println(cities.length * 5); // 코테에서는 return 이므로 이후 로직 수행 X

        for (String s : cities) {
            s = s.toLowerCase(); // 대소문자 구분을 하지 않으므로 소문자로 변환
            int index = list.indexOf(s);

            if (index > -1) answer += 1;
            else answer += 5;

            if (list.size() >= cacheSize) {
                if (index > -1) list.remove(index); // 리스트에서 해당 도시 인덱스 삭제 (리스트 특성상 이후 데이터들이 자동으로 앞당겨짐)
                else list.remove(0);
            }

            list.add(s); // 현재 도시를 큐에 넣기
        }

        System.out.println(answer);
    }
}
