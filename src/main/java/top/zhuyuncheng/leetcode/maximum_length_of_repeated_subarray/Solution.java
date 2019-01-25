package top.zhuyuncheng.leetcode.maximum_length_of_repeated_subarray;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * <p>
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * <p>
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
class Solution {
    /*
     *  这个问题是动态规划的思想，通过new一个DP矩阵，实现状态的转移
     *
     *  DP矩阵中元素 dp[i][j] 初始化为0，如果有重复项就 dp[i][j] = dp[i - 1][j - 1] + 1
     *
     *  第一个for循环是初始化矩阵的第一行和第一列
     *  第二for循环是填充矩阵其他的格子
     *  最后 Math.max(res, dp[i][j])，遍历得到每次最大值
     *
     *  PS：矩阵具体的样子可见 printMatrix(dp) 方法
     */
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int res = 0;

        for (int i = 0; i < dp[0].length; i++) {
            // 初始化DP矩阵第一行
            dp[0][i] = A[0] == B[i] ? 1 : 0;
            // 初始化DP矩阵第一列
            dp[i][0] = A[i] == B[0] ? 1 : 0;
        }

        // 从第一行/第一列开始
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }

//        printMatrix(dp);
        return res;
    }

    private void printMatrix(int[][] dp) {
        /*
         *  0	0	1	0	0
         *  0	1	0	0	0
         *  1	0	0	0	0
         *  0	2	0	0	0
         *  0	0	3	0	0
         */
        for (int i = 0; i < dp.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dp[i].length; j++) {
                sb.append(dp[i][j]).append("\t");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};

        int length = new Solution().findLength(A, B);
        System.out.println(length);
    }
}