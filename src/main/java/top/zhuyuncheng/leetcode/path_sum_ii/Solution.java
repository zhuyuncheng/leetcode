package top.zhuyuncheng.leetcode.path_sum_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 返回:
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 */
class Solution {

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> nodeList) {
        if (root == null) {
            return;
        }
        nodeList.add(root.val);

        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(nodeList));
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, res, nodeList);
            nodeList.remove(nodeList.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, res, nodeList);
            nodeList.remove(nodeList.size() - 1);
        }
    }

    /*
     *  这个主要是一个DFS，同时携带两个列表，res列表保存结果集，nodeList列表保存每一条链路，
     *  因为递归的方式，nodeList列表每次都会记录一个节点，减法操作每次剪到0 即满足条件保存进res列表
     *  无论如何都要删除最后一个节点，继续另外一个节点的计算
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nodeList = new ArrayList<>();
        dfs(root, sum, res, nodeList);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        TreeNode node11 = new TreeNode(node7, node2, 11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4R = new TreeNode(node5, node1, 4);

        TreeNode node4L = new TreeNode(node11, null, 4);
        TreeNode node8 = new TreeNode(node13, node4R, 8);

        TreeNode root = new TreeNode(node4L, node8, 5);

        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, 22));
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
