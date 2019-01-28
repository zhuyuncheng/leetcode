package top.zhuyuncheng.leetcode.find_largest_value_in_each_tree_row;

import java.util.*;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 输入:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                size--;
            }
            res.add(Collections.max(list));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node33 = new TreeNode(3, node5, node3);
        TreeNode node2 = new TreeNode(2, null, node9);
        TreeNode root = new TreeNode(1, node33, node2);


        List<Integer> res = new Solution().largestValues(root);
        System.out.println(res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
