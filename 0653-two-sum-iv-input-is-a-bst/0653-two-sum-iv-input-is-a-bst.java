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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        
        inOrder(root, list);
        
        int i = 0;
        int j = list.size()-1;
        
        while(i < j){
            if(list.get(i)+list.get(j) == k){
                return true;
            }
            else if(list.get(i)+list.get(j) > k){
                j--;
            }
            else if(list.get(i)+list.get(j) < k){
                i++;
            }
        }
        
        return false;
    }
    
    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}