package top.zhuyuncheng.leetcode.valid_parentheses;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    // 建立映射： 避免大量的if...else..
    private static final Map<Character, Character> MAPPING = new HashMap<Character, Character>() {{
        put('}', '{');
        put(']', '[');
        put(')', '(');
    }};

    /**
     * 定义一个堆栈，当遇到 左括号的时候入占，遇到右括号的时候，对比匹配出栈，如果出现栈为空或者不匹配的情况则返回false
     * 最后判断栈是否为空
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (MAPPING.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != MAPPING.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isValid(")"));

    }
}
