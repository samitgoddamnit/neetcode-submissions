class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < matrix[i].length; k++){
                        if(matrix[i][k] != 0){
                            matrix[i][k] = -1;
                        }
                    }
                    for(int k = 0; k < matrix.length; k++){
                        if(matrix[k][j] != 0){
                            matrix[k][j] = -1;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
