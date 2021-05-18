package coinchange;
/**
 * 动态规划
 * */
public class CoinChangeTest {
    public static void main(String[] args) {
        int[] ints = new int[]{2,5,7};
        int target = 27;
        int result = coinChange(ints,target);
        System.out.println(result);

    }
    public static int coinChange(int[] M,int target){
        int[] f = new int[target+1];
        f[0] = 0;
        for(int i = 1; i <= target; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < M.length; j++){
                if(i >= M[j] && f[i-M[j]]!= Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-M[j]]+1,f[i] );
                }
            }
        }
        if(f[target] == Integer.MAX_VALUE){
            f[target] = -1;
        }
        return f[target];
    }
}
