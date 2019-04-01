package top.zhuyuncheng.leetcode.sqrtx;

/*
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 */
class Solution {

  /*
   *  二分法
   */
  public int mySqrt(int x) {
    int left = 1, right = x, mid = (left + right) / 2;
    while (left <= right) {
      if (mid == x / mid) {
        return mid;
      } else if (mid > x / mid) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
      mid = (left + right) / 2;
    }
    return mid;
  }

  public static void main(String[] args) {
    int res = new Solution().mySqrt(8);
    System.out.println(res);
  }
}
