package top.zhuyuncheng.leetcode.merge_sorted_array;


import java.util.Arrays;

/*
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
class Solution {


    /*
     * 倒序双指针遍历两个数组
     * 如果nums2的元素小于nums1的元素，就将num1的元素放置在num1[len]位置，否则将num2的元素放置在num1[len]位置
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, len = m + n - 1;
        while (j >= 0) {
            nums1[len--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
