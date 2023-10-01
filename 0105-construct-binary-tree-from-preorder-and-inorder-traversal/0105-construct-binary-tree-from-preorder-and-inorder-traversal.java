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
    
    // 1st method
    /*

    public int findPosition(int []inorderArr, int element){
        for(int i = 0 ; i < inorderArr.length; i++){
            if(inorderArr[i] == element){
                return i;
            }
        }

        return -1;
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preOrderIndex, int inOrderStart, int inOrderEnd, int n){
        if(preOrderIndex >= n || inOrderStart > inOrderEnd){
            return null;
        }

        int element = preorder[preOrderIndex];
        TreeNode root = new TreeNode(element);
        int position = findPosition(inorder, element);
        int leftSubtreeSize = position - inOrderStart; // Size of the left subtree

        root.left = buildTreeHelper(preorder, inorder, preOrderIndex+1, inOrderStart, position-1, n);
        root.right = buildTreeHelper(preorder, inorder, preOrderIndex+leftSubtreeSize+1, position+1, inOrderEnd, n);

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int preOrderIndex = 0;
        TreeNode ans = buildTreeHelper(preorder, inorder, preOrderIndex, 0, n-1, n);
        return ans;
    }
    */
    
    
    
    // 2nd method 
    
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        inorderIndexMap = new HashMap<>();

        // Populate the index map for elements in the inorder array
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        
        TreeNode ans = buildTreeHelper(preorder, 0, n - 1);
        return ans;
    }

    private TreeNode buildTreeHelper(int[] preorder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        int element = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(element);
        int position = inorderIndexMap.get(element);
        root.left = buildTreeHelper(preorder, inOrderStart, position - 1);
        root.right = buildTreeHelper(preorder, position + 1, inOrderEnd);

        return root;
    }

    private int preOrderIndex = 0; // Store the current index in the preorder array
}