class Solution {
    public List<List<String>> solveNQueens(int n) {
        return backtracking(n,new boolean[n][n],0,new ArrayList(),new ArrayList());
    }


    //true means you can't place there!
    //i tracks the row that we're currently on
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
