package ooo1;

public class Test08 {
    public static void main(String[] args) {
        String s = "01234567";

        for(int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ret = s.substring(i, j);
                System.out.println(ret);
            }
        }

    }
}
