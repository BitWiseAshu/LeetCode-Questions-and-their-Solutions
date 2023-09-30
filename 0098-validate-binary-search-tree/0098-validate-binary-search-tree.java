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
        
        boolean ans = isValidBSTHelper(root, null, null);
        return ans;
    }
    
    public boolean isValidBSTHelper(TreeNode root, TreeNode low, TreeNode high){
        
        if(root == null){
            return true;
        }
        
        if(low != null){
            if(root.val <= low.val){
                return false;
            }
        }
        if(high != null){
            if(root.val >= high.val){
                return false;
            }
        }
        
        boolean left = isValidBSTHelper(root.left, low, root);
        boolean right = isValidBSTHelper(root.right, root, high);
        
        return left && right;
        
        
        /*
        if(root.left == null && root.right == null){
            return true;
        }
        
        if(root.left == null && root.right != null){
            if(root.right.val <= root.val){
                return false;
            }
        }
        if(root.right == null && root.left != null){
            if(root.left.val >= root.val){
                return false;
            }
        }
        
        if(root.left.val >= root.val || root.right.val <=root.val){
            return false;
        }
        
        boolean left = isValidBSTHelper(root.left);
        boolean right = isValidBSTHelper(root.right);
        
        return left && right;
        */
    }
}