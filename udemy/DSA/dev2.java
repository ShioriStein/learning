package udemy.DSA;


import java.util.Stack;

public class dev2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void reorderList(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> st = new Stack<>();
        while (curr != null) {
            st.push(curr);
            curr = curr.next;
        }

        curr = head;
        while (!st.isEmpty()) {
            ListNode lastItem = st.pop();
            if ((lastItem == curr || curr.next == lastItem)) {
                lastItem.next = null;
                return;
            }

            ListNode nextNode = curr.next;
            if (lastItem != null) {
                curr.next = lastItem;
                lastItem.next = nextNode;
            }

            curr = nextNode;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
