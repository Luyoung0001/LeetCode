package day01.no4;

import java.util.HashMap;

public class TwoSuming0201 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10};
        int targit = 12;
        int[] result = Solution.twoSum(ints, targit);
        for(int inti : result){
            System.out.println(inti);
        }
    }
}
class Solution{
    public static int[] twoSum(int[] sums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < sums.length; i++){
            // 存在则返回
            int another = target - sums[i];
            if(map.containsKey(another)){
                return new int[]{map.get(another),i};
            }
            // 不存在就往里面存
            else{
                map.put(sums[i],i);
            }
        }
        return new int[0];

    }
}
