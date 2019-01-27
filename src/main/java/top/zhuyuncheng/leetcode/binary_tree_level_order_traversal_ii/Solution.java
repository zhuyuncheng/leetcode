package top.zhuyuncheng.leetcode.binary_tree_level_order_traversal_ii;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 *     3
 *    / \
 *   9  20
 *  /    \
 * 15    7
 * 返回其自底向上的层次遍历为：
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<List<Integer>> stack = new Stack<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int count = deque.size();
            while (count > 0) {
                TreeNode node = deque.poll();
                row.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                count--;
            }
            stack.push(row);
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node7, null);
        TreeNode node9 = new TreeNode(9, node15, null);
        TreeNode root = new TreeNode(3, node9, node20);
        List<List<Integer>> lists = new Solution().levelOrderBottom(root);
        System.out.println(lists);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
