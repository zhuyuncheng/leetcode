package top.zhuyuncheng.leetcode.search_a_2d_matrix;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
class Solution {
    /*
     *   二维数组且有序
     *   二分查找的变种，将二维数组作为一维来理解，每次二分
     *
     *   知识点在于如何准确的定位下标， 例如：target = 30
     *   第一次 min = 5, 11 < 30, start = 6, end = 11
     *   第二次 min = 8, 8 / 4 = 2, 8 % 4 = 0, 下标定位到 matrix[2][0] = 23 < 30 依此类推
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length, start = 0, end = row * col - 1;

        while (start <= end) {
            int min = start + (end - start) / 2;
            if (matrix[min / col][min % col] > target) {
                end = min - 1;
            } else if (matrix[min / col][min % col] < target) {
                start = min + 1;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        boolean b = new Solution().searchMatrix(matrix, 30);
        System.out.println(b);
    }
}
