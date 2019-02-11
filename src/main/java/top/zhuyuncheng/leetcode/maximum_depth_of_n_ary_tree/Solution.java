package top.zhuyuncheng.leetcode.maximum_depth_of_n_ary_tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * <p>
 * 例如，给定一个 3叉树 :
 *        1
 *      / | \
 *     3  2  4
 *    / \
 *   5   6
 * 我们应返回其最大深度，3。
 *
 * <p>
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
class Solution {

    /*
     *  层遍历更好理解一些，一层就 depth + 1, 直到遍历完最后一层为止
     *  第二层while是将一层 add 进队列,每次 add 一个node节点下的所有的children
     */
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            while (count > 0) {
                Node node = deque.pop();
                if (node.children != null) {
                    deque.addAll(node.children);
                }
                count--;
            }
            depth++;
        }
        return depth;
    }

    /*
     *  递归的方式超时，leetcode构建的树太过于复杂，懒得追究复现了，但是逻辑是没问题的，跟二叉树的最大深度类似
     *
     */
    public int maxDepthRecursion(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        if (root.children != null) {
            for (Node node : root.children) {
                depth = Math.max(depth, maxDepthRecursion(node));
            }
        }
        return depth + 1;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node root = new Node(1, Arrays.asList(node3, node2, node4));

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
