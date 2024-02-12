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

// class Pair{
//     TreeNode node;
//     int idx;
    
//     Pair(TreeNode node, int idx){
//         this.node = node;
//         this.idx = idx;
//     }
// }

// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         Queue<Pair> q = new LinkedList<>();
//         int ans = Integer.MIN_VALUE;
        
//         q.add(new Pair(root, 0));
        
//         while(!q.isEmpty()){
//             int size = q.size();
            
//             int leftmost = q.getFirst().idx;
//             int rightmost = q.getLast().idx;
            
//             ans = Math.max(ans, (rightmost - leftmost + 1));
            
//             for(in ti = 0 ; i  < size; i++){
//                 Pair front = q.removeFirst();
//                 TreeNode node=  front.node;
//                 int idx = front.idx;
                
//                 if(front.left != null){
//                     q.add(new Pair(front.left, 2*idx + 1));
//                 }
                
//                 if(front.right != null){
//                     q.add(new Pair(front.right, 2*idx + 2));
//                 }
//             }
//         }
        
//         return ans;
//     }
// }





class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<pair> q = new LinkedList<>();

        int max = Integer.MIN_VALUE;

        if(root==null) return 0;

        q.addLast(new pair(root,0));

        while(!q.isEmpty())
        {
            int size = q.size();
            max = Math.max(max, (q.getLast().level - q.getFirst().level +1));

            for(int i=0;i<size;i++)
            {
                pair element = q.removeFirst();

                if(element.root.left!=null)
                q.addLast(new pair(element.root.left,2*element.level));

                if(element.root.right!=null)
                q.addLast(new pair(element.root.right,2*element.level+1));
            }
        }
return max;

    }


static class pair {
    int level;
    TreeNode root;
    public pair(TreeNode root, int level)
    {
        this.level=level;
        this.root=root;
    }
}
}