package top.zhuyuncheng.leetcode.flatten_binary_tree_to_linked_list;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 核心就是将左节点left变成当前节点的右节点right，原来的右节点right，放到当前右节点left 2 right的最后一个右节点right
     * root.right = root.right
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode right = root.right; // 记录右节点
            root.right = root.left;
            root.left = null;
            TreeNode node = root.right; // 找到交换后右节点的最后一个右节点
            while (node.right != null) {
                node = node.right;
            }
            node.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode root = new TreeNode(1, node2, node5);

        Solution solution = new Solution();
        solution.flatten(root);
        System.out.println(root);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
