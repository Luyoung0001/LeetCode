package day01.no1;
/**
 * @author luliang
 * 暴力遍历
 * */
public class TwoSuming01 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10};
        int targit = 10;
        int[] result = Solution.twoSum(ints, targit);
        for(int inti : result){
            System.out.println(inti);
        }
    }
}
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[]{0,1};
        if(nums.length == 2){
            return ret;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }
}

