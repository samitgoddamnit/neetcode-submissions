class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap();

        for(int i = 0; i < n; i++){
            graph.put(i,new ArrayList());
        }

        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet();

        
        if(!dfs(graph,new HashSet(),visited,0,null)){
            return false;
        }
        if(visited.size() != n){
            return false;
        }
        return true;
    }

    private boolean dfs(HashMap<Integer,List<Integer>> graph, HashSet<Integer> cycle, HashSet<Integer> visited,int value,Integer arrived_from){
        if(cycle.contains(value)){
            return false;
        }
        cycle.add(value);
        visited.add(value);
        if(graph.get(value).isEmpty()){
            return true;
        }
        List<Integer> adjacent = graph.get(value);
        for(int i = 0; i < adjacent.size(); i++){
            if(arrived_from != null && adjacent.get(i) == arrived_from){
                continue;
            }
            if(!dfs(graph,cycle,visited,adjacent.get(i),value)){
                return false;
            }
        }
        cycle.remove(value);
        return true;
    }
}
