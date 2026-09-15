class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> mappings = new HashMap();
        for(int i = 0; i < numCourses; i++){
            mappings.put(i,new ArrayList());
        }
        for(int i = 0; i < prerequisites.length; i++){
            mappings.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        //graph initialised


        for(int i = 0; i < numCourses; i++){
            Pair<Boolean,HashMap<Integer,List<Integer>>> tmp = no_cycle(mappings,i,new HashSet());
            if(tmp.getKey()){
                mappings = tmp.getValue();
            }
            else{
                return false;
            }
        }

        return true;
    }


    private Pair<Boolean,HashMap<Integer,List<Integer>>> no_cycle(HashMap<Integer,List<Integer>> mappings, int key, HashSet<Integer> visited){
        if(visited.contains(key)){
            //found a cycle
            return new Pair(false,mappings);
        }
        visited.add(key);
        if(mappings.get(key).size() == 0){
            //end of tree / graph
            visited.remove(key);
            return new Pair(true,mappings);
        }
        List<Integer> adjacent = mappings.get(key);
        for(int i = 0; i < adjacent.size(); i++){
            Pair<Boolean,HashMap<Integer,List<Integer>>> tmp = no_cycle(mappings,adjacent.get(i),visited);
            if(!tmp.getKey()){
                return new Pair(false,mappings);
            }
        }
        mappings.put(key, new ArrayList());
        visited.remove(key);
        return new Pair(true,mappings);
    }
}
