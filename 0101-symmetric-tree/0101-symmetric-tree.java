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
    // 1st Solution
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            
            if(leftNode == null && rightNode == null){
                continue;
            }
            
            if((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null)){
                return false;
            }
            
            if(leftNode.val != rightNode.val){
                return false;
            }
            
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        
        return true;
    }
    
    */
    
    
    
    // 2nd Solution
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode leftNode ,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }

        if((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null)){
            return false;
        }

        if(leftNode.val != rightNode.val){
            return false;
        }

        return isSymmetricHelper(leftNode.left, rightNode.right) && isSymmetricHelper(leftNode.right ,rightNode.left);
    }

}