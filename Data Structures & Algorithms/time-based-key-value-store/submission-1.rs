use std::collections::HashMap;

struct TimeMap {
    map: HashMap<String,Vec<(i32,String)>>,
}

impl TimeMap {
    fn new() -> Self {
        Self{
            map : HashMap::new(),
        }
    }

    fn set(&mut self, key: String, value: String, timestamp: i32) {
        self.map.entry(key.to_string()).or_insert(Vec::<(i32,String)>::new()).push((timestamp,value));
        // println!("{:?}",self.map);
    }   

    fn get(&self, key: String, timestamp: i32) -> String {
        let Some(times) = self.map.get(&key) else { return String::from("") };
        let mut l:i32 = 0;
        let mut r:i32 = times.len() as i32 - 1;
        let mut res = String::from("");
        println!("{:?}",times);
        println!("targeting {}", timestamp);
        while l <= r {
            let m = l + (r - l) / 2;
            println!("l:{}, m:{}, r:{}",l,m,r);
            // if times[m as usize].0 == timestamp{
            //     let result = &times[m as usize].1;
            //     println!("found: {}",result);
            //     return result.to_string();
            // }
            if times[m as usize].0 <= timestamp{
                res = times[m as usize].1.to_string();
                l = m + 1;
            }
            else if times[m as usize].0 > timestamp{
                r = m - 1;
            }
        }
        println!("l:{}, r:{}",l,r);
        // return times[l as usize].1.to_string();
        res
    }
}
