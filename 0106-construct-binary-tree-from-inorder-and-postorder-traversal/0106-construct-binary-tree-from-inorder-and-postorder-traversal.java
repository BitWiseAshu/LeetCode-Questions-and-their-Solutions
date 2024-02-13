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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n  = postorder.length;
        
        Stack<Integer> st  = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < postorder.length; i++){
            st.push(postorder[i]);
        }

        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        TreeNode root = buildTreeHelper(map, st, 0, n-1);
        return root;
    }
    
    public TreeNode buildTreeHelper(HashMap<Integer, Integer> map, Stack<Integer> st, int start, int end){
        if(start > end){
            return null;
        }
        
        int num = st.pop();
        int index = map.get(num);
        
        TreeNode root = new TreeNode(num);
        root.right = buildTreeHelper(map, st, index+1, end);
        root.left = buildTreeHelper(map, st, start, index-1);
        
        return root;
    }
    
}