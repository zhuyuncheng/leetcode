package top.zhuyuncheng.leetcode.reverse_linked_list_ii;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
class Solution {
    /*
     * 本题思想是将m,n中间的链表遍历，同时计数
     * 3放在2前面，1-3-2-4-5
     * 然后4放在3前面，1-4-3-2-5
     * 当计数到了，结束循环
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(0);
        // 头结点，方便统一处理
        first.next = head;

        ListNode temp = null;
        ListNode p = null;
        ListNode pHead = first; // 不需要反转的最后一个节点
        ListNode pLast = null; // 要反转节点的第一个节点，将反转到最后

        int len = 0;
        while (head != null) {
            if (++len < m) {
                pHead = head; // 记录未变动的节点末尾值，如例题中的1
                head = head.next;
            } else if (len == m) {

                p = pLast = head; // 记录开始位置
                head = head.next;
                pLast.next = null;// 截断之后的连接
            } else if (len >= m && len <= n) {
                //新插入节点
                temp = head;
                head = head.next;
                temp.next = p;
                p = temp;
                pHead.next = p;
            } else if (len > n) {
                pLast.next = head; // 将已交换的链表连接上不需交换的末尾，如本例5
                break;
            }
        }

        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.printListNode(solution.reverseBetween(head, 2, 4));
    }

    private void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
