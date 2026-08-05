use std::collections::HashMap;

struct TimeMap {
    map: HashMap<String,Vec<(i32,String)>>,
}

impl TimeMap {
    fn new() -> Self {
        TimeMap {
            map: HashMap::new(),
        }   
    }

    fn set(&mut self, key: String, value: String, timestamp: i32){
        self.map.entry(key).or_insert(Vec::<(i32,String)>::new()).push((timestamp,value));
    }

    fn get(&self, key: String, timestamp: i32) -> String {
        // println!("{:?}",self.map);
        let Some(vector) = self.map.get(&key) else { return "".to_string() };
        println!("{:?}",vector);

        let mut l:i32 = 0;
        let mut r:i32 = (vector.len() - 1) as i32;
        let mut result: String = String::from("");

        println!("looking for timestamp: {}",timestamp);

        while l <= r {
            let m:i32 = l + (r - l) / 2;
            let v_m = &vector[m as usize];

            println!("l : {}, m : {}, r : {}",l,m,r);

            if v_m.0 <= timestamp {
                println!("removing right half");
                l = m + 1;
                result = v_m.1.clone();
            }
            else if v_m.0 > timestamp{
                println!("removing left half");
                r = m - 1;
            }
        }
        result
    }
}
