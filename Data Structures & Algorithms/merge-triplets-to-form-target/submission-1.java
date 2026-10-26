class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] possible = new boolean[3];
        for(int[] triplet : triplets){
            if(triplet[0] == target[0]){
                if(possible[0] != true){
                    if(!(triplet[1] <= target[1]) || !(triplet[2] <= target[2])){
                        possible[0] = false; 
                    }
                    else{
                        possible[0] = true;
                    }
                }
            }
            if(triplet[1] == target[1]){
                if(possible[1] != true){
                    if(!(triplet[0] <= target[0]) || !(triplet[2] <= target[2])){
                        possible[1] = false; 
                    }
                    else{
                        possible[1] = true;
                    }
                }
            }
            if(triplet[2] == target[2]){
                if(possible[2] != true){
                    if(!(triplet[0] <= target[0]) || !(triplet[1] <= target[1])){
                        possible[2] = false; 
                    }
                    else{
                        possible[2] = true;
                    }
                }
            }
        }


        for(boolean result : possible){
            if(!result){
                return false;
            }
        }
        return true;
    }
}
