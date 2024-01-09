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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if((root1 == null && root2 == null) ){
            return true;
        }
        
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        
        // leafSimilar(root1, root2, l1, l2);
        leafSimilarForRoot(root1, l1);
        leafSimilarForRoot(root2, l2);
        return l1.equals(l2) ? true : false;
    }
    
    public void leafSimilarForRoot(TreeNode root, ArrayList<Integer> l){
        if(root.left == null && root.right == null){
            l.add(root.val);
            return;
        }
        
        if (root.left != null) leafSimilarForRoot(root.left, l);
        if(root.right != null) leafSimilarForRoot(root.right, l);
        
    }
}