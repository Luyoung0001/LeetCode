package jumpgame;

public class JumpGameTest {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,1,4};
        int[] b = new int[]{3,2,1,0,4};
        boolean result1 = JumpGame.isJump(a);
        boolean result2 = JumpGame.isJump(b);
        System.out.println(result1);
        System.out.println(result2);

    }
}
class JumpGame{
    public static boolean isJump(int[] a){
        int n = a.length;
        a[0] = 1;
        boolean[] f = new boolean[n];
        f[0] = true;
        for(int i = 1; i < n; i++){
            if(f[i-1]&(a[i] >= 1 )){
                f[i] = true;
            }else{
                f[i] = false;
            }
        }
        return f[n-1];
    }
}
