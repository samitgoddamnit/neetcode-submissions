// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//     pub val: i32,
//     pub next: *mut ListNode,
// }
//
// impl ListNode {
//     #[inline]
//     pub fn new(val: i32) -> Self {
//         ListNode { next: std::ptr::null_mut(), val }
//     }
// }

impl Solution {
    pub fn has_cycle(head: *mut ListNode) -> bool {
        unsafe{
            let mut set: HashSet<*mut ListNode> = HashSet::new();
            let mut node = head;
            loop{
                if set.contains(&node){
                    return true;
                }
                else if node.is_null(){
                    return false;
                }
                else{
                    set.insert(node);
                    node = (*node).next;
                }
            }
        }
        return false;
    }
}
