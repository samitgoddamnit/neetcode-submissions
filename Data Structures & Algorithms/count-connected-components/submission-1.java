class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap();

        for(int i = 0; i < n; i++){
            graph.put(i,new ArrayList());
        }


        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        //graph initialised


        HashSet<Integer> processed = new HashSet();
        int total = 0;

        for(int i = 0; i < n; i++){
            if(!processed.contains(i)){
                processed = dfs(graph,processed,i);
                total += 1;
                // System.out.println(processed);
            }
        }

        return total;
    }

    private HashSet<Integer> dfs(HashMap<Integer,List<Integer>> graph, HashSet<Integer> processed, int value){
        if(processed.contains(value)){
            return processed;
        }
        processed.add(value);
        if(graph.get(value) == null){
            return processed;
        }
        List<Integer> adjacent = graph.get(value);
        for(int i = 0; i < adjacent.size(); i++){
            processed = dfs(graph,processed,adjacent.get(i));
        }
        return processed;
    }
}
