package a_1;

/**
 * 数树数
 */
import java.util.Scanner;

public class a_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();   //输入层数n
        int q = scanner.nextInt();   // 询问的路径数量q；

        for (int j = 0; j < q; j++) {
            int node = 1;
            // 输入字符
            String ql = scanner.next();

            for (int k = 0; k < ql.length(); k++) {
                if (ql.charAt(k) == 'L') {
                    node = 2 * node -1;
                }else {
                    node = 2 * node;
                }
            }
            System.out.println(node);
        }

    }
}
