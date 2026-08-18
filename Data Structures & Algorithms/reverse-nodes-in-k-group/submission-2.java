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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cursor = dummy.next;

        int list_size = 0;
        int count = 0;
        int current_group = 0;

        ListNode previous_end = dummy;
        ListNode group_start = null;
        ListNode group_end = null;
        ListNode next_start = null;

        ListNode prev = dummy;

        while (cursor != null){
            cursor = cursor.next;
            list_size += 1;
        }

        int group_total = list_size / k;


        // System.out.println("group_total");
        // System.out.println(group_total);
        cursor = dummy.next;
    

        // ListNode teste = dummy.next;
        //             while (teste != null){
        //                 System.out.print(teste.val);
        //                 teste = teste.next;
        //             }
                    // System.out.println("");

        while (current_group != group_total){
            // System.out.println("cursor val");
            // System.out.println(cursor.val);
            // System.out.println("count");
            // System.out.println(count);
            // System.out.println("current_group");
            // System.out.println(current_group);
            count += 1;
            if(count == 1){
                group_start = cursor;
                prev = cursor;
                cursor = cursor.next;
            }
            else if (count <= k){
                ListNode next = cursor.next;
                cursor.next = prev;
                prev = cursor;
                cursor = next;
                if (count == k){
                    // System.out.println("reached the end of our group");
                    group_end = prev;
                    next_start = cursor;


                    previous_end.next = group_end;
                    previous_end = group_start;

                    group_start.next = next_start;
                    count = 0;
                    current_group += 1;
                    // System.out.println("group_start");
                    // System.out.println(group_start.val);
                    // System.out.println("prev end");
                    // System.out.println(previous_end.val);
                    // System.out.println("next_start");
                    // System.out.println(next_start.val);
                    // System.out.println("group end");
                    // System.out.println(group_end.val);

                    // ListNode test = dummy.next;
                    // while (test != null){
                    //     System.out.print(test.val);
                    //     test = test.next;
                    // }
                    // System.out.println("");
                }
            }
        }
        return dummy.next;

    }
}
