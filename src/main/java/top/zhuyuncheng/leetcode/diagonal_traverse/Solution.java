package top.zhuyuncheng.leetcode.diagonal_traverse;

import java.util.Arrays;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * <p>
 * 示例:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * <p>
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000。
 */
public class Solution {

    /*
    *
    * 首先将二维数组以坐标的形式标示出来，rowIndex_colIndex，总结规律如下：
    * 1、奇数往下走，偶数往上走
    * 2、第一行，向右移动一列(0_0 -> 0_1)；第一列，向下移动一行(1_0 -> 2_0)
    * 3、最后一行，向右移动一列(2_1 -> 2_2)；最后一列，向下移动一行(0_2 -> 1_2)
    * 4、右上移动(2_0 -> 1_1 -> 0_2)[r--, c++]; 左下移动(0_1 -> 1_0)(1_2 -> 2_1)[r++, c--]
    *
    * {
    *   0_0, 0_1, 0_2,
    *   1_0, 1_1, 1_2,
    *   2_0, 2_1, 2_2,
    * }
    */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];

        for (int i = 0, r = 0, c = 0; i < res.length; i++) {
            res[i] = matrix[r][c];

            // 奇数往下走，偶数往上走
            if ((r + c) % 2 == 0) {
                if (c == col - 1) { // 最后一列， 向下移动一行
                    r++;
                } else if (r == 0) { // 第一行，向右移动一列
                    c++;
                } else {  // 向右上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) { // 最后一行， 向右移动一列
                    c++;
                } else if (c == 0) { // 第一列，向下移动一行
                    r++;
                } else { // 向左下移动
                    r++;
                    c--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonalOrder = new Solution().findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(diagonalOrder));

    }
}
