class Solution {
    
    
    //  SOLUTION USING BFS
    /*
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        return findCircleUsingBFS(isConnected, n, visited);
    }
    
    public int findCircleUsingBFS(int[][] isConnected, int n, boolean []visited){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                q.add(i);
                visited[i] = true;
                count ++;
                
                while(!q.isEmpty()){
                    int frontElement = q.poll();
                    
                    for(int j = 0 ; j < n ; j++){
                        if(isConnected[frontElement][j] == 1 && !visited[j]){
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    */
    
    
    // SOLUTION USING DFS
    
//     public void dfs(int node, int[][] isConnected, boolean[] visit) {
//         visit[node] = true;
//         for (int i = 0; i < isConnected.length; i++) {
//             if (isConnected[node][i] == 1 && !visit[i]) {
//                 dfs(i, isConnected, visit);
//             }
//         }
//     }

//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         int numberOfComponents = 0;
//         boolean[] visit = new boolean[n];

//         for (int i = 0; i < n; i++) {
//             if (!visit[i]) {
//                 numberOfComponents++;
//                 dfs(i, isConnected, visit);
//             }
//         }

//         return numberOfComponents;
//     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Using BFS
    
    /*
    public void dfs(int [][]isConnected, boolean []visited, int node, int n){
        visited[node] = true;
        
        for(int i = 0; i < n; i++){
            if(isConnected[node][i] == 1 && visited[i] == false){
                dfs(isConnected, visited, i, n);
            }
        }
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfProvinces = 0;
        boolean []visited = new boolean[n];
        
        for(int i = 0; i < n ; i++){
            if(!visited[i]){
                numberOfProvinces ++;
                dfs(isConnected, visited, i, n);
            }
        }
        
        return numberOfProvinces;
    }
    
    */
    
    
    
    
    
    // Using BFS
    
    public int findCircleNumUsingBFS(int [][]isConnected, boolean []visited, int n){
        Queue<Integer> q = new LinkedList<>();
        
        int numberOfProvinces = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                visited[i] = true;
                numberOfProvinces ++;
                q.add(i);
                
                while(!q.isEmpty()){
                    int frontNode = q.poll();
            
                    for(int j = 0; j < n; j++){
                        if(isConnected[frontNode][j] == 1 && visited[j] == false){
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        
        return numberOfProvinces;
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean []visited = new boolean[n];
        
        return findCircleNumUsingBFS(isConnected, visited, n);
    }
}