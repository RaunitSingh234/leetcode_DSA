class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr1 = head;
        ListNode curr2 = head.next;

        ListNode temp1 = curr2;

        while(curr2 != null && curr2.next != null) {
            curr1.next = curr2.next;
            curr1 = curr1.next;
            curr2.next = curr1.next;
            curr2 = curr2.next;
        }

        curr1.next = temp1;

        return head;
    }
}