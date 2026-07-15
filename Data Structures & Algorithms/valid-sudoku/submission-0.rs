impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        let mut row = vec![vec![1;9]; 9];
        let mut column = vec![vec![1;9]; 9];
        let mut grid = vec![vec![vec![1;9];3];3];
        let n = board.len();
        println!("{:?}", n);

        for i in 0..n {
            for j in 0..n {
                let item = board[i][j];
                let parsed_item_option = item.to_digit(10);
                
                if parsed_item_option.is_some() {
                    let parsed_item = parsed_item_option.unwrap();
                    let index = (parsed_item - 1) as usize; 
                    let sub_box: (usize,usize) = ((i/3),(j/3));
                    if row[i][index] == 0{
                        return false;
                    }
                    else if column[j][index] == 0{
                        return false;
                    }
                    else if grid[sub_box.0][sub_box.1][index] == 0{
                        return false;
                    }
                    else{
                        row[i][index] = 0;
                        column[j][index] = 0;
                        grid[sub_box.0][sub_box.1][index] = 0;
                    }
                }
            }
        }
        true
    }
}
