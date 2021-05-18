package ooo1;

public class Test06 {
    public static void main(String[] args) {
        int[] ints = new int[128];
        for(int i = 0; i < 128; i++){
            ints[i] = i;
        }
        /*for(int i : ints){
            System.out.print(i+" ");
            if(i%20 == 0){
                System.out.println();
            }
        }*/

        int i = 20;
        int a = ints[i]--;
        /*int a = ints[20];
        a = a - 1;*/
        System.out.println(a);


    }
}
