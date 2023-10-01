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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }
    
    int cnt = 0;
    public TreeNode kthSmallestHelper(TreeNode root, int k){
        if(root == null){
            return null;
        }

        TreeNode left = kthSmallestHelper(root.left, k);
        if(left != null){
            return left;
        }
        cnt ++;

        if (cnt == k){
            return root;
        }

        return kthSmallestHelper(root.right, k);
        
    }
}