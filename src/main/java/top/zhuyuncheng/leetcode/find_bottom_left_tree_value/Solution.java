package top.zhuyuncheng.leetcode.find_bottom_left_tree_value;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * <p>
 * 示例 1:
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 * 示例 2:
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 输出:
 * 7
 *
 * <p>
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 */
class Solution {

    /*
     *  一个BFS，层遍历，记录到dp矩阵中
     *  最后返回矩阵最后一行的第一个元素
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<List<Integer>> dp = new ArrayList<>();
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = deque.pollLast();
                list.add(node.val);
                if (node.left != null) {
                    deque.push(node.left);
                }
                if (node.right != null) {
                    deque.push(node.right);
                }
                count--;
            }
            dp.add(list);
        }

        return dp.get(dp.size() - 1).get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(2, node1, node3);

        int bottomLeftValue = solution.findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

    static class TreeNode {
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
