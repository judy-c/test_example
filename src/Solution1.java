import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        int[] a = input();
        int[] b = input();
        // 题目数据量太小，使用简单粗暴方式，实际要用类似kmp算法

        int as = 0, ae = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int k = 0;
                while (k+i < a.length && k+j < b.length && a[i+k] == b[j+k]) {
                    k++;
                }
                if (k > ae-as+1) {
                    as = i;
                    ae = i+k-1;
                }
            }
        }
        if (ae - as < 0) {
            System.out.print(-1);
            return;
        }

        output(a, as, ae);

    }

    public static void output(int[] a, int start, int end) {
        if (end < start) {
            System.out.print(-1);
            return;
        }
        for (int i = start; i <= end; i++) {
            System.out.print(a[i]);
            if (i < end) {
                System.out.print(" ");
            }
        }
    }

    public static int[] input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int[] a = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            a[i] = Integer.parseInt(numbers[i]);
        }
        return a;
    }

}