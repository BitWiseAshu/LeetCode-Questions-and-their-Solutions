//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    // Function to return the diameter of a Binary Tree.
    /* 
    int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Calculate the diameter passing through the root
        int rootDiameter = leftHeight + rightHeight + 1;

        // Calculate the diameters of left and right subtrees recursively
        int leftSubtreeDiameter = diameter(root.left);
        int rightSubtreeDiameter = diameter(root.right);

        // Return the maximum of these three values
        return Math.max(rootDiameter, Math.max(leftSubtreeDiameter, rightSubtreeDiameter));
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        // Calculate the height of the tree recursively
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Return the maximum of left and right subtree heights plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
    */
    
    
    
    
    
    int ans = 0;
    Node root;
    int diameter(Node root) {
        height(root);
        return ans;
    }
    
    int height(Node root){
        if(root == null){
            return 0;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        ans = Math.max(ans, leftHeight + rightHeight + 1);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
