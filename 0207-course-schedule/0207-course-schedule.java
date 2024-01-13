class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Array to keep track of in-degrees for each node
        int[] inDegree = new int[numCourses];

        // Calculate in-degrees
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : list.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Add nodes with in-degree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Counter for processed nodes
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : list.get(node)) {
                inDegree[neighbor]--;

                // If in-degree becomes 0, add the neighbor to the queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        
        return count == numCourses ? true : false;
    }
}