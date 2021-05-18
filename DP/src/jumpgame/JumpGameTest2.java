package jumpgame;

public class JumpGameTest2 {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,1,4};
        int[] b = new int[]{3,2,1,0,4};
        boolean result1 = JumpGame1.isJump(a);
        boolean result2 = JumpGame1.isJump(b);
        System.out.println(result1);
        System.out.println(result2);

    }
}
class JumpGame1{
    public static boolean isJump(int[] a){
        int n = a.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for(int j = 1; j < n; j++){
            f[j] = false;
            for(int i = 0; i < j; i++){
                if(f[i]&(a[i] + i >= j)){
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }
}
