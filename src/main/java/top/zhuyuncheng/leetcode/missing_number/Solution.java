package top.zhuyuncheng.leetcode.missing_number;

/*
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
class Solution {

  /*
   *  SUM(0, n) - SUM(nums)
   */
  public int missingNumber(int[] nums) {
    int sum = 0, n = 0;
    for (int i = 0; i < nums.length; i++) {
      n += i;
      sum += nums[i];
    }
    return (n + nums.length) - sum;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int res = solution.missingNumber(new int[] {0,1,2,3,5,6});
    System.out.println(res);
  }
}
