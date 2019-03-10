package top.zhuyuncheng.leetcode.sliding_window_maximum;

import java.util.*;

/*
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 *
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 */
class Solution {
    /*
     * Java双端队列实现，限制窗口范围，保证最左边一直是最大的元素，否则删除右边的直到左边最大，每次拿到最大的元素即可
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[]{};
        Deque<Integer> window = new ArrayDeque<>();
        int count = 0;
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && window.peekLast() <= i - k) {
                window.pollLast();
            }

            while (!window.isEmpty() && nums[window.peekFirst()] <= nums[i]) {
                window.pollFirst();
            }

            window.offerFirst(i);
            if (i >= k - 1) {
                res[count++] = nums[window.peekLast()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

//        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = {7, 2, 4};
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(ints, 2);
        System.out.println(Arrays.toString(res));
    }
}
