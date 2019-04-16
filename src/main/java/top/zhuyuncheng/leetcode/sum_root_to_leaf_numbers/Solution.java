package top.zhuyuncheng.leetcode.sum_root_to_leaf_numbers;
/*
 * [129] 求根到叶子节点数字之和
 *
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/description/
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 * ⁠   4
 * ⁠  / \
 * ⁠ 9   0
 * / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    /*
     *  递归深度遍历树的所有路径，拼接路径中的val，保存到List中，最后List求和
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> nodeList = new ArrayList<>();
        sumNumbers(root, nodeList, root.val + "");
        return nodeList.stream().reduce(Integer::sum).get();
    }

    private void sumNumbers(TreeNode node, List<Integer> nodeList, String str) {
        if (node.left == null && node.right == null) {
            nodeList.add(Integer.valueOf(str));
        }

        if (node.left != null) {
            sumNumbers(node.left, nodeList, str + node.left.val);
        }

        if (node.right != null) {
            sumNumbers(node.right, nodeList, str + node.right.val);
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);
        Solution soltion = new Solution();
        int res = soltion.sumNumbers(root);
        System.out.println(res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
