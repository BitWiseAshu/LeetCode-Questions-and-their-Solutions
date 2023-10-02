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
    int tilt = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        System.out.println("left -> "+ left +" right -> "+ right);

        int absolute = Math.abs(left-right);
        System.out.println("absolute -> "+absolute);
        tilt += absolute;
        System.out.println("tilt -> "+tilt);

        return left + right + root.val;
    }
}