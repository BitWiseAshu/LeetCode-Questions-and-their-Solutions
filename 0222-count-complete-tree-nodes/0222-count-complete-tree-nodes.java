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
    public int countNodes(TreeNode root) {
        int count[]  = {0};
        dfs(root, count);
        return count[0];
    }
    
    public void dfs(TreeNode root, int count[]){
        if(root == null){
            return;
        }
        
        count[0] ++;
        
        dfs(root.left, count);
        dfs(root.right, count);
    }
}