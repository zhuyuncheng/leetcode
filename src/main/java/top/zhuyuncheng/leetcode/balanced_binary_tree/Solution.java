package top.zhuyuncheng.leetcode.balanced_binary_tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Solution {

    /*
     * 平衡因子：|左子树高度 - 右子树高度| >= 1
     *
     * getHeightRecursion 递归深度遍历，找到node下最深的节点并且 +1
     * 第 1⃣ 2⃣ 种方式 可以直接判断平衡因子是否 >= 1,  Math.abs(right - left) <= 1
     * 第 3⃣ 种方式还需要判断子树的平衡因子， isBalanced(root.left) && isBalanced(root.right)
     *
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeightRecursion(root.left);
        int right = getHeightRecursion(root.right);
        return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeightRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeightRecursion(node.left), getHeightRecursion(node.right)) + 1;
    }

    public static void main(String[] args) {

        /*
         *  1⃣
         *        1
         *       / \
         *      2   2
         *     / \
         *    3   3
         *   / \
         *  4   4
         */
       /* TreeNode nodeL4 = new TreeNode(4);
        TreeNode nodeR4 = new TreeNode(4);
        TreeNode nodeL3 = new TreeNode(3, nodeL4, nodeR4);
        TreeNode nodeR3 = new TreeNode(3);
        TreeNode nodeL2 = new TreeNode(2, nodeL3, nodeR3);
        TreeNode nodeR2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, nodeL2, nodeR2);*/

        /*
         *  2⃣
         *      3
         *     / \
         *    9  20
         *       / \
         *      15  7
         */
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        /*
         *  3⃣
         *         1
         *        / \
         *       2   2
         *      /     \
         *     3       3
         *    /         \
         *   4           4
         */
        /*TreeNode nodeLL4 = new TreeNode(4);
        TreeNode nodeRR4 = new TreeNode(4);
        TreeNode nodeLL3 = new TreeNode(3, nodeLL4, null);
        TreeNode nodeRR3 = new TreeNode(3, null, nodeRR4);
        TreeNode nodeL2 = new TreeNode(2, nodeLL3, null);
        TreeNode nodeR2 = new TreeNode(2, null, nodeRR3);
        TreeNode root = new TreeNode(1, nodeL2, nodeR2);*/

        boolean isBalanced = new Solution().isBalanced(root);
        System.out.println(isBalanced);
    }

    public static class TreeNode {
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
