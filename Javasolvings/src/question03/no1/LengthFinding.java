package question03.no1;
import java.util.HashMap;

public class LengthFinding {
    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "abcabcbb";
        String s3 = "abcdabcdeabcdef";
        String s4 = "bbbb";
        Solution solution = new Solution();
        int ret = solution.lengthOfLongestSubstring(s2);
        System.out.println(ret);
    }
}
class Solution{
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0) return 0;
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}

/*class Solution{
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // max用来标记最长
        int max = 0;
        // left用来标记起点位置
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                // 如果包含，就更新left的值为：这个被包含字符的value+1
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            // 并将这个值放入HashMap中
            map.put(s.charAt(i),i);
            // 每次循环都更新max的值为最长
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}*/
    /*public int lengthOfLongestSubstring(String s) {
        char[] sTochar = s.toCharArray();
        int len = sTochar.length;
        int[] lengths = new int[len - 1];
        int counter = 1;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(sTochar[i] != sTochar[j]){
                    counter++;
                }else{
                    lengths[i] = counter;
                    counter = 1;
                    break;
                }
                if(j == len-1){
                    lengths[i] = counter;
                    counter = 1;
                }
                System.out.println(counter);
            }
        }
        Arrays.sort(lengths);
        return lengths[len-2];
    }*/
