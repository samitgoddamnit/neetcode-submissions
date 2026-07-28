impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut stack: Vec<String> = Vec::new();
        let operators: Vec<String> = Vec::from([String::from("+"),String::from("-"),String::from("*"),String::from("/")]);

        for tok in tokens{
            if operators.contains(&tok){
                let num1: i32 = stack.pop().unwrap().parse().unwrap();
                let num2: i32 = stack.pop().unwrap().parse().unwrap();
                println!("{:?}",num1);
                println!("{:?}",num2);
                let result: i32 = match tok.as_str() {
                    "+" => num1 + num2,
                    "-" => num2 - num1,
                    "*" => num1 * num2,
                    "/" => num2 / num1,
                    &_ => 0,
                };
                stack.push(result.to_string());
            }
            else{
                stack.push(tok);
            }
        }

        println!("{:?}", stack);
        return stack.pop().unwrap().parse::<i32>().unwrap()
    }
}
