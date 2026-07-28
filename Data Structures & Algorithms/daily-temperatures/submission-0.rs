impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        let len = temperatures.len();
        let mut result = vec![0;len];
        let mut stack : Vec<usize> = Vec::new(); 
        for i in 0..len{
            if i == 0{
                stack.push(i);
            }
            else{
                loop{
                    let top = stack.last();
                    if top.is_some(){
                        let top_elem = *top.unwrap();
                        if temperatures[top_elem] < temperatures[i]{
                            result[top_elem] = i - top_elem;
                            stack.pop();
                        }
                        else{
                            stack.push(i);
                            break;
                        }
                    }
                    else{
                        stack.push(i);
                        break;
                    }
                }
            }
        }
        println!("{:?}",result);
        let mut result_final = vec![0;len];
        for i in 0..len{
            result_final[i] = result[i] as i32;
        }
        result_final
    }
}
