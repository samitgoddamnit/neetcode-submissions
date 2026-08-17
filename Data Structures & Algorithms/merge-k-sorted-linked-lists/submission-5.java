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
        //wrote the iterative solution originally, going to implement the min-heap solution.
        int k = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        PriorityQueue<ListNode> min_heap = new PriorityQueue<ListNode>(
            (a,b) -> a.val - b.val
        );

        for (int i = 0; i < k; i++){
            min_heap.add(lists[i]);
        }
        
        while(!min_heap.isEmpty()){
            ListNode node = min_heap.poll();
            cursor.next = node;
            if(node.next != null){
                min_heap.add(node.next);
            }
            cursor = cursor.next;
        }

        return dummy.next;
    }
}
