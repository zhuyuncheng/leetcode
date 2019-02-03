package top.zhuyuncheng.leetcode.binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
class Solution {

    /*
     *  当一个节点的左右子树都为空时,把从根节点到该节点的路径保存在向量中,找到所有的叶子节点就完成了对所有路径的保存
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        addList(root, res, root.val + "");
        return res;
    }

    public void addList(TreeNode node, List<String> res, String paths) {
        if(node.left == null && node.right == null) {
            res.add(paths);
            return;
        }
        if (node.left != null) {
            addList(node.left, res, paths + "->" + node.left.val);
        }
        if (node.right != null) {
            addList(node.right, res, paths + "->" + node.right.val);
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);
        List<String> res = new Solution().binaryTreePaths(root);
        System.out.println(res);
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
