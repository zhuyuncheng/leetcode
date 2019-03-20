package top.zhuyuncheng.leetcode.find_the_duplicate_number;

/*
 * [287] 寻找重复数
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/description/
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和
 * n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n^2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
¬ */
class Solution {
    /*
     *  首先这个数组是有一定规则的, 数组中的元素的值取值范围是 [1, nums.length], 无序且只有一个重复的数字
     *  这个情况下我们可以把该数组抽象成一个环形链表，采用快慢指针的方式，每次得到的元素作为下标再次遍历，
     *  找到区间以后，fast = 0 即是[slow, fast]之间存在环，而环的切入点就是重复元素
     */
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int slow = nums[0], fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int duplicate = new Solution().findDuplicate(new int[]{4, 1, 2, 3, 1});
        System.out.println(duplicate);
    }
}
