class Solution {

    public static class wtComparator implements Comparator<int[]>{
        public int compare(int a[], int b[]){
            return a[0]-b[0];
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new wtComparator());

        int dist[][] = new int[n][m];
        for(var a : dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.add(new int[]{0,0,0});

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(pq.size()!=0){
            int a[] = pq.remove();
            int x = a[1];
            int y = a[2];
            
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    int newdist = Math.max(a[0],Math.abs(arr[x][y]-arr[nx][ny]));
                    if(newdist<dist[nx][ny]){
                        dist[nx][ny] = newdist;
                        pq.add(new int[]{newdist,nx,ny});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}