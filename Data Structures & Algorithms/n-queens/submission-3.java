class Solution {
    public List<List<String>> solveNQueens(int n) {
        return backtracking(n,new boolean[n][n],0,new ArrayList(),new ArrayList());
    }

    //so originally, I was implementing the second version of this algorithm, which is where you memorise the attacked positions of each
    // queen. However, I began to run into issues using that method when having to remove state after a branch had been searched.
    // essentially, I was hard coding all the diagonals reachable by a recently placed queen to becompletely removed after I removed it 
    // this affected state, so the backtracking algorithm was broken. A solution to this would have been to use stacks in the 
    // board array, or to use counts instead ! that way, I wouldn't remove another queens state.
    // I decided to use the alternate approach in the hints, where you check iteratively if another queen is in the way when you place.
    // at some point, you should return to this and try to implement your original method too !
    private List<List<String>> backtracking(int n, boolean[][] board, int i, List<Integer> choices, List<List<String>> result){
        if(i == n){
            List<String> tmp = new ArrayList();
            for(int j = 0; j < choices.size(); j++){
                StringBuilder string = new StringBuilder();
                for(int l = 0; l < n; l++){
                    string.append('.');
                }
                char[] s = string.toString().toCharArray();
                s[choices.get(j)] = 'Q';
                // System.out.println(String.valueOf(s));
                tmp.add(String.valueOf(s));
            }
            result.add(tmp);
            // System.out.println(tmp);
            return result; 
        }
        for(int j = 0; j < n; j++){
            if(placable(n,board,i,j)){
                choices.add(j);
                board[i][j] = true;
                result = backtracking(n,board,i+1,choices,result);
                choices.remove(choices.size() - 1);
                board[i][j] = false;
            }
        }
        return result;
    }

    private boolean placable(int n, boolean[][] board, int i, int j){
        for(int k = i; k >= 0; k--){
            if(board[k][j]){
                return false;
            }
        }
        int offset = j;
        int vertical = i;
        while(offset < n && vertical >= 0){
            if(board[vertical][offset]){
                return false;
            }
            vertical -= 1;
            offset += 1;
        }
        offset = j;
        vertical = i;
        while(offset >= 0 && vertical >= 0){
            if(board[vertical][offset]){
                return false;
            }
            vertical -= 1;
            offset -= 1;
        }
        return true;
    }
}
