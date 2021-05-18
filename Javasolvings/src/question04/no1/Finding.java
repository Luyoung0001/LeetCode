package question04.no1;

import java.util.Arrays;
import java.util.HashMap;

public class Finding {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1};
        int[] nums2 = new int[]{1,2};

        double result = Solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        HashMap<Integer, Integer> ret = new HashMap<>();
        // 全部把值放进去
        for(int i = 0; i < nums1.length; i++){
            ret.put(nums1[i],i);
        }
        for(int j = 0; j < nums2.length; j++){
            ret.put(nums2[j],j);
        }

        Integer[] rett = ret.keySet().toArray(new Integer[0]);
        Arrays.sort(rett);
        for(Integer i : rett){
            System.out.print(i + " ");
        }
        int len = rett.length;
        if(len%2 == 0){
            result = (double) (rett[len/2]+rett[len/2 - 1])/2;
        }
        if(len%2 != 0){
            result = (double) (rett[len/2]);
        }
        return result;


    }
}
