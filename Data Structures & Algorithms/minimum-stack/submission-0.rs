struct MinStack {
    array: Vec<i32>,
    min: Vec<i32>
}

impl MinStack {
    pub fn new() -> Self {
        let mut min_stack = MinStack{array: vec![], min: vec![], };
        min_stack
    }

    pub fn push(&mut self, val: i32) {
        self.array.push(val);
        if self.min.is_empty(){
            self.min.push(val);
        }
        else if self.min[(self.min.len() - 1) as usize] >= val {
            self.min.push(val);
        }
    }

    pub fn pop(&mut self) {
        let popped = self.array.pop().unwrap();
        if popped <= self.min[(self.min.len() - 1) as usize]{
            self.min.pop();
        }
    }

    pub fn top(&self) -> i32 {
        self.array[(self.array.len() - 1) as usize]
    }

    pub fn get_min(&self) -> i32 {
        self.min[(self.min.len() - 1) as usize]
        // return 0;
    }
}
