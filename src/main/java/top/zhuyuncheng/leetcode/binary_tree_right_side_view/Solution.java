package top.zhuyuncheng.leetcode.binary_tree_right_side_view;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * <p>
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 *
 * <p>
 * 解释:
 *     1          <---
 *   /   \
 *  2     3       <---
 *   \     \
 *    5     4     <---
 */
class Solution {
    /*
    * 首先是一个二叉树从右到左的层级遍历，以下树为例，从右到左层级遍历为[1，3，2，4], 但是从二叉树的右侧视角看可以看到[1, 3, 4]，无法看到[2]
    * 所以我们在层级遍历的时候需要将[2]忽略掉，按层遍历第一层while循环保存数据，第二个while循环 conut/deque.size() <= 2
    * 遇到[2, 3]队列的时候，将[3]保存进结果集，[2]元素在第二层while循环中忽略掉，并将[2]元素的子元素[4]传递到下次遍历中
    *
    *       1
    *      / \
    *     2   3
    *    /
    *   4
    *
    */
    List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int conut = deque.size();
            TreeNode node = deque.peek();
            res.add(node.val);
            while (conut > 0) {
                node = deque.poll();
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                conut--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*
         *       1
         *      / \
         *     2   3
         *    /
         *   4
         */
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode root = new TreeNode(1, node2, node3);

        List<Integer> list = new Solution().rightSideView(root);
        System.out.println(list);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}