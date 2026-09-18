class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ordering = new ArrayList();
        HashMap<Integer,List<Integer>> mappings = new HashMap();

        for(int i = 0; i < numCourses; i++){
            mappings.put(i,new ArrayList());
        }

        for(int i = 0; i < prerequisites.length; i++){
            mappings.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        HashSet<Integer> printed = new HashSet();

        for(int i = 0; i < numCourses; i++){
            ordering = dfs(mappings,ordering,new HashSet(),i,printed);
            if(ordering.isEmpty()){
                return new int[0];
            }
        }

        //final conversion
        int[] result = new int[ordering.size()];
        for(int i = 0; i < ordering.size(); i++){
            result[i] = ordering.get(i);
        }
        return result;
    }

    private List<Integer> dfs(HashMap<Integer,List<Integer>> mappings, List<Integer> ordering, HashSet<Integer> visited, int value, HashSet<Integer> printed){
        if(visited.contains(value)){
            System.out.println("found cycle");
            return new ArrayList();
        }

        if(printed.contains(value)){
            return ordering;
        }
        visited.add(value);

        if(!mappings.get(value).isEmpty()){
            List<Integer> adjacent = mappings.get(value);
            for(int i = 0; i < adjacent.size(); i++){
                ordering = dfs(mappings,ordering,visited,adjacent.get(i),printed);
                if(ordering.isEmpty()){
                    return ordering;
                }
            }
        }

        if(!printed.contains(value)){
            ordering.add(value);
            printed.add(value);
        }

        visited.remove(value);
        return ordering;
    }
}
