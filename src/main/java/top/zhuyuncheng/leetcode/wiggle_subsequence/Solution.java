package top.zhuyuncheng.leetcode.wiggle_subsequence;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * <p>
 * 示例 1:
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 *
 * <p>
 * 进阶:
 * 你能否用 O(n) 时间复杂度完成此题?
 */
class Solution {
    /*
     *  DP矩阵优化空间后
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }

    /*
     *   首先创建一个 [2行 * nums.length列] 的dp矩阵，实现状态转移
     *   1.第一行位于 i 位置，处于上升所能获得的最大摆动子序列长度
     *   2.第二行位于 i 位置，处于下降所能获得的最大摆动子序列长度
     *
     *   转换
     *   1. 当nums[i] > nums[j] && i > j,up[i] = down[j] + 1
     *   2. 当nums[i] < nums[j] && i > j,down[i] = up[j] + 1
     *
     */
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[][] dp = new int[2][nums.length];
        dp[0][0] = dp[1][0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                dp[0][i] = dp[1][i - 1] + 1;
                dp[1][i] = dp[1][i - 1];
            } else if (nums[i] - nums[i - 1] < 0) {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1];
            }
        }

        /*
         * 1, 2, 2, 4, 4, 6
         * 1, 1, 3, 3, 5, 5
         */
//        printMatrix(dp);
        return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
    }

    private void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dp[i].length; j++) {
                sb.append(dp[i][j]).append("\t");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] nums = {1, 7, 4, 9, 2, 5};
        int res = new Solution().wiggleMaxLength(nums);
        System.out.println(res);
    }

}
