package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class MazeEscape {
    public static int[] locationL = new int[2];
    public static boolean[][] check;
    public static void main(String[] args) {
        /*
            미로 탈출

            문제 설명

            1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다.
            각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다.
            통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다.
            따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다.
            이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다.
            미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.

            미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요.
            만약, 탈출할 수 없다면 -1을 return 해주세요.

            제한사항
            5 ≤ maps의 길이 ≤ 100
            5 ≤ maps[i]의 길이 ≤ 100
            maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
            S : 시작 지점
            E : 출구
            L : 레버
            O : 통로
            X : 벽
            시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
            출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.

            입출력 예
                            maps	                  result
            ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	16
            ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	-1

            입출력 예 설명

            입출력 예 #1
            주어진 문자열은 다음과 같은 미로이며

            image1

            다음과 같이 이동하면 가장 빠른 시간에 탈출할 수 있습니다.

            image2

            4번 이동하여 레버를 당기고 출구까지 이동하면 총 16초의 시간이 걸립니다. 따라서 16을 반환합니다.

            입출력 예 #2
            주어진 문자열은 다음과 같은 미로입니다.

            image3

            시작 지점에서 이동할 수 있는 공간이 없어서 탈출할 수 없습니다. 따라서 -1을 반환합니다.
         */

        /* TC 1 result : 16 */
        //String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        /* TC 2 result : -1 */
        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        /*
            알고리즘 순서 :
              큐(Queue)와 이미 지나간 공간인지 체크하는 boolean타입 이차원 배열을 이용하여 모든 경우의 수를 구한다.
              1. S(시작) -> L(레버)까지의 최단 거리를 구한다. (distanceL)
              2. L(레버) -> (E) 탈출까지의 최단 거리를 구한다. (distanceE)
              3. distanceL + distanceE 값이 최단 거리이다.
              ※출구는 레버가 당겨지지 않아도 지나갈 수 있기 때문에 벽(X)이 아닐 경우 경우의 수에 포함시킨다.
              ※모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있다고 명시되어 있기 때문에, 위 1번 진행 이후 배열을 초기화시킨다.
        */

        Queue<Node> queue = new LinkedList<>();
        String[][] maze = new String[maps.length][maps[0].length()];
        check = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            int j = 0;
            for (char c : maps[i].toCharArray()) {
                maze[i][j++] = c + "";
                System.out.print(" " + maze[i][j-1] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if ("S".equals(maze[i][j])) {
                    queue.add(new Node(i, j, 0));
                    check[i][j] = true;
                    break;
                }
            }
            if (!queue.isEmpty()) break;
        }

        int distanceL = dijkstra(queue, maze, "L");
        if (distanceL == Integer.MAX_VALUE) System.out.println(-1);

        check = new boolean[maps.length][maps[0].length()];
        queue.add(new Node(locationL[0], locationL[1], distanceL));

        int distanceE = dijkstra(queue, maze, "E");

        if (distanceE == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(distanceE);
    }

    private static int dijkstra(Queue<Node> queue, String[][] maze, String destination) {
        int distance = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (findDestination(queue, node, maze, destination)) {
                distance = (node.getDistance() + 1) < distance ? node.getDistance() + 1 : distance;
            }
        }

        return distance;
    }

    private static boolean findDestination(Queue<Node> queue, Node node, String[][] maze, String destination) {
        boolean findLocation = false;
        int row = node.getRow();
        int col = node.getCol();

        if (row + 1 < maze.length && !check[row+1][col] && !"X".equals(maze[row+1][col])) {
            if(destination.equals(maze[row+1][col])) {
                findLocation = true;
                locationL[0] = row + 1;
                locationL[1] = col;
            } else {
                queue.add(new Node(row+1, col, node.getDistance() + 1));
                check[row+1][col] = true;
            }
        }

        if (row - 1 > -1 && !check[row-1][col] && !"X".equals(maze[row-1][col])) {
            if(destination.equals(maze[row-1][col])) {
                findLocation = true;
                locationL[0] = row - 1;
                locationL[1] = col;
            } else {
                queue.add(new Node(row-1, col, node.getDistance() + 1));
                check[row-1][col] = true;
            }
        }

        if (col + 1 < maze[row].length && !check[row][col+1] && !"X".equals(maze[row][col+1])) {
            if(destination.equals(maze[row][col+1])) {
                findLocation = true;
                locationL[0] = row;
                locationL[1] = col + 1;
            } else {
                queue.add(new Node(row, col+1, node.getDistance() + 1));
                check[row][col+1] = true;
            }
        }

        if (col - 1 > -1 && !check[row][col-1] && !"X".equals(maze[row][col-1])) {
            if(destination.equals(maze[row][col-1])) {
                findLocation = true;
                locationL[0] = row;
                locationL[1] = col - 1;
            } else {
                queue.add(new Node(row, col-1, node.getDistance() + 1));
                check[row][col-1] = true;
            }
        }

        return findLocation;
    }

    public static class Node {
        private int row;
        private int col;
        private int distance;

        public Node (int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public int getDistance() {
            return this.distance;
        }
    }
}
