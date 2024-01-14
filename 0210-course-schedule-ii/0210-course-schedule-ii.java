class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ;  i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int inDegree[] = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            for(int neighbour:adj.get(i)){
                inDegree[neighbour]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int count = 0;
        int i = 0;
        int []topo = new int[numCourses];  
        
        while(!q.isEmpty()){
            int front = q.poll();
            count ++;
            topo[i++] = front;
            
            for(int neighbour : adj.get(front)){
                inDegree[neighbour] --;
                
                if(inDegree[neighbour] == 0) q.add(neighbour);
            }
            
        }
        
        if(count == numCourses){
            return topo;
        }
        
        return new int[0];
    }
}

