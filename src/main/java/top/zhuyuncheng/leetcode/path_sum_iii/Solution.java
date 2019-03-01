package top.zhuyuncheng.leetcode.path_sum_iii;

/*
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
class Solution {

    /*
     * 遍历所有节点，每个节点再次遍历一次，通过减法的方式，判断是否等于 0，如果等于 0 则 count++
     */
    private int dfs(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (sum == root.val) {
            count++;
        }

        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode nodeL3 = new TreeNode(3);
        TreeNode nodeR_2 = new TreeNode(-2);
        TreeNode nodeR1 = new TreeNode(1);

        TreeNode nodeLL3 = new TreeNode(nodeL3, nodeR_2, 3);
        TreeNode nodeR2 = new TreeNode(null, nodeR1, 2);
        TreeNode nodeR11 = new TreeNode(11);

        TreeNode nodeL5 = new TreeNode(nodeLL3, nodeR2, 5);
        TreeNode nodeR_3 = new TreeNode(null, nodeR11, -3);

        TreeNode root = new TreeNode(nodeL5, nodeR_3, 10);
        Solution solution = new Solution();
        int count = solution.pathSum(root, 8);
        System.out.println(count);
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
