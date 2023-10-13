//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int floor(Node root, int x) {
        int ans = -1; // Initialize ans within the function
        return floorHelper(root, x, ans);
    }
    
    public static int floorHelper(Node root, int x, int ans) {
        if (root == null) {
            return ans;
        }
        
        if (root.data <= x) {
            ans = Math.max(ans, root.data); // Update ans if we find a closer floor value
        }
        
        if (root.data > x) {
            // If the current node is greater than x, we need to look in the left subtree
            return floorHelper(root.left, x, ans);
        }
        
        // If the current node is less than or equal to x, we continue searching in the right subtree
        return floorHelper(root.right, x, ans);
    }
}
