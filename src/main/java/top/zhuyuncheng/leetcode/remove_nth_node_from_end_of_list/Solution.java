package top.zhuyuncheng.leetcode.remove_nth_node_from_end_of_list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
class Solution {
    /*
     * 双指针的思想，首先找到pre和post之间的距离，
     * 然后pre和post平移，当post到达最后一个节点的时候，pre.next也就是要删除的节点
     *
     * 举例说明：
     * 1 -> 2 -> 3 -> 4 -> 5  删除倒数第四个( n = 4 ) 即：1 -> 3 -> 4 -> 5
     * post定位到 4 位置，pre在 1 位置，post和pre同时移动
     * post.next == null 时 pre.next = pre.next.next
     * 时间复杂度正好为一次扫描 O(4) + O(1) = O(n)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode post = head;
        for (int i = 0; i < n; i++) {
            post = post.next;
        }
        if (post == null) {
            return head.next;
        }
        while (post.next != null) {
            post = post.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = new Solution().removeNthFromEnd(head, 4);
        System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
