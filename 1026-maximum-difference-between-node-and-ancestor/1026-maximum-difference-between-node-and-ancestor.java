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
class Solution {
    public int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
    
    public void dfs(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        ans = Math.max(ans, Math.abs(max - min));
        
        dfs(root.left, min, max);
        dfs(root.right, min, max);
         
    }
}