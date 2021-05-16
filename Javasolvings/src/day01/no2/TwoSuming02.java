package day01.no2;
/**
 * 利用HashMap
 * */

import java.util.HashMap;

public class TwoSuming02 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10};
        int targit = 13;
        int[] result = Solution.twoSum(ints, targit);
        for(int inti : result){
            System.out.println(inti);
        }
    }
}
class Solution{
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 1};
        int len = nums.length;
        if(nums.length == 2){
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 将nums[i]和i分别存储在集合对象map的key和value
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i );
        }
        // 遍历整个map，如果map.get(target-nums[i]) != null，就说明取到了第二个值
        for (int i = 0; i < len; i++) {
             int another = target - nums[i];
            if(map.get(another) != null){
                result[0] = i;
                result[1] = map.get(another);
                // 如果这两个value不相等，说明两个sums是不等的，找到了就break
                if(result[0] != result[1]){
                    break;
                }
            }
        }
        return result;
    }
}
