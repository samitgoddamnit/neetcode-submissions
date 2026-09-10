class Solution {
    public int largestRectangleArea(int[] heights) {
        // THIS PROBLEM FUCKING SUCKS.
        // tomorrow, try to explain it in prose / words
        int max_area = 0;
        Stack<Pair<Integer,Integer>> stack = new Stack();
        for(int i = 0; i < heights.length; i++){
            // System.out.println(heights[i]);
            if(stack.empty()){
                stack.push(new Pair(heights[i],i));
                continue;
            }
            int index = i;
            while(!stack.empty() && stack.peek().getKey() > heights[i]){
                Pair<Integer,Integer> tmp = stack.pop();
                int area = tmp.getKey() * (i - tmp.getValue());
                max_area = Math.max(max_area,area);
                index = tmp.getValue();
            }
            stack.push(new Pair(heights[i],index));
            // System.out.println(stack);
        }

        while(!stack.empty()){
            Pair<Integer,Integer> tmp = stack.pop();
            int area = tmp.getKey() * (heights.length - tmp.getValue());
            max_area = Math.max(max_area,area);
        }
        return max_area;
    }
}
