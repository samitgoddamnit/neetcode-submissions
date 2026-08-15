/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (l1 != null || l2 != null || carry != 0){
            int value1 = 0;
            int value2 = 0;

            if (l1 != null){
                value1 = l1.val;
            }
            if (l2 != null){
                value2 = l2.val;
            }

            int sum = value1 + value2 + carry;
            if (sum >= 10){
                sum = sum - 10;
                carry = 1;
            }
            else{
                carry = 0;
            }

            result.next = new ListNode(sum);
            result = result.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        return dummy.next;

    }
}
