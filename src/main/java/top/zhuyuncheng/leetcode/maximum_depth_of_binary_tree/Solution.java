package top.zhuyuncheng.leetcode.maximum_depth_of_binary_tree;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
class Solution {
    /*
    * 递归深度遍历节点，返回 Math.max(left, right) + 1 的深度
    */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15);
        TreeNode r7 = new TreeNode(7);
        TreeNode l9 = new TreeNode(9);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);

        int maxDepth = new Solution().maxDepth(root);
        System.out.println(maxDepth);
    }
}


class TreeNode {
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
