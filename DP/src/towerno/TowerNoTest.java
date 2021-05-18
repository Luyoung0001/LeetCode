package towerno;

import java.util.Random;

/**
 * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
 * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
 * 该三角形第n层有n个数字，例如：
 * 第一层有一个数字：    5
 * 第二层有两个数字：   8  4
 * 第三层有三个数字：  3  6  9
 * 第四层有四个数字：7  2   9   5
 * 最优方案是：5 + 8 + 6 + 9 = 28
 * 注意:上面应该是排列成一个三角形的样子不是竖向对应的，排版问题没有显示成三角形。
 * 状态定义: Fi，j是第i行j列项最大取数和，求第n行Fn，m（0 < m < n）中最大值。
 * 状态转移方程：Fi，j = max{Fi-1,j-1,Fi-1,j}+Ai,j
 * 原文链接：https://blog.csdn.net/QuinnNorris/article/details/77484573
 * */
public class TowerNoTest {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] Tower = new int[10][10];
        // 生成塔
        for(int i = 0; i < 10; i++){
            for(int j = 0; j <= i; j++){
                // 生成[1,10]区间的整数
                Tower[i][j] = r.nextInt(9)+1;
            }
        }
        // 打印塔
        for(int i = 0; i < 10; i++){
            for(int j = 0; j <= i; j++){
                // 生成[1,10]区间的整数
                System.out.print(Tower[i][j] + " ");
            }
            System.out.println();
        }
        /* 看起来很完美，接下来可以用来做测试
            8
            4 5
            8 3 6
            9 2 3 1
            8 6 6 1 9
            8 5 3 9 2 7
            5 6 8 5 4 1 5
            9 6 1 2 5 1 4 6
            1 8 6 3 8 1 1 6 6
            9 6 1 5 1 1 8 6 5 7
            */

        int result = Towerno.getMaxNo(Tower,4,2);
        System.out.println(Tower[4][2]);
        System.out.println(result);

    }


}
class Towerno{
    public static int getMaxNo(int[][] T,int m,int n){
        int[][] maxes = new int[m+1][n+1];
        maxes[0][0] = T[0][0];
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(j == 0){
                    maxes[i][j] = maxes[i-1][j] + T[i][j];
                }else{
                    maxes[i][j] = Math.max(maxes[i-1][j-1],maxes[i-1][j])+T[i][j];
                }
            }
        }
        return maxes[m][n];
    }
}
