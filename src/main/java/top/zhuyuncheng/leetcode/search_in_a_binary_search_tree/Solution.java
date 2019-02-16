package top.zhuyuncheng.leetcode.search_in_a_binary_search_tree;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * <p>
 * 例如:
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 */
class Solution {

    /*
    * 非递归
    * 简单的二分查找
    * root.val > val : 在root的左边
    * root.val < val : 在root的右边
    * root.val == val: 查找到该节点
    *
    */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;

        while(node != null) {
            if(val < node.val) {
                node = node.left;
            } else if(val > node.val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /*
     * 递归
     *
     */
    public TreeNode searchBSTRecursion(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
