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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = preorderTraversalHelper(root, new ArrayList<Integer>());
        return list;
    }

    public List<Integer> preorderTraversalHelper(TreeNode root, List<Integer> list){
        if(root == null){
            return list;
        }

        list.add(root.val);

        list = preorderTraversalHelper(root.left, list);
        list = preorderTraversalHelper(root.right, list);
        return list;
    }
}