package a_1;
/**
 * 1.三带一
 *
 */

import java.util.Scanner;

public class a_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入整数T，表示轮数。
        int t = scanner.nextInt();

        for ( int i = 0; i < t; i++ ) {
            int sum = 0;
            // 输入手牌
            String hand = scanner.next();

            //计算手牌
            for ( int j = 0; j < 4; j++ ) {
                for (int n = j+1; n < 4; n++) {
                    if ( hand.charAt(j) == hand.charAt(n) ){
                        sum += 1;
                    }
                }
            }
            // 判断输出
            if (sum == 3) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
