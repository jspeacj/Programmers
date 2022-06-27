package Level1;

import java.util.*;

public class KeyPad {
    public static void main(String[] args) {
        //키패드 누르기 (2020 카카오 인턴십)
        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String answer = "";

        Map<Integer, position> keyPad = new HashMap<>();
        keyPad.put(0, new position(3, 1));
        keyPad.put(1, new position(0, 0));
        keyPad.put(2, new position(0, 1));
        keyPad.put(3, new position(0, 2));
        keyPad.put(4, new position(1, 0));
        keyPad.put(5, new position(1, 1));
        keyPad.put(6, new position(1, 2));
        keyPad.put(7, new position(2, 0));
        keyPad.put(8, new position(2, 1));
        keyPad.put(9, new position(2, 2));

        Map<String, Integer> handPosition = new HashMap<>();
        handPosition.put("left",-1);
        handPosition.put("right",-1);

        //각 왼쪽손과 오른손의 엄지 위치를 알기 위한 변수 선언
        int lRow = 0;
        int lCol = 0;
        int rRow = 0;
        int rCol = 0;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                handPosition.put("left", num);
                continue;
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                handPosition.put("right", num);
                continue;
            } else {
                int lNum = handPosition.get("left");
                if (lNum == -1) {
                    //초기번호인 "*"일 경우
                    lRow = 3;
                    lCol = 0;
                } else {
                    lRow = keyPad.get(lNum).getX();
                    lCol = keyPad.get(lNum).getY();
                }

                int rNum = handPosition.get("right");
                if (rNum == -1) {
                    //초기번호인 "#"일 경우
                    rRow = 3;
                    rCol = 2;
                } else {
                    rRow = keyPad.get(rNum).getX();
                    rCol = keyPad.get(rNum).getY();
                }

                int row = keyPad.get(num).getX();
                int col = keyPad.get(num).getY();

                int lDistance = Math.abs(lRow - row) + Math.abs(lCol - col);
                int rDistance = Math.abs(rRow - row) + Math.abs(rCol - col);

                if (lDistance > rDistance) {
                    answer += "R";
                    handPosition.put("right", num);
                    continue;
                } else if (lDistance < rDistance) {
                    answer += "L";
                    handPosition.put("left", num);
                    continue;
                } else {
                    if ("left".equals(hand)) {
                        answer += "L";
                        handPosition.put("left", num);
                        continue;
                    } else {
                        answer += "R";
                        handPosition.put("right", num);
                        continue;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static class position {
        private int x;
        private int y;

        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
