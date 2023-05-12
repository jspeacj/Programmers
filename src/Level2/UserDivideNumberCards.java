package Level2;

public class UserDivideNumberCards {
    public static void main(String[] args) {
        /*
            숫자 카드 나누기

            문제 설명

            철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후,
            다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하려고 합니다.

            철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
            영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
            예를 들어, 카드들에 10, 5, 20, 17이 적혀 있는 경우에 대해 생각해 봅시다. 만약, 철수가 [10, 17]이 적힌 카드를 갖고,
            영희가 [5, 20]이 적힌 카드를 갖는다면 두 조건 중 하나를 만족하는 양의 정수 a는 존재하지 않습니다.
            하지만, 철수가 [10, 20]이 적힌 카드를 갖고, 영희가 [5, 17]이 적힌 카드를 갖는다면,
            철수가 가진 카드들의 숫자는 모두 10으로 나눌 수 있고, 영희가 가진 카드들의 숫자는 모두 10으로 나눌 수 없습니다.
            따라서 철수와 영희는 각각 [10, 20]이 적힌 카드, [5, 17]이 적힌 카드로 나눠 가졌다면 조건에 해당하는 양의 정수 a는 10이 됩니다.

            철수가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayA와 영희가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayB가 주어졌을 때,
            주어진 조건을 만족하는 가장 큰 양의 정수 a를 return하도록 solution 함수를 완성해 주세요. 만약, 조건을 만족하는 a가 없다면, 0을 return 해 주세요.

            제한사항

            1 ≤ arrayA의 길이 = arrayB의 길이 ≤ 500,000
            1 ≤ arrayA의 원소, arrayB의 원소 ≤ 100,000,000
            arrayA와 arrayB에는 중복된 원소가 있을 수 있습니다.

            입출력 예
            arrayA	     arrayB	          result
            [10, 17]	    [5, 20]	         0
            [10, 20]	    [5, 17]	         10
            [14, 35, 119]	[18, 30, 102]	 7

            입출력 예 설명
            입출력 예 #1
            문제 예시와 같습니다.

            입출력 예 #2
            문제 예시와 같습니다.

            입출력 예 #3
            철수가 가진 카드에 적힌 숫자들은 모두 3으로 나눌 수 없고, 영희가 가진 카드에 적힌 숫자는 모두 3으로 나눌 수 있습니다.
            따라서 3은 조건에 해당하는 양의 정수입니다.
            하지만, 철수가 가진 카드들에 적힌 숫자들은 모두 7로 나눌 수 있고, 영희가 가진 카드들에 적힌 숫자는 모두 7로 나눌 수 없습니다.
            따라서 최대값인 7을 return 합니다.
         */

        /*
          규칙 :
          1.철수와 영희가 가진 각 카드들의 최대 공약수를 따로 따로 구한다.
          2. 각 구한 최대 공약수(gcdA, gcdB)를 다른 사람의 카드 뭉치(배열)로 나눠지는지 검토한다.
          3. 2번 수행에서 나누어지는 경우의 수가 존재하지 않을 경우, 조건에 만족하는 최대 값이므로 해당 값이 해당 사람의 최대 양의 정수 a이다.
          4. 철수와 영희를 각 기준으로 2번 케이스를 수행하고 큰 값을 반환한다.
          (최대 공약수의 약수를 기준으로 수행하는 것이 아닌,
          최대 공약수만 가지고 검토하는 이유는 해당 최대 공약수로 나누어 떨어지는 경우일 경우,
           해당 최대 공약수의 약수로도 당연히 나누어 떨이지기 때문에 체크할 필요가 없다.)
        * */

        /* TC 1 result 0 */
        //int[] arrayA = {10, 17};
        //int[] arrayB = {5, 20};

        /* TC 2 result 10 */
        //int[] arrayA = {10, 20};
        //int[] arrayB = {5, 17};

        /* TC 3 result 7 */
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};

        long gcdA = arrayA[0], gcdB = arrayB[0];

        for (int i = 0; i < arrayA.length-1; i++) {
            gcdA = gcd(gcdA, arrayA[i+1]);
            gcdB = gcd(gcdB, arrayB[i+1]);
        }

        System.out.println(Math.max(checkMeasure(gcdA, arrayB), checkMeasure(gcdB, arrayA)));
    }

    private static int checkMeasure(long gcd, int[] array) {
        boolean checkFlag = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % gcd == 0) {
                checkFlag = false;
                break;
            }
        }

        if (checkFlag) return (int)gcd;
        else return 0;
    }

    private static long gcd(long a, long b) {
        long r = a % b;
        if (r == 0) return b;
        else return gcd(b, r);
    }
}
