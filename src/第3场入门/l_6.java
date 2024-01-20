package 第3场入门;

import java.util.*;

public class l_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        long result = countValidIntervals(arr, A, B);
        System.out.println(result);
    }

    private static long countValidIntervals(long[] arr, long A, long B) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;

            for (int j = i; j < n; j++) {
                product *= arr[j];

                if (product % A == 0 && product % B != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
