package top.zhuyuncheng.leetcode.jump_game;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
class Solution {

    /**
     * max 变量记录当前可以跳到的最大位置
     * 如果 max >= size 说明已经到达了最后的点，return true
     * 如果 max < i 表示无法到达i的位置 return  false
     */
    public boolean canJump(int[] nums) {
        int length = nums.length, size = length - 1;
        // max是维护的当前能跳到的最大位置
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (max < i || max >= size) {
                break;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= size;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean canJump = new Solution().canJump(nums);
        System.out.println(canJump);
    }
}
