package top.zhuyuncheng.leetcode.sum_of_two_integers;

/*
 * 不使用运算符 + ​和 - , ​计算两整数a、b​​​​​​​之和。
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
class Solution {

    /*
     *   0 1 0 1
     *   0 0 1 1
     *  ----------
     *   0 1 1 0
     *
     * 上面的如果看成传统的加法，就是1+1=2，进1得0，但是这里没有显示进位出来，仅是相加，0+1或者是1+0都不用进位
     *
     *   0 1 0 1
     *   0 0 1 1
     *  -----------
     *   0 0 0 1
     * 上面的最低位1和1相与得1，而在二进制加法中，这里1+1也应该是要进位的，所以刚好吻合，但是这个进位1应该要再往前一位，所以左移一位
     * 经过上面这两步，如果进位不等于0，那么就是说还要把进位给加上去，所以用了尾递归，一直递归到进位是0
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(2, 3));
    }
}
