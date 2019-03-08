package top.zhuyuncheng.leetcode.symmetric_tree;
/*
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * ⁠    1
 * ⁠   / \
 * ⁠  2   2
 * ⁠ / \ / \
 * 3  4 4  3
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠ \   \
 * ⁠ 3    3
 * 
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
      return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
      if(left == null && right == null) {
        return true;
      }
      if(left == null || right == null) {
        return false;
      }
      return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
