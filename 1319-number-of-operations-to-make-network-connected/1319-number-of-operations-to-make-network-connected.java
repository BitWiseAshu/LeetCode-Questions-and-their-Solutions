// class DisjointSet{
//     int []rank;
//     int parent[];
    
//     public DisjointSet(int n){
//         rank = new int[n+1];
//         parent = new int[n+1];
        
//         for(int i = 0; i <= n; i++){
//             rank[i] = 0;
//             parent[i] = i;
//         }
        
//         public int findUltimateParent(int node){
//             if(node == parent[node]){
//                 return node;
//             }
            
//             parent[node] = findUltimateParent(parent[node]);
//             return parent[node];
//         }
        
//         public void unionByRank(int u, int v){
//             int ulp_u = findUltimateParent(u);
//             int ulp_v = findUltimateParent(v);
            
//             if(ulp_u == ulp_v) {
//                 return;
//             }
            
//             if(rank[ulp_u] < rank[ulp_v]){  
//                 parent[ulp_u] = ulp_v; // u joins v's set  
// 		    } 
// 		    else if(rank[ulp_u] > rank[ulp_v]){  
//                 parent[ulp_v] = ulp_u; // v joins u's set  
// 		    } 
// 		    else {  
//                 parent[ulp_v] = ulp_u; // v joins u's set and 	increment rank of u  
// 			    rank[ulp_u]++;  
// 	        }  
//         }
//     }
// }

// class Solution {
//     public int makeConnected(int n, int[][] connections) {
//         DisjointSet ds = new DisjointSet(n);
        
//         int cntExtras = 0;
//         int n = edge.length;
        
//         for(inti = 0; i < n; i++){
//             int u = edge[i][0];
//             int v = edge[i][1];
//             if (ds.findUltimateParent(u) == ds.findUltimateParent(v)) {
//                 cntExtras++;
//             } else {
//                 ds.unionByRank(u, v);
//             }
//         }
        
//         int cntComponents = 0;
//         for (int i = 0; i < n; i++) {
//             if (ds.parent.get(i) == i) cntC++;
//         }
//         int ans = cntComponents - 1;
//         if (cntExtras >= ans) return ans;
//         return -1;
//     }
// }



class DisjointSet {
    int []rank;
    int parent[];
    
    public DisjointSet(int n) {
        rank = new int[n+1];
        parent = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }
    
    public int findUltimateParent(int node) {
        if(node == parent[node]) {
            return node;
        }
        
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }
    
    public void unionByRank(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        
        if(ulp_u == ulp_v) {
            return;
        }
        
        if(rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v; // u joins v's set
        } 
        else if(rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u; // v joins u's set
        } 
        else {
            parent[ulp_v] = ulp_u; // v joins u's set and increment rank of u
            rank[ulp_u]++;
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        
        int cntExtras = 0;
        int edges = connections.length;
        
        for(int i = 0; i < edges; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUltimateParent(u) == ds.findUltimateParent(v)) {
                cntExtras++;
            } else {
                ds.unionByRank(u, v);
            }
        }
        
        int cntComponents = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUltimateParent(i) == i) {
                cntComponents++;
            }
        }
        
        int ans = cntComponents - 1;
        if (cntExtras >= ans) return ans;
        return -1;
    }
}
