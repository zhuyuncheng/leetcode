package top.zhuyuncheng.leetcode.maximum_subarray;

/**
 * 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
class Solution {


    /*
     *   在这一遍扫描数组当中，从左到右记录当前子序列的和 tempSum，
     *   若这个和不断增加， 那么最大子序列的和 max 也不断增加(不断更新 max)。
     *   如果往前扫描中遇到负数，那么当前子序列的和将会减小。
     *   此时 tempSum 将会小于 max，当然 max 也就不更新。
     *
     *   如果 tempSum 降到 0 时，说明前面已经扫描的那一段就可以抛弃了，
     *   这时将 tempSum 置为 0。然后，tempSum 将从后面开始将这个子段进行分析，
     *   若有比当前 max 大的子段，继 续更新 max。这样一趟扫描结果也就出来了。
     */
    int maxSubArray(int[] nums) {
        int tempSum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];

            if (tempSum > max) {
                max = tempSum;
            } else if (tempSum < 0) {
                tempSum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] numArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = new Solution().maxSubArray(numArray);
        System.out.println(max);
    }
}
