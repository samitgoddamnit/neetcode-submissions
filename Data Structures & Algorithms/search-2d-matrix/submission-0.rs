impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let mut rowl: usize = 0;
        let mut rowr: usize = matrix.len();
        while rowl < rowr{
            let mid = rowl + (rowr - rowl) / 2;
            let row = &matrix[mid];
            if target > row[row.len()-1]{
                rowl = mid + 1;
            }
            else if target < row[0]{
                rowr = mid;
            }
            else{
                let mut columnl: usize = 0;
                let mut columnr: usize = row.len();
                while columnl < columnr{
                    let mid2 = columnl + (columnr - columnl) / 2;
                    let value = row[mid2];
                    if target == value{
                        return true;
                    }
                    else if target < value{
                        columnr = mid2;
                    }
                    else if target > value{
                        columnl = mid2 + 1;
                    }
                }
                break;
            }
        }
        false
    }
}
