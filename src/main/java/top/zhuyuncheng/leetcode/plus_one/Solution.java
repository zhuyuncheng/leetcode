package top.zhuyuncheng.leetcode.plus_one;

import java.util.Arrays;

/*
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
class Solution {


    /**
     *  这个题目要考虑进位的问题，倒序遍历，[digits.length - 1] + 1，考虑是否需要进位，如果需要进位，则在[digits.length - 2] + 1, 以此类推
     *  最后还有一个需要注意的点就是[9, 9, 9, 9], 最后进位会出现数组扩容的情况，这时候只需初始化一个new int[digits.length + 1] 数组，[0] = 1，其余位置均为 0
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        int[] ints = new Solution().plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }
}
