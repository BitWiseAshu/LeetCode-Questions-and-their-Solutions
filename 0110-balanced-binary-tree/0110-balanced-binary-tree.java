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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        int ans = isBalancedHelper(root);
        
        return ans == -1 ? false : true;
    }
    
    public int isBalancedHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = isBalancedHelper(root.left);
        if (left == -1) {
            return -1; // Left subtree is unbalanced, no need to check further.
        }

        int right = isBalancedHelper(root.right);
        if (right == -1) {
            return -1; // Left subtree is unbalanced, no need to check further.
        }
        
        int absolute = Math.abs(left-right);
        
        if(absolute > 1){
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
}