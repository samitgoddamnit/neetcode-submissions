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
    pub fn merge_two_lists(list1: Option<Box<ListNode>>, list2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {        
        let mut list_1 = list1;
        let mut list_2 = list2;
    
        println!("{:?}",list_1);

        let mut stack:Vec<i32> = Vec::new(); 

        while list_1.is_some() || list_2.is_some(){

            let current_1 = list_1.take();
            let current_2 = list_2.take();
            
            if current_1.is_none(){
                println!("bar");
                stack.push(current_2.clone().unwrap().val);
                list_2 = current_2.unwrap().next;
                continue
            }
            else if current_2.is_none(){
                println!("foo");
                stack.push(current_1.clone().unwrap().val);
                list_1 = current_1.unwrap().next;
                continue
            }

            let val_1 = current_1.clone().unwrap().val;
            let val_2 = current_2.clone().unwrap().val;


            if val_1 >= val_2{
                stack.push(val_2);
                list_1 = current_1;
                list_2 = current_2.unwrap().next;
                println!("bar");

            }
            else{
                stack.push(val_1);
                list_2 = current_2;
                list_1 = current_1.unwrap().next;
                println!("foo");
            }
        }

        let mut node = None;
        println!("{:?}",stack);
        while !stack.is_empty(){
            let top = stack.pop();
            let mut temp: ListNode = ListNode::new(top?);
            temp.next = node;
            let temp_box :Box<ListNode> = Box::new(temp);
            node = Some(temp_box);
        }
        println!("{:?}",node);
        return node;
    }
}
