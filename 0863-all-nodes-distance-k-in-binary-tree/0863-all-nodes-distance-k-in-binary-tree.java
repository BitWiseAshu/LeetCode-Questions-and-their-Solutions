/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parentTrack, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            
            if(current.left != null){
                parentTrack.put(current.left, current);
                q.add(current.left);
            }
            
            if(current.right != null){
                parentTrack.put(current.right, current);
                q.add(current.right);
            }
        }
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0){
            List<Integer> list = new ArrayList<>();
            list.add(target.val);
            return list;
        }
        HashMap<TreeNode, TreeNode> parentTrack  = new HashMap<>();
        markParent(root, parentTrack, target);
        
        HashMap<TreeNode, Boolean> visited  = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        
        int currentLevel = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            if(currentLevel == k){
                break;
            }
            currentLevel ++;
            
            for(int i  = 0 ; i  < size ; i++){
                TreeNode current = q.poll();
                
                // add left unvisited child to queue
                if(current.left != null && !visited.containsKey(current.left)){
                    q.add(current.left);
                    visited.put(current.left, true); // mark left child as visited
                }
                
                // add unvisited right child to queue
                if(current.right != null && !visited.containsKey(current.right)){
                    q.add(current.right);
                    visited.put(current.right, true); // mark right child as visited
                }
                
                // add unvisited parent node to the queue
                if(parentTrack.containsKey(current) && !visited.containsKey(parentTrack.get(current))){
                    q.add(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true); // mark parent as visited
                }
            }
        }
        
        List<Integer> ans  = new ArrayList<>();
        // q.poll();
        while(!q.isEmpty()){
            TreeNode node  = q.poll();
            
            // remove the target node 
            if(node.val == target.val){
                continue;
            }
            ans.add(node.val);
        }
        
        return ans;
    }
}