package top.zhuyuncheng.leetcode.binary_tree_inorder_traversal;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    /*
     *  迭代算法：左-根-右
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    /**
     *  递归算法：左-根-右
     */
    public void recursionInorderTraversal(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            recursionInorderTraversal(root.left, res);
        }

        res.add(root.val);

        if (root.right != null) {
            recursionInorderTraversal(root.right, res);
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);

        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println("迭代算法：" + list);

        ArrayList<Integer> res = new ArrayList<>();
        solution.recursionInorderTraversal(root, res);
        System.out.println("递归算法：" + res);
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