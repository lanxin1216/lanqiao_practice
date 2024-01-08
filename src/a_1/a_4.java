package a_1;

/*
  健身
 */
import java.util.Scanner;
public class a_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();     // 输入总天数。
        int m = scanner.nextInt();     // 输入健身计划的个数。
        int q = scanner.nextInt();     // 输入其他安排的天数（未健身）。

        int[] dayDis = new int[q + 2];     // 定义数组存储其他安排的天数
        // 数组的长度定义为q + 2 是因为需要标记最后一天的日期。也就是假如总天数为n=3，则需要标记第4天到dayDis数组中。

        for (int i = 1; i <= q; i++) {
            dayDis[i] = scanner.nextInt();  // 输入天数,dayDis[0]默认标记为：0。
        }
        // 标记最后一天
        dayDis[q + 1] = n + 1;   // 此处加入的就是总天数的后一天。

        int[] w = new int[m];  // 定义数组w存储健身计划需要的天数
        int[] v = new int[m];  // 定义数组v存储健身计划的增益

        for (int i = 0; i < m; i++) {
            w[i] = (int)Math.pow(2,scanner.nextInt());    // 使用数学函数，将输入的值做2的指数，使用2的幂次方算出天数。
            v[i] = scanner.nextInt();   // 输入对应的计划增益。
        }

        long result = 0;  // 最终的健身增益和,定义为long的原因是题目给的测试数据范围较大，int型的长度不够，导致部分测试案例不通过

        for (int i = 0; i < q + 1; i++) {
            int dis = dayDis[i + 1] - dayDis[i] - 1; // 计算两个其他安排（未健身）天数之间的空闲天数
            result += max_fitness_gain(dis, w, v); // 调用max_fitness_gain函数计算空闲天数的最大健身增益和
        }
        System.out.println(result); // 输出最终的健身增益和
    }

    /**
     * 动态规划求解背包问题
     *
     * @param dayDis  空闲天数
     * @param w       健身计划需要的天数
     * @param v       对应健身计划的增益
     * @return 返回这段空闲天数的最大健身增益和
     */
    static long max_fitness_gain(int dayDis, int[] w, int[] v) {
        if (dayDis == 0) {
            return 0;         // 如果dayDis = 0，则直接放回0。
        }

        long[] dp= new long[dayDis + 1];  // 定义一个数组存储当前天数所能达到的最大健身增益和。

        for (int y = 0; y < w.length; y++) {    // 遍历所有的健身计划。
            for (int i = w[y]; i <= dayDis; i++) {  // 遍历当前空闲天数范围内的所有天数
                dp[i] = Math.max(dp[i], dp[i - w[y]] + v[y]);  // 动态规划
            }
        }
        // 在每一天 i，计算当前健身计划的增益，即 dp[i - w[y]] + v[y]，表示在 i - w[y] 天的基础上加上当前计划的增益。
        // 通过比较当前天数的最大健身增益和之前状态的增益，选择较大值更新 dp[i]
        return dp[dayDis];
    }
}
