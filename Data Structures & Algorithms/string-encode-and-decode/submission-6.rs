impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        //encode each string as a sequence of [char](frequency) (runLength encoding)!
        //then split each string using two ££s.

        let mut fullEncoding = format!("{}##", strs.len()); //this makes the encoding start by counting words (used to fix an edge case)

        let mut string_iter = strs.iter().peekable();
        while let Some(string) = string_iter.next(){

            let mut iter = string.chars().peekable();

            let mut wordEncoding: String = String::new();
            let mut count: u32 = 0;

            while let Some(c) = iter.next(){
                let next: char = *iter.peek().unwrap_or(&'終');

                count += 1;
                if !(c == next){
                    // println!("count is at {}",count);
                    let runEncoding = format!("[{}]({})",c,count);
                    // println!("encoding is: {}",runEncoding);
                    count = 0;
                    wordEncoding = wordEncoding + &runEncoding;
                }

                // println!("current char = {:?}\nnext char = {:?}\n",current,next);
            }
            if !string_iter.peek().is_none(){
                wordEncoding = wordEncoding + "££";
            }
            // println!("word encoding = {}\n",wordEncoding);
            fullEncoding = fullEncoding + &wordEncoding;
        }
        // println!("full encoding = {}\n",fullEncoding);
        // if(fullEncoding == ""){
        //     println!("uh oh");
        // }
        fullEncoding
    }

    pub fn decode(s: String) -> Vec<String> {
        // //essentially writing a parser for the string
        // println!("hello{:?}goodbye",s);
        let parts = s.split("##");
        let collection: Vec<&str> = parts.collect();
        // println!("{:?}",collection[0]);
        let vecCount: u32 = collection[0].parse().unwrap();
        // println!("{:?}",vecCount);

        let parts = collection[1].split("££");
        // println!("{:?}",parts);
        // //can split on double pound because of encoding 
        // let decodedString :Vec<String> = Vec::new();
        let mut decoded_strs: Vec<String> = Vec::new();
        let mut partCount: u32 = 0; 
        for part in parts{
            let mut iter = part.chars().peekable();
            let mut currChar: char = 'x';
            let mut count: String = String::new();
            let mut parsing: String = String::from("char");
            let mut run: String = String::new();
            while let Some(c) = iter.next(){
                let next: char = *iter.peek().unwrap_or(&'終');
                if parsing == "char"{
                    if c == '['{
                        if !(c==currChar){
                            currChar = next;
                        }
                    }
                    else if c == ']' && next == '('{
                        parsing = String::from("num");
                    }
                }
                else if parsing == "num"{
                    if c != ')' {
                        if next != ')'{
                            // println!("{:?}",next);
                            count.push(next);
                        }
                    }
                    else{
                        let runLength: u32 = count.parse().unwrap(); 
                        // println!("{:?}",runLength);

                        for _i in 0..runLength{
                           run.push(currChar);
                        }

                        // println!("{}",run);
                        count = String::new();

                        if next == '['{
                            // println!("converting to char mode");
                            parsing = String::from("char");
                        }
                    }
                }
            }

            // println!("{:?}",part);
            decoded_strs.push(run);
        }
        if vecCount == 0{
            return Vec::<String>::new();
        }
        else{
            return decoded_strs;
        }
    }

}
