class Solution {
    /*
    public static class Pair{
        int src;
        int level;

        Pair(int src, int level){
            this.src = src;
            this.level = level;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        
        int[] visited = new int[size];
        Arrays.fill(visited, -1);

        for(int v = 0; v < size; v++){
            if (visited[v] == -1){
                boolean isCompBipartite = checkIsGraphBipartiteUsingBFS(graph, v, visited);
                if (isCompBipartite){
                    return true;
                }
            }

        }
        
        return false;
    }
    
    
    private boolean checkIsGraphBipartiteUsingBFS(int[][] graph, int src, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        while (!q.isEmpty()){
            Pair frontElement = q.poll();
            int frontElementSrc = frontElement.src;
            int frontElementLevel = frontElement.level;

            System.out.println("Visiting: " + frontElementSrc + " at level " + frontElementLevel);

            if(visited[frontElementSrc] != -1){
                // if(frontElementLevel != visited[frontElementSrc]) {
                //     return false;
                // }
                
                if (frontElementLevel % 2 != visited[frontElementSrc] % 2) {
                    return false;
                }
            }
            else {
                visited[frontElementSrc] = frontElementLevel;
            }

            // for (int nbr : graph[frontElementSrc]) {
            //     if (visited[nbr] == -1) {
            //         q.add(new Pair(nbr, frontElementLevel + 1));
            //     }
            // }
            
            int[] neighbors = graph[frontElementSrc];
            
            for (int i = 0; i < neighbors.length; i++) {
                int nbr = neighbors[i];
                
                if (visited[nbr] == -1) {
                    q.add(new Pair(nbr, frontElementLevel + 1));
                }
                
            }

        }

        return true;
    }
    
    */
    
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!isBipartiteBFS(graph, i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isBipartiteBFS(int[][] graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentColor = colors[current];

            for (int neighbor : graph[current]) {
                if (colors[neighbor] == currentColor) {
                    return false;
                }

                if (colors[neighbor] == -1) {
                    // colors[neighbor] = 1 - currentColor;
                    if(currentColor == 0){
                        colors[neighbor] = 1;
                    }
                    else{
                        colors[neighbor] = 0;
                    }
                    
                    queue.add(neighbor);
                }
            }
        }

        return true;
    }


    
    
    
}