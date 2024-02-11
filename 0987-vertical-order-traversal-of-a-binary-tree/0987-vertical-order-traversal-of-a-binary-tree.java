/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    TreeNode node;
    int row; 
    int col;
    
    Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        q.add(new Pair(root, 0, 0));
        
        while(!q.isEmpty()){
            for(int i = 0 ; i  < q.size(); i++){
                Pair front = q.poll();
                TreeNode frontNode = front.node;
                int r = front.row;
                int c = front.col;
                
                if(!map.containsKey(r)){
                    map.put(r, new TreeMap<>());
                }
                
                if(!map.get(r).containsKey(c)){
                    map.get(r).put(c, new PriorityQueue<>());
                }
                
                map.get(r).get(c).add(frontNode.val);
                
                if(frontNode.left != null){
                    q.add(new Pair(frontNode.left, r-1, c+1));
                }
                
                if(frontNode.right != null){
                    q.add(new Pair(frontNode.right, r+1, c+1));
                }
            }
            
        }
        
        System.out.print(map);

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> key : map.values()){
            List<Integer> currList = new ArrayList<>();

            for(PriorityQueue<Integer> nodes : key.values()){
                while(!nodes.isEmpty()){
                    currList.add(nodes.poll());
                }
            }
            System.out.print(currList);
            ans.add(new ArrayList<>(currList));

        }
    
        return ans;
    }
}