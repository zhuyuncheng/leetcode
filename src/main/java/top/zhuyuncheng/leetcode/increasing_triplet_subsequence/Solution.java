package top.zhuyuncheng.leetcode.increasing_triplet_subsequence;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
class Solution {

    /*
    * a[k] > a[j] > a[i]: 先找到两个最小的数 (a[j] > a[i]) 当有大于a[j]的时候，即return true 否则 return false
    */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 3) {
            return false;
        }

        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < first) {
                first = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            } else if (nums[i] > second){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -2, 6};
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(nums));
    }
}
