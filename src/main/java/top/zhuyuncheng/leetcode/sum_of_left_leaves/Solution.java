package top.zhuyuncheng.leetcode.sum_of_left_leaves;

import java.util.Stack;


/*
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
class Solution {

    /*
     *  前序遍历，如果左节点不为null且没有任何子节点，每次累加左节点的值，返回sum
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
                if (root != null && root.left == null && root.right == null)
                    sum += root.val;
            } else {
                root = stack.pop().right;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
