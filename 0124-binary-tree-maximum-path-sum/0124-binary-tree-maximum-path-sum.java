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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }

        maxPathSumHelper(root);
        return ans;
    }
    
    public int maxPathSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        
        if(left < 0){
            left = 0;
        }
        if(right < 0){
            right = 0;
        }
        
        int pathSum = left + right + root.val;
        ans = Math.max(ans, pathSum);
        
        return Math.max(left, right) + root.val;
    }
}