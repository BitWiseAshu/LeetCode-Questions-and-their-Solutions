// class Pair{
//         int vertex;
//         int price;
        
//         Pair(int vertex, int price){
//             this.vertex = vertex;
//             this.price = price; 
//         }
// }

// class Solution {
    
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         if(src == dst) {
//             return -1;
//         }
        
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
//         for(int i = 0 ;  i < n; i++){
//             adj.add(new ArrayList<Pair>());
//         }
        
//         for(int []arr : flights){
//             int u = arr[0];
//             int v = arr[1];
//             int w = arr[2];
            
//             adj.get(u).add(new Pair(v, w));
//         }
        
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(src, 0));
        
//         int steps = 0;
        
//         while(!q.isEmpty()){
//             int size = q.size();
            
//             for(int i = 0 ; i  < size; i++){
//                 Pair front  = q.poll();
                
//                 for(Pair neighbour : adj.get(front.vertex)){
//                     int newPrice = front.price + neighbour.price;
                    
//                     if (neighbour.vertex == dst && (steps <= k || k == -1)) {
//                         return newPrice;
//                     }
                    
//                     q.add(new Pair(neighbour.vertex, newPrice));
//                 }
                
//             }
//         }
        
//         return -1;
//     }
// }






class Pair{
        int vertex;
        int price;
        
        Pair(int vertex, int price){
            this.vertex = vertex;
            this.price = price; 
        }
}

class Tuple{
    int first;
    int second;
    int third;
    
    Tuple(int first, int second, int third){
        this .first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst){
            return -1;
        }
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int []arr : flights){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            
            adj.get(u).add(new Pair(v, w));
        }
        
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        
        // Distance array to store the updated distances from the source. 
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = Integer.MAX_VALUE; 
        }
        dist[src] = 0; 
        
        while(!q.isEmpty()){
            Tuple front = q.poll();
            int steps = front.first;
            int node = front.second;
            int cost = front.third;
            
            if(steps > k){
                continue;
            }
            
            for(Pair neighbour : adj.get(node)){
                int v = neighbour.vertex;
                int p = neighbour.price;
                
                int newPrice = cost + p;
                if(newPrice < dist[v] && steps <= k){
                    dist[v] = newPrice;
                    q.add(new Tuple(steps+1, v, newPrice));
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

