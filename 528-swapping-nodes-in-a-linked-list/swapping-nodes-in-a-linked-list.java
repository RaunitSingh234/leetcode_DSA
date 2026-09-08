
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int jumps1 = k - 1;

        int len = 0;

        ListNode curr = head;

        while(curr != null) {
            len = len + 1;
            curr = curr.next;
        }

        ListNode n1 = head;
        ListNode n2 = head;
        int counter = 0;

        while(counter < jumps1) {
            counter = counter + 1;
            n1 = n1.next;
        }

        counter = 0;
        int jumps2 = len - k;

        while (counter < jumps2) {
            counter = counter + 1;
            n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
    }
}