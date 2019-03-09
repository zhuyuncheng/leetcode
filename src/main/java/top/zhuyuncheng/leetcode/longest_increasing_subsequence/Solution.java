package top.zhuyuncheng.leetcode.longest_increasing_subsequence;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        // tail 数组的定义：长度为 i+1 的上升子序列的末尾最小值
        int[] tail = new int[len];
        // 遍历一遍整个数组，使用二分查找算法
        tail[0] = nums[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[res]) { // 比tail末尾用元素大
                tail[++res] = nums[i];
            } else { // 二分查找到第 1 个比 nums[i] 大的元素，更新到那个位置
                int l = 0;
                int r = res;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tail[mid] == nums[i]) {
                        l = mid;
                        break;
                    } else if (tail[mid] >= nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return ++res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}
