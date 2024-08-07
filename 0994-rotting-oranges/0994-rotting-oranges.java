/*
class Solution {
    public int orangesRotting(int[][] grid) {
        // if grid is empty then return 0;
        if(grid.length == 0 || grid == null){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        // Intializing a array of Queue
        Queue<int[]> q = new LinkedList<>();
        
        int freshOranges = 0;
        
        for(int i = 0 ; i < n ; i++){
            for( int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }
        
        int count = 0;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;

            while(size-- > 0){
                int front[] = q.poll();

                int i = front[0];
                int j = front[1];

                // left

                int leftI = i;
                int leftJ = j - 1;

                if(leftI >= 0 && leftJ >= 0 && leftI < n && leftJ < m && grid[leftI][leftJ] == 1){
                    grid[leftI][leftJ] = 2;
                    q.add(new int[]{leftI, leftJ});
                    freshOranges --;
                    flag = true;
                }

                // right 

                int rightI = i;
                int rightJ= j + 1;

                if(rightI >= 0 && rightJ >= 0 && rightI < n && rightJ < m && grid[rightI][rightJ] == 1){
                    grid[rightI][rightJ] = 2;
                    q.add(new int[]{rightI, rightJ});
                    freshOranges --;
                    flag = true;
                }

                // up

                int topI = i - 1;
                int topJ = j;

                if(topI >= 0 && topJ >= 0 && topI < n && topJ < m && grid[topI][topJ] == 1){
                    grid[topI][topJ] = 2;
                    q.add(new int[]{topI, topJ});
                    freshOranges --;
                    flag = true;
                }

                // down

                int bottomI = i+1;
                int bottomJ = j;

                if(bottomI >= 0 && bottomJ >= 0 && bottomI < n && bottomJ < m && grid[bottomI][bottomJ] == 1){
                    grid[bottomI][bottomJ] = 2;
                    q.add(new int[]{bottomI, bottomJ});
                    freshOranges --;
                    flag = true;
                }

            }

            if(flag){
                count ++;
            }
            
        }
        
        if(freshOranges != 0){
            return -1;
        }
        
        return count;
    }
}
*/



















class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public boolean isValid(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (n == 0 || grid == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            for (int k = 0; k < size; k++) {
                Pair node = q.poll();
                int i = node.i;
                int j = node.j;

                // left
                if (isValid(i, j - 1, grid)) {
                    grid[i][j - 1] = 2;
                    q.add(new Pair(i, j - 1));
                    freshOranges--;
                    flag = true;
                }

                // up
                if (isValid(i - 1, j, grid)) {
                    grid[i - 1][j] = 2;
                    q.add(new Pair(i - 1, j));
                    freshOranges--;
                    flag = true;
                }

                // right
                if (isValid(i, j + 1, grid)) {
                    grid[i][j + 1] = 2;
                    q.add(new Pair(i, j + 1));
                    freshOranges--;
                    flag = true;
                }

                // down
                if (isValid(i + 1, j, grid)) {
                    grid[i + 1][j] = 2;
                    q.add(new Pair(i + 1, j));
                    freshOranges--;
                    flag = true;
                }
            }

            if (flag) {
                minutes++;
            }
        }

        if (freshOranges > 0) {
            return -1;
        }

        return minutes;
    }
}