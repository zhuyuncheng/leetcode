package top.zhuyuncheng.leetcode.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    /*
     *  迭代算法：根-左-右
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }

        return res;
    }

    /*
     *  递归算法：根-左-右
     */
    public void recursionPreorderTraversal(TreeNode root, ArrayList<Integer> res) {
        res.add(root.val);
        if (root.left != null) {
            recursionPreorderTraversal(root.left, res);
        }
        if (root.right != null) {
            recursionPreorderTraversal(root.right, res);
        }
    }

    public static void main(String[] args) {
        Solution.TreeNode node3 = new Solution.TreeNode(3);
        Solution.TreeNode node2 = new Solution.TreeNode(2, node3, null);
        Solution.TreeNode root = new Solution.TreeNode(1, null, node2);

        Solution solution = new Solution();
        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("迭代算法：" + list);

        ArrayList<Integer> res = new ArrayList<>();
        solution.recursionPreorderTraversal(root, res);
        System.out.println("递归算法：" + res);
    }

    public static class TreeNode {
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
