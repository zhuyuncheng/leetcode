package top.zhuyuncheng.leetcode.linked_list_cycle;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class Solution {
    /*
     *  双指针：
     *  第一个指针每次走一步， 第二个指针每次走两步，
     *  当指针A == 指针B的时候存在环形链表
     */
    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while (a != null && b != null) {
            if ((a = a.next) == null || b.next == null || (b = b.next.next) == null) {
                return false;
            }

            if (a == b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(3);
        head.next = node2;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = node2;
        boolean isCycle = new Solution().hasCycle(head);
        System.out.println(isCycle);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}