package top.zhuyuncheng.leetcode.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class Solution {

    /*
     *  采用 HashMap 时间换空间的做法：
     *  将每次遍历得到的元素放入到 HashMap 中
     *  每次 put 之前都需判断 HashMap 中是否包含 target - num[i]
     *
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
//        int[] nums = {3, 2, 4};
        int[] res = new Solution().twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }
}
