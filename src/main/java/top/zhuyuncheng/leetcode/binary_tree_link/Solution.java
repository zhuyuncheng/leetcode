package top.zhuyuncheng.leetcode.binary_tree_link;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给一颗二叉树：
 *       10
 *      /   \
 *     8     12
 *    / \      /\
 *   4  6    6   2
 *  /
 * 2
 * 从根节点遍历到叶子节点，给出数字和等于打印出24的链路
 * 例如：
 * 10 8 4 2
 * 10 8 6
 * 10 12 2
 */
class Solution {

    public void printNode(Node node) {
        Deque<Integer> deque = new ArrayDeque<>();

        printNode(node, deque);
    }

    public void printNode(Node node, Deque<Integer> prefix) {
        boolean isNext = false;
        prefix.add(node.data);

        if (node.left != null) {
            isNext = true;
            printNode(node.left, prefix);
        }

        if (node.right != null) {
            isNext = true;
            printNode(node.right, prefix);
        }

        if (!isNext && prefix.stream().reduce(0, Integer::sum) == 24) {
            prefix.stream().map(e -> e + " ").forEach(System.out::print);
            System.out.println();
        }
        prefix.removeLast();
    }


    public static void main(String[] args) {
        Node l2 = new Node(2, null, null);
        Node l4 = new Node(4, l2, null);
        Node l6 = new Node(6, null, null);
        Node r11 = new Node(11, null, null);
        Node r14 = new Node(14, null, null);
        Node l8 = new Node(8, l4, l6);
        Node r12 = new Node(12, r11, r14);
        Node root = new Node(10, l8, r12);

        new Solution().printNode(root);

    }


    private static class Node {
        Node left;
        Node right;
        Integer data;

        Node(Integer data, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

    }
}
