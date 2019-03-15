package top.zhuyuncheng.leetcode.classification_array;

import java.util.Arrays;
import java.util.Comparator;

/*
 *  给定一个数组，将数组的元素归类
 *  > 0：在数组开始的位置
 *  < 0: 在数组中间位置
 *  = 0: 在数组末尾位置
 *
 *  事例：
 *  输入：
 *  [1, -2, -1, -3, 0, 0, 2, 0, 3]
 *  输出
 *  [3, 2, 1, -3, -2, -1, 0, 0, 0]
 *
 *  解释 3 2 1 可以无序， -3 -2 -1 可以无序
 */
public class Solution {

    /*
     *  首先对数组进行排序，然后交换 小于0和等于0 的元素
     */
    public void classification(Integer[] nums) {

        Arrays.sort(nums, Comparator.reverseOrder());

        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] > 0) {
                i++;
                continue;
            }
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, -2, -1, -3, 0, 0, 2, 0, 3};
        new Solution().classification(nums);
        System.out.println(Arrays.toString(nums));
    }
}
