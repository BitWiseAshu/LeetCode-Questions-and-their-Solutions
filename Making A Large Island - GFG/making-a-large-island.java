//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, 1, 0, -1};
    public int largestIsland(int N, int[][] grid) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = grid.length;
        int region = 2;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = flood(grid, i, j, region);
                    hm.put(region, area);
                    max = Math.max(max, area);
                    region++;
                }
            }
        }

       

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    HashSet<Integer> hs = new HashSet<>();
                    int area = 1;

                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            hs.add(grid[nr][nc]);
                        }
                    }

                    for (int val : hs) {
                        area += hm.getOrDefault(val, 0); // Use getOrDefault to avoid potential null value
                    }

                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int flood(int[][] grid, int r, int c, int region) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }

        int sum = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            if (grid[row][col] == 1) {
                grid[row][col] = region;
                sum++;

                for (int i = 0; i < 4; i++) {
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        stack.push(new int[]{nr, nc});
                    }
                }
            }
        }
        return sum;
    }
}
