package a_1;
/**
 * 分组
 */
import java.util.Arrays;
import java.util.Scanner;
public class a_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 输入同学的数量n。
        int k = scanner.nextInt(); // 输入分组数 k。
        int[] heights = new int[n];

        // 输入n个整数，代表同学的身高。
        for (int i = 1; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        // 传入函数计算
        int result;
        result = fenZuHeight(heights, k);
        // 输出最后结果
        System.out.println(result);

    }

    private static int fenZuHeight(int[] heights, int k) {
        Arrays.sort(heights); // 将身高数组按升序排序。




        return result;
    }

}
