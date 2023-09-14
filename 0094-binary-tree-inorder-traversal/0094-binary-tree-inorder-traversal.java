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