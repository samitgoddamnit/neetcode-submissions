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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        System.out.println(k);
        boolean all_not_null = true;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        do{
            int minimum = 10001;
            int min_index = -1;
            for (int i = 0; i < k; i++){
                if(lists[i] != null){
                    if (lists[i].val < minimum){
                        minimum = lists[i].val;
                        min_index = i;
                    }
                }
            }
            
            if (minimum == 10001){
                all_not_null = false;
            }else{
                cursor.next = lists[min_index];
                lists[min_index] = lists[min_index].next;
                cursor = cursor.next;
            }
        }while(all_not_null);
        return dummy.next;
    }
}
