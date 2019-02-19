package top.zhuyuncheng.leetcode.merge_two_sorted_lists;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class Solution {
    /*
     *  递归的方式每次对比两个链表的head节点，小的连接到head.next下
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if (l1 == null) {
           return l2;
       }
       if (l2 == null) {
           return l1;
       }
       ListNode head = null;
       if (l1.val < l2.val) {
           head = l1;
           head.next = mergeTwoLists(l1.next, l2);
       } else {
           head = l2;
           head.next = mergeTwoLists(l1, l2.next);
       }
       return head;
    }

    public static void main(String[] args) {
        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(4);

        ListNode listB = new ListNode(1);
        listB.next = new ListNode(3);
        listB.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(listA, listB);
        System.out.println(listNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                sb.append(node.val);
                sb.append(" ");
                node = node.next;
            }
            return sb.toString();
        }
    }
}
