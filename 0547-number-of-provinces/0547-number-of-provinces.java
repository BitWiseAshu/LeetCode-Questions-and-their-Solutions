class Solution {
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
}