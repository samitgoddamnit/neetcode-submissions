impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack: Vec<char> = Vec::new();

        //can do this with cleaner logic using a hashmap instead of these two arrays
        let openers = vec!['{','[','('];
        let closers = vec!['}',']',')'];

        for c in s.chars(){
            if openers.contains(&c){
                stack.push(c);
                println!("{:?}",stack);
            }
            else {
                let popped = stack.pop();

                if popped.is_none(){
                    return false;
                }
                
                let pop_index = openers.iter().position(|&i| i == popped.unwrap()).unwrap();
                let curr_index = closers.iter().position(|&i| i == c).unwrap();

                if pop_index != curr_index {
                    return false;
                }
            }
        }
        stack.is_empty()
    }
}
