impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack: Vec<char> = Vec::new();
        let mut iter = s.chars();

        let openers = vec!['{','[','('];
        let closers = vec!['}',']',')'];

        for c in iter{
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

        if !stack.is_empty(){
            return false;
        }
        else{
            return true;
        }
    }
}
