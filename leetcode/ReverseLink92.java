package leetcode;

import udemy.DSA.ListNode;

public class ReverseLink92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;

        for(int i = 0; i < left - 1; i ++) {
            prev = prev.next;
            cur=cur.next;
        }

        ListNode beforeReverse = prev;
        ListNode reverseFirst = cur;


        for(int i = 0; i < right - left + 1;i++) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }

        beforeReverse.next = prev;
        reverseFirst.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(new ReverseLink92().reverseBetween(n1, 2, 4));

        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }
}
