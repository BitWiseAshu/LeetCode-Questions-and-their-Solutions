// class Pair{
//         int vertex;
//         int time;
        
//         Pair(int vertex, int time){
//             this.vertex = vertex;
//             this.time = time; 
//         }
// }

// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
//         for(int i = 0; i < n; i++){
//             adj.add(new ArrayList<Pair>());
//         }
        
//         for(int []arr : times){
//             int u = arr[0];
//             int v = arr[1];
//             int w = arr[2];
            
//             adj.get(u).add(new Pair(v, w));
//         }
        
//         int[] dist = new int[n+1]; 
//         for(int i = 0;i<n;i++) {
//             dist[i] = Integer.MAX_VALUE; 
//         }
//         dist[k] = 0; 
        
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(k, 0));
        
//         while (!q.isEmpty()) {
//             Pair front = q.poll();
//             int v = front.vertex;
//             int t = front.time;

//             for (Pair neighbourOfV : adj.get(v)) {
//                 q.add(new Pair(neighbourOfV.vertex, t + neighbourOfV.time));
//                 dist[neighbourOfV.vertex] = Math.min(dist[neighbourOfV.vertex], t + neighbourOfV.time);
//             }
//         }
        
//         return dist[dist.length-1] == Integer.MAX_VALUE ? -1 : dist[dist.length-1];
//     }
// }




class Pair {
    int vertex;
    int time;

    Pair(int vertex, int time) {
        this.vertex = vertex;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int[] arr : times) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            adj.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k, 0));

        while (!q.isEmpty()) {
            Pair front = q.poll();
            int u = front.vertex;
            int t = front.time;

            for (Pair neighbourOfU : adj.get(u)) {
                int v = neighbourOfU.vertex;
                int w = neighbourOfU.time;

                if (t + w < dist[v]) {
                    dist[v] = t + w;
                    q.add(new Pair(v, t+w));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
