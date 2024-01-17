class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int []arr : graph){
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0 ; i  < arr.length; i++){
                list.add(arr[i]);
            }
            
            adj.add(list);
        }
        
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>()); // Initialize the reversed adjacency list
        }
        
        int []inDegree = new int[graph.length];
        
        for(int i = 0; i  < graph.length; i++){
            for(int neighbour : adj.get(i)){
                adjRev.get(neighbour).add(i);
                inDegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        System.out.println(adjRev);
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int front = q.poll();
            ans.add(front);
            
            for(int neighbour : adjRev.get(front)){
                inDegree[neighbour] --;
                
                if(inDegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}