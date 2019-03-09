package top.zhuyuncheng.leetcode.happy_number;

import java.util.*;

/*
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
class Solution {

    /*
     * 解法一：
     * 重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1
     * 如果是无限循环的，则数字会在一个周期中重复出现，比如数字11的过程：
     *  1^2 + 1^2 = 2
     *  2^2 = 4
     *  4^2 = 16
     *  1^2 + 6^2 = 37
     *  3^2 + 7^2 = 58
     *  5^2 + 8^2 = 89
     *  8^2 + 9^2 = 145
     *  1^2 + 4^2 + 5^2 = 42
     *  4^2 + 2^2 = 20
     *  2^2 + 0^2 = 4
     *  最后 4 又出现了，这样我们只需要保存一个集合，每次计算的结果放入集合中，每次add之前set.contains()判断是否包含
     *  如果包含则为不快乐数字
     *
     *
     *  解法二：
     *  数字11的过程可能会发现了，有4出现，实际所有的不快乐数字在重复的过程中都会有4出现。那我们就不需要构造Set集合来判断是否包含
     *  只需要每次判断结果是 1 或 4 就退出循环，然后判断n == 1即可
     */
    public boolean isHappy2(int n) {

        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (sum != 1) {
            sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean happy = solution.isHappy2(19);
        System.out.println(happy);
    }
}
