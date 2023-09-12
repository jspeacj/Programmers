package Level2;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TakeGroupPhoto {
    private static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static boolean[] visited = new boolean[8];
    private static List<Condition> list = new ArrayList<>();
    private static int answer;
    public static void main(String[] args) {
        /*
            단체사진 찍기

            문제 설명

            단체사진 찍기

            picture

            가을을 맞아 카카오프렌즈는 단체로 소풍을 떠났다. 즐거운 시간을 보내고 마지막에 단체사진을 찍기 위해 카메라 앞에 일렬로 나란히 섰다.
            그런데 각자가 원하는 배치가 모두 달라 어떤 순서로 설지 정하는데 시간이 오래 걸렸다. 네오는 프로도와 나란히 서기를 원했고,
            튜브가 뿜은 불을 맞은 적이 있던 라이언은 튜브에게서 적어도 세 칸 이상 떨어져서 서기를 원했다. 사진을 찍고 나서 돌아오는 길에,
            무지는 모두가 원하는 조건을 만족하면서도 다르게 서는 방법이 있지 않았을까 생각해보게 되었다.
            각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램을 작성해보자.

            입력 형식
            입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data로 주어진다. data의 원소는 각 프렌즈가 원하는 조건이 N~F=0과 같은 형태의 문자열로 구성되어 있다. 제한조건은 아래와 같다.

            1 <= n <= 100
            data의 원소는 다섯 글자로 구성된 문자열이다. 각 원소의 조건은 다음과 같다.
            첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다. {A, C, F, J, M, N, R, T} 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브를 의미한다.
            첫 번째 글자는 조건을 제시한 프렌즈, 세 번째 글자는 상대방이다. 첫 번째 글자와 세 번째 글자는 항상 다르다.
            두 번째 글자는 항상 ~이다.
            네 번째 글자는 다음 3개 중 하나이다. {=, <, >} 각각 같음, 미만, 초과를 의미한다.
            다섯 번째 글자는 0 이상 6 이하의 정수의 문자형이며, 조건에 제시되는 간격을 의미한다. 이때 간격은 두 프렌즈 사이에 있는 다른 프렌즈의 수이다.
            출력 형식
            모든 조건을 만족하는 경우의 수를 리턴한다.

            예제 입출력
            n	       data	        answer
            2	["N~F=0", "R~T>2"]	 3648
            2	["M~C<2", "C~M>1"]	  0

            예제에 대한 설명
            첫 번째 예제는 문제에 설명된 바와 같이, 네오는 프로도와의 간격이 0이기를 원하고 라이언은 튜브와의 간격이 2보다 크기를 원하는 상황이다.

            두 번째 예제는 무지가 콘과의 간격이 2보다 작기를 원하고, 반대로 콘은 무지와의 간격이 1보다 크기를 원하는 상황이다. 이는 동시에 만족할 수 없는 조건이므로 경우의 수는 0이다.
         */

        /* TC 1 answer : 3648 */
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        /* TC 2 answer : 0 */
        //int n = 2;
        //String[] data = {"M~C<2", "C~M>1"};

        /* 문제 이해하기 및 풀이 방식
            1. 주어진 조건이 모두 만족 해야한다.
            (만족할 수 없는 조건이 있을 경우 0 반환 후 종료)
            2. 모든 조건을 리스트에 담아둔다.
            3. 깊이 우선 탐색 기법(DFS : Deapth-First-Search)를 이용하여 모든 경우의 수를 구하지만, 각 dfs 수행시마다 모든 조건을 담아둔 리스트의 조건들을 체크한다.
            4. 검토한 케이스와 일치할 경우 값을 증가시킨다.
        */

        StringBuilder sb = new StringBuilder();
        clearGlovalVar(); // 전역변수 초기화

        for (int i = 0; i < n; i++) {
            char[] charArr = data[i].toCharArray();
            list.add(new Condition(charArr[0], charArr[2], charArr[3], Integer.parseInt(charArr[4] + "")));
        }

        dfs(sb); // 깊이 우선 탐색 수행

        System.out.println(answer);
    }

    public static void clearGlovalVar () { // 전역변수 초기화
        Arrays.fill(visited, false);
        list.clear();
        answer = 0;
    }

    public static void dfs(StringBuilder sb) {
        boolean flag = true; // 모든 프렌즈가 채워져있고 모든 조건에 적합할 경우에 answer값 증가
        if (validation(sb.toString())) {
            for (int i = 0; i < visited.length; i++) { // 모든 자리가 채워졌는지 체크. 아직 빈자리가 있을 경우 모든 프렌즈가 구성된게 아니므로 넘어가기
                if (!visited[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
                return; // 이미 모든 자리가 채워진 경우이므로 더이상 반복문을 수행할 필요가 없으니 종료
            }

            for (int i = 0; i < friends.length; i++) {
                if (visited[i]) continue; // 이미 채워진 프렌즈일 경우 넘어가기

                visited[i] = true;
                sb.append(friends[i]);

                dfs(sb);

                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1); // 마지막에 추가한 프렌즈 지우기
            }
        }
    }

    public static boolean validation(String str) {
        for (int i = 0; i < list.size(); i++) {
            Condition condition = list.get(i);
            char to = condition.to;
            char from = condition.from;
            char sign = condition.sign;
            int num = condition.num;


            // 해당 조건에 맞는 프렌즈가 아직 문자열에 포함이 안되어 있을 경우 해당 조건은 우선 넘어가기
            if (str.indexOf(String.valueOf(to)) == -1 || str.indexOf(String.valueOf(from)) == -1) {
                continue;
            }

            int distance = Math.abs(str.indexOf(String.valueOf(to)) - str.indexOf(String.valueOf(from)));
            switch (sign) {
                case '=' :
                    if (distance != (num+1)) {
                        return false; // 조건을 만족하지 않을 경우 false 반환
                    }
                    break;
                case '>' :
                    if (distance <= (num+1)) {
                        return false; // 조건을 만족하지 않을 경우 false 반환
                    }
                    break;
                case '<' :
                    if (distance >= (num+1)) {
                        return false; // 조건을 만족하지 않을 경우 false 반환
                    }
                    break;
            }
        }

        return true; // 모든 조건을 만족할 경우 true 반환
    }

    public static class Condition { // 조건을 담아두기 위한 클래스 선언
        char from;
        char to;
        char sign;
        int num;

        public Condition (char from, char to, char sign, int num) {
            this.from = from;
            this.to = to;
            this.sign = sign;
            this.num = num;
        }
    }
}
