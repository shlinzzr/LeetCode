// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         if(root==null)
//             return null;
        
//         if(root==p && root==q)
//             return root;
        
//         boolean pIsLeft = isAncestor(root.left, p);
//         boolean qIsRight = isAncestor(root.right, q);
        
//         while(!(pIsLeft && qIsRight)){
            
            
            
            
//             if( pIsLeft && !qIsRight)
//                 root= root.left;
//             else{
//                 root=root.right;
//             }
            
            
            
//             pIsLeft = (root.left ==null) false : isAncestor(root.left, p);
//             qIsRight = isAncestor(root.right, q);
            
//         }
        
//         return root;
        
       
        
//     }
    
    
//     private boolean isAncestor(TreeNode root, TreeNode p){
        
//         if(root==null)
//             return false;
        
//         if(root==p)
//             return true;
        
//         return isAncestor(root.left, p) || isAncestor(root.right, p);
//     }
// }


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
