package top.zhuyuncheng.leetcode.longest_valid_parentheses;

import java.util.Stack;

/*
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
class Solution {

    public int longestValidParentheses(String s) {
        int count = 0, start = 0;
        Stack<Integer> stack = new Stack<>(); // 下标栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                start = i + 1;
            } else {
                stack.pop();
                count = stack.isEmpty() ? Math.max(count, i - start + 1) : Math.max(count, i - stack.peek());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestValidParentheses("()()(()");
        System.out.println(res);
    }
}
