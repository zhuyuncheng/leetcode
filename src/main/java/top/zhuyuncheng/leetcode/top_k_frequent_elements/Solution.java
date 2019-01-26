package top.zhuyuncheng.leetcode.top_k_frequent_elements;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * <p>
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历 nums 在 map 中记录出现频率
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        // 优先级队列(最小堆)，堆顶元素永远最小, PS: 代码中使用到了JDK8的方法引用 ，推荐Java流式编程
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (queue.size() < k) { // 初始化堆
                queue.add(key);
            } else {
                if (map.get(key) > map.get(queue.peek())) { // 比较堆顶与哈希表中的元素，小则出堆，将比堆顶大的插入堆中
                    queue.poll();
                    queue.add(key);
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        Solution solution = new Solution();
        List<Integer> res = solution.topKFrequent(nums, 2);
        System.out.println(res);
    }
}
