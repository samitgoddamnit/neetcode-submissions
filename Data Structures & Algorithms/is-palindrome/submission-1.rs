impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        let mut t = s.replace(|c: char| !c.is_ascii_alphanumeric(),"");
        t.make_ascii_lowercase();
        // println!("{:?}",t.len());
        let length = t.len();
        if length == 0{
            return true;
        }
        // println!("{}",length);
        let midpoint: usize = (length - 1) / 2;
        let (left_string,right_string) = t.split_at(midpoint + 1);
        // println!("{:?}",left_string);
        // println!("{:?}",right_string);
        let mut left_iter = left_string.chars();
        let mut right_iter = right_string.chars().rev();
        while let Some(x) = right_iter.next(){
            // println!("{:?}",x);
            if x != left_iter.next().unwrap(){
                return false;
            }
        }
        true
    }
}
