class DisjointSet{  
    int[] rank;  
    int[] parent;  
    int[] size;  
  
    public DisjointSet(int n){  
        rank = new int[n + 1];   // Initialize rank array  
		parent = new int[n + 1]; // Initialize parent array  
		size = new int[n + 1];   // Initialize size array  
  
		for(int i = 0; i <= n; i++){  
            rank[i] = 0;         // Initial rank is 0  
			parent[i] = i;       // Each node is its own parent initially  
			size[i] = 1;         // Initial size of each set is 1  
		 }  
    }  
  
    // Find with path compression  
	public int findUPar(int node){  
        if(node == parent[node]){  
            return node;  // Return the node itself if it's the parent  
		}  
  
        // Path compression: set the parent of the node to the ultimate parent (root)  
		return parent[node] = findUPar(parent[node]);  
	}  
  
    // Union by Rank  
    public void unionByRank(int u, int v){  
        int ulp_u = findUPar(u);  // Find ultimate parent of u  
		int ulp_v = findUPar(v);  // Find ultimate parent of v  
  
		if(ulp_u == ulp_v) return; // If they are already in the same set, no need to union  
  
        // Union by rank: attach smaller rank tree under the larger rank tree
 
		if(rank[ulp_u] < rank[ulp_v]){  
            parent[ulp_u] = ulp_v; // u joins v's set  
		} 
		else if(rank[ulp_u] > rank[ulp_v]){  
            parent[ulp_v] = ulp_u; // v joins u's set  
		} 
		else {  
            parent[ulp_v] = ulp_u; // v joins u's set and 	increment rank of u  
			rank[ulp_u]++;  
	     }  
   }  
  
    // Union by Size  
  public void unionBySize(int u, int v) {  
        int ulp_u = findUPar(u);  // Find ultimate parent of u  
		int ulp_v = findUPar(v);  // Find ultimate parent of v  
  
		if (ulp_u == ulp_v) return; // If they are already in the same set, no need to union  
  
 // Union by size: attach the smaller set under the larger set  
		if (size[ulp_u] < size[ulp_v]) {  
            parent[ulp_u] = ulp_v;  // u joins v's set  
		    size[ulp_v] += size[ulp_u];  // Update size of v's set  
		 } else {  
            parent[ulp_v] = ulp_u;  // v joins u's set  
			size[ulp_u] += size[ulp_v];  // Update size of u's set  
		  }  
	}  
}  
  


class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        
        int maxRow = 0;
        int maxCol = 0;
        
        for(int arr[] : stones){
            maxRow = Math.max(maxRow, arr[0]);
            maxCol = Math.max(maxCol, arr[1]);
        }
        
        DisjointSet ds = new  DisjointSet(maxRow + maxCol + 1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            
            ds.unionBySize(nodeRow, nodeCol);
            
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        
        int count = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(ds.findUPar(entry.getKey()) == entry.getKey()) {
                count ++;
            }
        }
        
        return (n - count); 
    }
}