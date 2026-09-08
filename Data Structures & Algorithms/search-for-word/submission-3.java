class Solution {
    public boolean exist(char[][] board, String word) {
        System.out.println(board.length);
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if(search(i,j,0,word,board,visited)){
                    return true;
                }
            }
        }
        return false;   
    }

    private boolean search(int i, int j, int index, String word, char[][] board, boolean[][] visited){
        //check whether the indexes are valid
        if(i < 0 || j < 0){
            return false;
        }
        if(i >= board.length){
            return false;
        }
        if(j >= board[i].length){
            return false;
        }

        if(visited[i][j]){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }
        else if (index == word.length() - 1){
            //all characters verified
            return true;
        }
        else{
            //search everything around
            visited[i][j] = true;
            boolean result =  search(i+1,j,index+1,word,board,visited) || search(i-1,j,index+1,word,board,visited) || search(i,j+1,index+1,word,board,visited) || search(i,j-1,index+1,word,board,visited);
            if(result){
                return true;
            }
            else{
                visited[i][j] = false;
                return false;
            }
        }
    }
}
