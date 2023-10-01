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

    public int sumNumbersHelper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            sum = sum * 10 + root.val;
            return sum;
        }

        sum = sum * 10 + root.val;
        int left = sumNumbersHelper(root.left, sum);
        int right = sumNumbersHelper(root.right, sum);

        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
}