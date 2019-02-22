package top.zhuyuncheng.leetcode.invert_binary_tree_ii;

/**
 *     A     |       A
 *    / \    |      / \
 *   B   C   |     C   B
 *  / \      |        / \
 * D  E      |       E   D
 *
 * 镜像二叉树的升级
 * 给定一个 完全二叉树 中序遍历 的字符串 "ABCDE##"
 * 返回该二叉树的镜像并输出为字符串 "ACB##ED"
 *
 * 示例：
 * 输入："ABCDEFGH#I#G##K"
 * 输出："ACBGFEDK##G#I#H"
 */
public class Solution {

    /*
     *  因为是二叉树的层级遍历，而且是完全二叉树，所以我们只需要遍历二叉树的每一层，然后每层倒顺序输出
     *  又因为这是一个字符串，完全无需构建树，根据完全二叉树的特性，计算并遍历字符串即可
     *  二叉树的节点总数 = 2 ^ N - 1，已知二叉树的节点总数 tree.length()，求二叉树的层 = log(length + 1) / log(2)
     *  每层的节点数 = 2 ^ i [0, N]
     */
    public String invertTree(String tree) {
        int length = tree.length();
        int n = (int) (Math.log(length + 1) / Math.log(2));
        StringBuilder builder = new StringBuilder();

        for (int end, i = 0, start = 0; i < n; i++) {
            end = start + (int) Math.pow(2, i);
            String substring = tree.substring(start, end);
            builder.append(getStr(substring));
            start = end;
        }
        return builder.toString();
    }

    public String getStr(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String reverseTree = solution.invertTree("ABCDEFGH#I#G##K");
        System.out.println(reverseTree);
    }
}
