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
    
    // This is a Recursive Solution
    /*
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
    */
    
    
    
    // Using Satck  
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null){
            return list;
        }
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode currentNode = st.pop();
            list.add(currentNode.val);
            
            // Push the right child first (if exists) so that it will be processed after the left child
            if(currentNode.right != null){
                st.push(currentNode.right);
            }
            
            if(currentNode.left != null){
                st.push(currentNode.left);
            }
            
        }
        
        return list;
    }
    */
    
    
    // Using Morris preOrder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<Integer>();
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                preOrder.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = curr;
                    preOrder.add(curr.val);
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return preOrder;
    }

}