package top.zhuyuncheng.leetcode.linked_list_components;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 * <p>
 * 示例 1：
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 *
 * <p>
 * 注意:
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 */
class Solution {
    /**
     * 构造一个set用来存储子数组元素用于判断是否存在，遍历链表，主要使用{@link Set#contains(Object)} 方法来快速判断是否存在
     *
     * 设当前节点 node ，如果 node.next 和 node.next.next 都在被set集合包含，说明是一个连续的组件, 继续遍历下一个节点
     * 如果 node.next 包含， 而️ node.next.next 不包含，说明是一个新的组件开始，所以 ans++
     */
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(G).parallel().forEach(set::add);

        int ans = set.contains(head.val) ? 1 : 0;
        ListNode cur = head;
        while (cur.next != null) {
            if (!set.contains(cur.val) && set.contains(cur.next.val)) {
                ans++;
            }
            cur = cur.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        int[] g = {0, 3, 1, 4};
        int i = new Solution().numComponents(head, g);
        System.out.println(i);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
