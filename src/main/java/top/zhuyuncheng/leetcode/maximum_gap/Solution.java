package top.zhuyuncheng.leetcode.maximum_gap;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * <p>
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * <p>
 * <p>
 * 说明:
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
class Solution {
    /*
     * 动态查找相邻两数之间差值最大的值
     * 如果比 max 变量大，则记录，否则视为不是最大的差值，忽略
     *
     *
     */
    public int maximumGap(int[] nums) {
        int max = 0, length = nums.length;
        if (length < 2) {
            return max;
        }

        Arrays.sort(nums);

        for (int i = length - 1; i > 0; i--) {
            int diff = nums[i] - nums[i - 1];
            if (max < diff) {
                max = diff;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {3, 6, 9, 1};
//        int[] nums = {10000000, 1};
        int maximumGap = new Solution().maximumGap(nums);
        System.out.println(maximumGap);
    }
}