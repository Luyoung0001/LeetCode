package day01.no3;
/**
 * 双指针
 * */
import java.util.Arrays;

public class TwoSuming03 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10};
        int targit = 13;
        int[] result = Solution.twoSum(ints, targit);
        for(int inti : result){
            System.out.println(inti);
        }
    }
}
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // 利用两个-1标记result[0]、result[1]是否更新
        int[] result = new int[]{-1, -1};
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        // 对原数组进行拷贝，再对拷贝后的数组进行排序
        int[] team = Arrays.copyOf(nums, nums.length);
        /*
        * 从JDK 7开始，java.util.Arrays.sort()使用双基准快速排序（Dual-Pivot Quicksort）作为实现。
                     static void sort(int[] a, int parallelism, int low, int high) {
                        int size = high - low;

                        if (parallelism > 1 && size > MIN_PARALLEL_SORT_SIZE) {
                            int depth = getDepth(parallelism, size >> 12);
                            int[] b = depth == 0 ? null : new int[size];
                            new Sorter(null, a, b, low, size, low, depth).invoke();
                        } else {
                            sort(null, a, 0, low, high);
                        }
                    }
        * */
        Arrays.sort(team);
        // 设立两个指针
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            if (team[l] + team[r] > target) {
                r--;
                continue;
            }
            if (team[l] + team[r] < target) {
                l++;
                continue;
            }
            if (team[l] + team[r] == target) {
                break;
            }
        }
        // 利用循环寻找第一个、第二个下标
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == team[l] && result[0] == -1) {
                result[0] = i;
                // 继续更新第二个
                continue;
            }
            if (nums[i] == team[r] && result[1] == -1) {
                result[1] = i;
            }
        }
        return result;
    }
}
