package top.zhuyuncheng.leetcode.min_cost_climbing_stairs;

/**
 * 使用最小花费爬楼梯
 *
 * <p>
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * <p>
 * 示例 1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * 示例 2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * <p>
 * 注意：
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
class Solution {

    /*
     *                 __| top: 登顶
     *               __|   6 -> 20
     *             __|     5 -> 10
     *           __|       4 -> 2
     *         __|         3 -> 1
     *       __|           2 -> 20
     *     __|             1 -> 40
     *   __|               0 -> 10
     *
     *   首先这道题描述的真鸡儿辣鸡，开始完全看不懂什么意思
     *
     *   数组的索引为台阶，数组索引对应的元素为消耗的体力值，
     *   上台阶可以上一阶也可以上两阶，上两阶时跨过的那一阶不花费体力，最后两阶（n, n-1）都可以直接登顶
     *
     *   cost 的长度将会在 [2, 1000]
     *   要上一阶还是上两阶需要根据第三阶的体力值来计算出花费体力最少的方案，固有以下公式：
     *   const[N] = min(const[N] + cons[N-1], const[N] + cons[N-2])
     *
     */
    int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i] + cost[i - 1], cost[i] + cost[i - 2]);
        }

        // [10, 40, 30, 31, 32, 41, 52]
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] costArray = {10, 40, 20, 1, 2, 10, 20};
//        int[] costArray = {1, 0, 1, 1};
//        int[] costArray = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] costArray = {10, 15, 20};
        int min = new Solution().minCostClimbingStairs(costArray);
        System.out.println(min);

    }
}