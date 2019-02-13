package top.zhuyuncheng.leetcode.average_of_levels_in_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * <p>
 * 示例 1:
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 *
 * <p>
 * 注意：
 * 节点值的范围在32位有符号整数范围内。
 */
class Solution {

    /**
     *  BFS
     *  divisor是被除数， count一层的节点数， sum一层的总和
     *  每层平均数：sum / divisor
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int divisor = deque.size(), count = deque.size();
            double sum = 0;
            while (count-- > 0) {
                TreeNode node = deque.pop();
                sum += node.val;
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }

            res.add(sum / divisor);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        Solution solution = new Solution();
        List<Double> res = solution.averageOfLevels(root);
        System.out.println(res);
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
