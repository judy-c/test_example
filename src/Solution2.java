import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {


    public static void main(String[] args) {

        int n;
        int m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String[][] arr = new String[n][m];
        HashMap<Integer, Integer> cMap = new HashMap<>();
        int s1 = 0, s2 = 0;
        int e1 = 0, e2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.next();
                if (arr[i][j].equals("C")) {
                    cMap.put(i, j);
                }
                if (arr[i][j].equals("S")) {
                    s1 = i;
                    s2 = j;
                }
                if (arr[i][j].equals("E")) {
                    e1 = i;
                    e2 = j;
                }
            }
        }

        Set cKeySet = cMap.keySet();
        int minCostRes = Integer.MAX_VALUE;
        for (Object k: cKeySet) {
            int c1, c2;
            c1 = (Integer)k;
            c2 = cMap.get((Integer)k);
            int minCost1 = minCost.getMinCostV1(s1, s2, c1, c2, arr);
            int minCost2 = minCost.getMinCostV1(c1, c2, e1, e2, arr);
            minCostRes = Math.min(minCostRes, minCost1 + minCost2);
        }

        System.out.printf("%d", minCostRes);

    }

}
class minCost {
    public static int GetMinCost(Integer s1, Integer s2, Integer e1, Integer e2, String[][] arr) {
        return  0;
    }
    public static int getMinCostV1(int s1, int s2, int e1, int e2, String[][] arr) {
        int n = Math.abs(s1 - e1);
        int m = Math.abs(s2 - e2);
        int[][] dp = new int[n + 1][m + 1];

        for (int i = s1 + 1; i <= e1; i++) {
            if (arr[i][s2].equals("B")) {
                dp[i - s1][0] = Integer.MAX_VALUE;
            } else {
                dp[i - s1][0] =  dp[i - s1 - 1][0];
                if (!(arr[i][s2].equals("C") || arr[i][s2].equals("E"))) {
                    dp[i - s1][0] += Integer.parseInt(arr[i][s2]);
                }
            }
        }
        for (int j = s2 + 1; j <= e2; j++) {
            if (arr[s1][j].equals("B")) {
                dp[0][j - s2] = Integer.MAX_VALUE;
            } else {
                dp[0][j - s2] = dp[0][j - s2 - 1];
                if (!(arr[s1][j].equals("C") || arr[s1][j].equals("E"))) {
                    dp[0][j - s2] += Integer.parseInt(arr[s1][j]);
                }
            }
        }

        for (int i = s1 + 1; i <= e1; i++) {
            for (int j = s2 + 1; j <= e2; j++) {
                if (arr[i][j].equals("B")) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[j - 1][i]);
                    if (!(arr[i][j].equals("C") || arr[i][j].equals("E"))) {
                        dp[i][j] += Integer.parseInt(arr[i][j]);
                    }
                }
            }
        }

        return dp[e1 - s1][e2 - s2];
    }
}