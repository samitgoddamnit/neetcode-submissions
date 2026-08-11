// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//     pub val: i32,
//     pub next: Option<Box<ListNode>>,
// }
//
// impl ListNode {
//     #[inline]
//     pub fn new(val: i32) -> Self {
//         ListNode { next: None, val }
//     }
// }

impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut cursor = head.as_ref();
        let mut length = 0;
        while let Some(node) = cursor{
          length += 1;
          cursor = node.next.as_ref();
        }

        let target = length - n;


        let mut index = 0;
        let mut tmp = Box::new(ListNode::new(0));
        tmp.next = head;
        // println!("{:?}",tmp);
        let mut dummy = Some(tmp);
        let mut previous = dummy.as_mut();
        // cursor = dummy.as_ref().unwrap().next.as_ref();

        // println!("{:?}",previous);
        // println!("{:?}",cursor);
      

        while let Some(node) = previous{ 
          // println!("loop {}",index);
          // println!("{:?}",cursor);
          println!("{:?}",node);
          // println!("{:?}",node.next);
          // println!("{:?}",node.next.as_ref().unwrap().next);
          if index == target{
            println!("hello!");
            node.next = node.next.as_ref().unwrap().next.clone();
            // println!("{:?}",previous.unwrap().next);
            // let next_value = node.next.as_ref();
            // previous.unwrap().next ;
            // previous.unwrap().next = Some(node.next.unwrap());
          }
          previous = node.next.as_mut();
          index += 1;
        }

        return dummy.unwrap().next;

    }
}
