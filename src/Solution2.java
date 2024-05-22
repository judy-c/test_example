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