class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for( int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '0'){
                    grid[i][j] = 'x';
                }
                else if(grid[i][j] == '1'){
                    grid = dfs(grid,i,j);
                    result += 1;
                }
            }
        }
        return result;
    }
    

    private char[][] dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length){
            return grid;
        }
        if(j < 0 || j >= grid[i].length){
            return grid;
        }
        if(grid[i][j] != '1'){
            return grid;
        }
        else{
            grid[i][j] = 'x';
            grid = dfs(grid,i+1,j);
            grid = dfs(grid,i-1,j);
            grid = dfs(grid,i,j+1);
            grid = dfs(grid,i,j-1);
            return grid;
        }
    }
}
