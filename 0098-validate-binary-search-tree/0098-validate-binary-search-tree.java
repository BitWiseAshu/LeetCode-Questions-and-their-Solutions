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
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        
        boolean ans = isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
    
    public boolean isValidBSTHelper(TreeNode root, long low, long high){
        if(root == null){
            return true;
        }
        
        if(root.val <= low || root.val >= high){
            return false;
        }
        
        boolean left = isValidBSTHelper(root.left, low, root.val);
        boolean right = isValidBSTHelper(root.right, root.val, high);
        
        return left && right;
    }
}