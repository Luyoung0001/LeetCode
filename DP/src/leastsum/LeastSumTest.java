package leastsum;
import java.util.Random;
/*将一堆正整数分为2组，要求2组的和相差最小。
例如：1 2 3 4 5，将1 2 4分为1组，3 5分为1组，两组和相差1，是所有方案中相差最少的。*/
public class LeastSumTest {
    public static void main(String[] args) {
        Random r = new Random();
        int[] sums = new int[20];
        for(int i = 0; i < 20; i++){
            sums[i] = r.nextInt(9)+1;
        }
        for(int sum : sums){
            System.out.print(sum+" ");
        }



    }
}
class LeastSum{
    //public static
}
