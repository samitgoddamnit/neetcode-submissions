class Solution {
    public void solve(char[][] board) {
        int row_length = board[0].length;
        int column_length = board.length;
        for(int i = 0; i < row_length; i++){
            if(board[0][i] == 'O'){
                board = dfs(board,0,i);
            }
        }

        for(int i = 0; i < row_length; i++){
            if(board[column_length-1][i] == 'O'){
                board = dfs(board,column_length-1,i);
            }
        }

        for(int i = 0; i < column_length; i++){
            if(board[i][0] == 'O'){
                board = dfs(board,i,0);
            }
        }

        for(int i = 0; i < column_length; i++){
            if(board[i][row_length-1] == 'O'){
                board = dfs(board,i,row_length-1);
            }
        }

        for(int i = 0; i < column_length; i++){
            for(int j = 0; j < row_length; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private char[][] dfs(char[][] board, int i, int j){
        if(i < 0){
            return board;
        }
        if(i >= board.length){
            return board;
        }
        if(j < 0){
            return board;
        }
        if(j >= board[i].length){
            return board;
        }

        if(board[i][j] == 'X'){
            return board;
        }

        if(board[i][j] == 'T'){
            return board;
        }

        if(board[i][j] == 'O'){
            board[i][j] = 'T';
            board = dfs(board,i+1,j);
            board = dfs(board,i-1,j);
            board = dfs(board,i,j+1);
            board = dfs(board,i,j-1);
        }
        return board;
    }
}
