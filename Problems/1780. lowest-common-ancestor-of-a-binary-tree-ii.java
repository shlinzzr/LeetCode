// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    boolean pFound, qFound;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
        
//         if(root==p || root==q || root==null)
//             return root;
        
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
        
//         if(left!=null && right!=null)
//             return root;
        
//         if(left==null && right==null)
//             return null;
        
//         return left==null? right : left;    
        
//     }
        
        
    }
    
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) 
            return root;
        
        TreeNode left = LCA(root.left, p, q);     
        TreeNode right = LCA(root.right, p, q);
        
        if(left!=null && right!=null)
            return root;
        
        if (root == p) {
            pFound = true;
            return root;
        }
        if (root == q) {
            qFound = true;
            return root;
        }
        
        return left==null? right : left;    
    }
    
    
}