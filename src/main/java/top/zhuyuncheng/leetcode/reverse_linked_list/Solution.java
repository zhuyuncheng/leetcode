package top.zhuyuncheng.leetcode.reverse_linked_list;

/**
 * 反转一个单链表。
 *
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
class Solution {

    /*
     *  pre为上一个节点
     *  curr为当前节点
     *  开始将head置为pre节点，head.next置为curr节点
     *
     *  1.首先保存curr.next节点为next, 并将 curr.next 赋值为 pre 上一个节点
     *  2.上一个节点赋值为当前节点
     *  3.当前节点赋值为下一个节点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        head.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /*
     *  递归
     */
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode listNode = reverseListRecursion(head.next);
            head.next.next = head;
            head.next = null;
            return listNode;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.printListNode(head);
        solution.printListNode(solution.reverseList(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.printListNode(solution.reverseListRecursion(head));
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
