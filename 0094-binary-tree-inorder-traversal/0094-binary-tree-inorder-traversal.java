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


// Using Recursion preorder
/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return inOrderTraversalHelper(root, ans);
    }

    public List<Integer> inOrderTraversalHelper(TreeNode root, List<Integer> ans){
        if(root != null){
            inOrderTraversalHelper(root.left, ans);
            ans.add(root.val);
            inOrderTraversalHelper(root.right, ans);
        }

        return ans;
    }
}
*/




// Using Morris Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        TreeNode current = root;
        
        while(current != null){
            if(current.left == null) {
                inOrder.add(current.val);
                current = current.right;
            }
            else{
                TreeNode prev = current.left;
                
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                }
                else{
                    prev.right = null;
                    inOrder.add(current.val);
                    current  = current.right;
                }
            }
        }
        
        return inOrder;
    }
}