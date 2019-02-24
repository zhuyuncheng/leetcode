package top.zhuyuncheng.leetcode.nim_game;

/**
 * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * <p>
 * 示例:
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */
class Solution {

    /*
     *  必须保证我自己拿了之后，还剩4个或者4的倍数，才会赢，否则永远会输
     *  所以有以下公式：(n - 1) % 4 == 0 || (n - 2) % 4 == 0 || (n - 3) % 4 == 0
     *  但是 (n - m) % 4 == 0 // 以下 m 代表我拿的石头[1, 2, 3]
     *  推出如下公式：n % 4 - m % 4 == 0 , n % 4 == m % 4 , 可得到 m % 4 永远是 1 / 2 / 3， 也就是不等于0，或者大于0，且小于4
     *
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canWinNim(4));
    }
}
