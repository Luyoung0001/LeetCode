package ooo1;

public class Test05 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            for(int j = i +1; j < 10; j++){
                System.out.println("i = " + i);
                break;
            }
        }
    }
}
