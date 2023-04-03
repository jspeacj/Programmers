package Level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongJustNow {
    public static void main(String[] args) throws ParseException {
        /*
            [3차] 방금그곡

            문제 설명
            방금그곡
            라디오를 자주 듣는 네오는 라디오에서 방금 나왔던 음악이 무슨 음악인지 궁금해질 때가 많다.
            그럴 때 네오는 다음 포털의 '방금그곡' 서비스를 이용하곤 한다. 방금그곡에서는 TV, 라디오 등에서 나온 음악에 관해 제목 등의 정보를 제공하는 서비스이다.

            네오는 자신이 기억한 멜로디를 가지고 방금그곡을 이용해 음악을 찾는다.
            그런데 라디오 방송에서는 한 음악을 반복해서 재생할 때도 있어서 네오가 기억하고 있는 멜로디는 음악 끝부분과 처음 부분이 이어서 재생된 멜로디일 수도 있다.
            반대로, 한 음악을 중간에 끊을 경우 원본 음악에는 네오가 기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다.
            그렇기 때문에 네오는 기억한 멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교하려고 한다. 다음과 같은 가정을 할 때 네오가 찾으려는 음악의 제목을 구하여라.

            방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
            네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
            각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다.
            음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
            음악이 00:00를 넘겨서까지 재생되는 일은 없다.
            조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.

            입력 형식
            입력으로 네오가 기억한 멜로디를 담은 문자열 m과 방송된 곡의 정보를 담고 있는 배열 musicinfos가 주어진다.

            1.m은 음 1개 이상 1439개 이하로 구성되어 있다.
            2. musicinfos는 100개 이하의 곡 정보를 담고 있는 배열로, 각각의 곡 정보는 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보가 ','로 구분된 문자열이다.
                2.1음악의 시작 시각과 끝난 시각은 24시간 HH:MM 형식이다.
                2.2음악 제목은 ',' 이외의 출력 가능한 문자로 표현된 길이 1 이상 64 이하의 문자열이다.
                2.3악보 정보는 음 1개 이상 1439개 이하로 구성되어 있다.

            출력 형식
            조건과 일치하는 음악 제목을 출력한다.

            입출력 예시
                m	                        musicinfos	                                    answer
            "ABCDEFG"	        ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
            "CC#BCC#BCC#BCC#B"	["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]	"FOO"
            "ABC"	            ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"WORLD"

            설명
            첫 번째 예시에서 HELLO는 길이가 7분이지만 12:00부터 12:14까지 재생되었으므로 실제로 CDEFGABCDEFGAB로 재생되었고, 이 중에 기억한 멜로디인 ABCDEFG가 들어있다.
            세 번째 예시에서 HELLO는 C#DEFGABC#DEFGAB로, WORLD는 ABCDE로 재생되었다. HELLO 안에 있는 ABC#은 기억한 멜로디인 ABC와 일치하지 않고, WORLD 안에 있는 ABC가 기억한 멜로디와 일치한다.
         */

        /* TC 1 answer : "HELLO" */
        //String m = "ABCDEFG";
        //String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        /* TC 2 answer : "FOO" */
        //String m = "CC#BCC#BCC#BCC#B";
        //String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        /* TC 3 answer : "WORLD" */
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        /* TC 4 answer : "TEST" */
        //String m = "DF";
        //String[] musicinfos = {"6:20,6:50,TEST,DDF"};
        /*
         - 알고리즘 로직 -
          1. 노래 시작 시간과 종료 시간의 차이를 구해서 time에 담는다.
          2. 배열의 주어진 노래의 음을 선언한 sb(StringBuilder)에 추가한다. (이떄, 주어진 노래의 음보다 time이 작을 경우, time만큼만 추가한다.)
          3. 음보다 시간(time)이 더 클 경우, 시간이 끝날떄까지 음을 뒤에 추가한다.
          4. 주어진 문자열m가 해당 sb값에서 포함되지 않을 경우(#유무 주의), 해당 노래가 아니므로 다음으로 넘어간다.
          5. 주어진 문자열m이 해당 sb값에서 포함될 경우, answer에 해당 노래 문자열을 담은뒤 반복문을 종료한다.
          6. 만약 반복문이 종료될떄까지 일치하는 음악이 없을 경우 "(None)"을 반환한다.
        * */
        StringBuilder sb = new StringBuilder();
        String answer = "(None)";
        long checkTime = 0;

        for (String str : musicinfos) {
            sb.setLength(0);
            String[] infoSplit = str.split(",");

            Date timeFirst = new SimpleDateFormat("HH:mm").parse(infoSplit[0]);
            Date timeFinish = new SimpleDateFormat("HH:mm").parse(infoSplit[1]);
            long time = (timeFinish.getTime() - timeFirst.getTime()) / 60000;

            char[] chars = infoSplit[3].toCharArray();
            int index = 0;
            for (int i = 0; i < time; i++) {
                if (index < (chars.length - 1) && chars[index+1] == '#') {
                    sb.append(chars[index] +String.valueOf(chars[index + 1]));
                    index++;
                } else {
                    sb.append(chars[index]);
                }

                index++;
                if (index >= chars.length) index = 0;
            }

            if (checkSong(m, sb) && time > checkTime) {
                checkTime = time;
                answer = infoSplit[2];
            }
        }

        System.out.println(answer);
    }

    private static boolean checkSong(String m, StringBuilder sb) {
        boolean flag = false;
        char[] mChars = m.toCharArray();
        char[] sbChars = sb.toString().toCharArray();

        List<String> mList = new ArrayList<>();
        List<String> sbList = new ArrayList<>();

        for (int i = 0; i < mChars.length; i++) {
            if (i < mChars.length - 1 && mChars[i + 1] == '#') {
                mList.add(mChars[i] + String.valueOf(mChars[i + 1]));
                i++;
            } else {
                mList.add(String.valueOf(mChars[i]));
            }
        }

        for (int j = 0; j < sbChars.length; j++) {
            if (j < sbChars.length - 1 && sbChars[j + 1] == '#') {
                sbList.add(sbChars[j] + String.valueOf(sbChars[j + 1]));
                j++;
            } else {
                sbList.add(String.valueOf(sbChars[j]));
            }
        }

        int index = 0;
        for (int i = 0; i < sbList.size(); i++) {
            if (sbList.get(i).equals(mList.get(index))) {
                for (int j = i; j < sbList.size(); j++) {
                    if (index == mList.size() && flag) break;

                    if (sbList.get(j).equals(mList.get(index))) {
                        index++;
                        flag = true;
                    } else {
                        index = 0;
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) break;
        }

        if (index != mList.size()) flag = false;

        return flag;
    }
}
