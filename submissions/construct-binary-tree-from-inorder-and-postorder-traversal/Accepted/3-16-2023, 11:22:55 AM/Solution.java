// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int ist, int ied, int[] postorder, int pst, int ped) {
        
        if(ist > ied || pst > ped) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[ped]);
        
        // find the root index in inorder.
        int idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                idx = i;
                break;
            } 
        }
        root.left = helper(inorder, ist, idx-1, postorder, pst, pst + (idx-1-ist));
        root.right = helper(inorder, idx+1, ied, postorder, pst + (idx-ist), ped-1);
        
        return root;
        
    }
}
