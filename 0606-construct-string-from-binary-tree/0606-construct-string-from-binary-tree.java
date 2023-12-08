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
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }

        String s = Integer.toString(root.val);

        if(root.left == null && root.right == null){
            return s;
        }

        // This is for left side whether left is null or not is does not matter
        s += "(" + tree2str(root.left) + ")";

        // if right is not null then call right side else not (According to question)
        if(root.right != null){
            s += "(" + tree2str(root.right) + ")";
        }

        return s;
    }
}