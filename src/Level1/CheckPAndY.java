package Level1;

public class CheckPAndY {
    public static void main(String[] args) {
        //문자열 내 p와 y의 개수
        String s = "pPoooyY";
        s = s.toLowerCase();

        int countP = findP(s);
        int countY = findY(s);

        System.out.println(countP == countY ? true : false);
    }

    public static int findP(String s) {
        int indexP = s.indexOf("p");
        int countP = 0;

        if (indexP == -1) return 0;

        while (true) {
            indexP = s.indexOf("p", indexP);

            if (indexP == -1) break;

            indexP++;
            countP++;
        }

        return countP;
    }

    public static int findY(String s) {
        int indexY = s.indexOf("y");
        int countY = 0;

        if (indexY == -1) return 0;

        while (true) {
            indexY = s.indexOf("y", indexY);

            if (indexY == -1) break;

            indexY++;
            countY++;
        }

        return countY;
    }
}
