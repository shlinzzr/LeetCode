// https://leetcode.com/problems/inorder-successor-in-bst

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

     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        return predeccessor(root, p);
     }

     private TreeNode successor(TreeNode node, TreeNode p){
        if(node==null) return null;

        if(p.val>=node.val){
            return successor(node.right, p);
        }else{
            TreeNode left = successor(node.left, p);
            return left!=null ? left : node;
        }

        

     }


    private TreeNode predeccessor(TreeNode node, TreeNode p){
        if(node==null) return null;

        if(p.val<=node.val){
            return predeccessor(node.left, p);
        }else{
            TreeNode right = predeccessor(node.right, p);
            return right!=null ? right : node;
        }
     }

    // O(n) : n is total # of tree
    // TreeNode prev;
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
    //     if(root==null) return null;
        
    //     TreeNode left = inorderSuccessor(root.left, p);
    //     if(left!=null) return left;
        
    //     if(prev==p)
    //         return root;
        
        
    //     prev = root;
    //     TreeNode right = inorderSuccessor(root.right, p);
    //     if(right!=null) return right;
        
    //     return null;
        
    // }
}