impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut bag_of_anagrams: HashMap<Vec<usize>,Vec<String>> = HashMap::new();
        for item in strs{
            let mut str_vec = vec![0; 26];
            for ch in item.chars(){
                let char_num = (ch as usize) - 97;
                str_vec[char_num] += 1;
            }
            if !(bag_of_anagrams.contains_key(&str_vec)){
                let mut to_add: Vec<String> = vec![item];
                bag_of_anagrams.insert(str_vec,to_add);
            }
            else{
                bag_of_anagrams.get_mut(&str_vec).unwrap().push(item);
            }
        }
        let v: Vec<_> = bag_of_anagrams.into_values().collect();
        return v;
    }
}
