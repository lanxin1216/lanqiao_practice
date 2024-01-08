package a_1;
/*
  分组
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
        for (int i = 0; i < n; i++) {
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
        int min = 0; // 可能的极差最小值
        int max = heights[heights.length -1] - heights[0]; // 可能的极差最大值
        int result = max; // 最小的极差的初始值

        // 使用二分法查找极差的最小范围
        while (min <= max) {
            int mid = (min + max) / 2; // 二分法查找中间值
            int count = 1; //当前的分组数量
            int i = 0;

            for (int j = 1; j < heights.length; j++) {
                if (heights[j] - heights[i] > mid) {   // 判断是否超过当前极差
                    count++;  // 如果超过了当前极差，就在加一个分组
                    i = j; // 更新分组的起始位置
                    // 当两个连续的身高之差大于当前的极差时，需要将分组的起始位置更新位当前的位置
                    // 这样确保了每个分组都是连续的，每个分组中的身高差都小于或等于当前的极差
                }
            }

            // 如果count也就是分组数量小于或等于目标分组数量k，则当前的极差满足要求（即result = mid），
            // 而且result（最大极差）还能再小，根据二分法缩小范围，即max = mid-1；（缩小右边界，向左边界查找）
            // 如果count大于了k，则当前极差不满足要求，就需要扩大极差，即 min = mid+1；（扩大左边界，向右边界查找）
            if (count <= k) {
                result = mid;
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return result;
    }

}
