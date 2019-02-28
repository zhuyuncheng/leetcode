package top.zhuyuncheng.leetcode.path_sum;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
class Solution {

    /*
     *  这个题目只要有一跳路径和为22 即为true
     *  所以递归减法的方式如果 == 0 就 return true
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode( node7, node2, 11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4R = new TreeNode(null, node1, 4);
        TreeNode node4L = new TreeNode(node11, null, 4);
        TreeNode node8 = new TreeNode(node13, node4R, 8);
        TreeNode root = new TreeNode(node4L, node8, 5);
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root, 22));
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
