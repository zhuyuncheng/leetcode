package top.zhuyuncheng.leetcode.binary_tree_level_order_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
class Solution {

    /*
    *   二叉树的层遍历，横向遍历，需要使用队列，将下一次需要遍历的数据放入队列，依次出队列，然后保存结果
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty())   {
            List<Integer> list = new ArrayList<>();
            int count = deque.size();
            while (count > 0) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node20.left = node15;
        node20.right = node7;
        root.left = node9;
        root.right = node20;

        Solution solution = new Solution();

        System.out.println(solution.levelOrder(root));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
