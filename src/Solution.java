import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public List<Integer> findServiceGroup(int n, int[] edges) {
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[n];
        int[] group = new int[n];
        int[] groupSize = new int[n];
        int[] groupMax = new int[n];
        int[] groupMin = new int[n];
        Arrays.fill(groupMin, Integer.MAX_VALUE);
        int groupId = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                groupId++;
                dfs(i, edges, visited, group, groupId, groupSize, groupMax, groupMin);
            }
        }
        int maxH = Integer.MIN_VALUE;
        int maxGroup = 0;
        for (int i = 1; i <= groupId; i++) {
            int H = groupSize[i] - group[i];
            if (H > maxH || (H == maxH && groupMax[i] > groupMax[maxGroup])) {
                maxH = H;
                maxGroup = i;
            }
        }
        int start = groupMin[maxGroup];
        while (true) {
            res.add(start);
            start = edges[start];
            if (start == groupMin[maxGroup]) {
                break;
            }
        }
        return res;
    }

    private void dfs(int i, int[] edges, int[] visited, int[] group, int groupId, int[] groupSize, int[] groupMax, int[] groupMin) {
        visited[i] = 1;
        group[i] = groupId;
        groupSize[groupId]++;
        groupMax[groupId] = Math.max(groupMax[groupId], i);
        groupMin[groupId] = Math.min(groupMin[groupId], i);
        if (visited[edges[i]] == 0) {
            dfs(edges[i], edges, visited, group, groupId, groupSize, groupMax, groupMin);
        } else if (group[edges[i]] != groupId) {
            group[edges[i]] = groupId;
            groupSize[groupId]++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
        }
        scanner.close();

        Solution solution = new Solution();
        List<Integer> res = solution.findServiceGroup(n, edges);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
