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
    /*
    public int maxDepth(TreeNode root) {
        int height = 0;
        List<Integer> list = new ArrayList<>();
        maxDepthHelper(root, list, height);
        return Collections.max(list);
    }
    
    public void maxDepthHelper(TreeNode root, List<Integer> list, int height){
        if(root == null){
            list.add(height);
            return;
        }
        
        maxDepthHelper(root.left, list, height+1);
        maxDepthHelper(root.right, list, height + 1);
    }
    
    */
    
    
    // Another Solution
    
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 +(Math.max(left, right));

        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}