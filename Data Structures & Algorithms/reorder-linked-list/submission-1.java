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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //slow is now the middle ! you need the stuff after the middle in 
        //reverse order, while the fast stuff in regular order.
        ListNode rev = prev;
        ListNode norm = head;

        //need to make the final list now !

        // while(norm != null){
        //     norm = norm.next;
        // }

        // System.out.println("");
        // ListNode temp = rev;
        // while(temp != null){
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }

        int index = 0;
        ListNode tmp = null;
        while (norm.next != null){
            // System.out.println("norm sequence value is "+ norm.val);
            // System.out.println("reversed sequence value is " +rev.val);
            if (index % 2 == 0){
              tmp = norm.next;
              norm.next = rev;
              rev = rev.next;
              norm = norm.next;
              index += 1;
              //need to add from rev
            }
            else{
              norm.next = tmp;
              norm = norm.next;
              index += 1;
            }
        }
    }   
}