package top.zhuyuncheng.leetcode.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    /*
    * 迭代算法：左-右-根
    *
    * 二叉树的后序遍历比较麻烦，主要是通过双栈的方式，用第一个栈遍历二叉树，压入第二个栈，然后有序出栈即是后续遍历
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root != null) {
            stack1.push(root);
        }

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }

    /*
     * 递归算法：左-右-根
     */
    public void recursionPostorderTraversal(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            recursionPostorderTraversal(root.left, res);
        }

        if (root.right != null) {
            recursionPostorderTraversal(root.right, res);
        }
        res.add(root.val);
    }

    public static void main(String[] args) {
        Solution.TreeNode node3 = new Solution.TreeNode(3);
        Solution.TreeNode node2 = new Solution.TreeNode(2, node3, null);
        Solution.TreeNode root = new Solution.TreeNode(1, null, node2);

        Solution solution = new Solution();
        List<Integer> list = solution.postorderTraversal(root);
        System.out.println("迭代算法：" + list);

        ArrayList<Integer> res = new ArrayList<>();
        solution.recursionPostorderTraversal(root, res);
        System.out.println("递归算法：" + res);
    }

    public static class TreeNode {
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
