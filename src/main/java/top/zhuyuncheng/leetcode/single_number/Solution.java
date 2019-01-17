package top.zhuyuncheng.leetcode.single_number;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
class Solution {
    /*
     *  这个题的思路很简单，如果使用额外空间的情况下，考虑Map，value统计出现的频次即可
     *
     *  如果不使用额外空间的情况下，0 ^ N = N, N ^ N = 0， N ^ M ^N = M 所有最后res中必定是出现了一次的元素。
     */
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 1};
        int[] nums = {4, 1, 2, 1, 2};
        int number = new Solution().singleNumber(nums);
        System.out.println(number);
    }

}