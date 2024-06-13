// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int rootVal = preorder[0];
        

        if(preorder.length==1){
            TreeNode head = new TreeNode(rootVal);
            return head;
                
        }
        
        
        int leftTreeSize =0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==rootVal)
                leftTreeSize = i;
        }
        
        
        int[] leftPre =  Arrays.copyOfRange(preorder, 1, leftTreeSize+1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, leftTreeSize);
        
        int[] rightPre = Arrays.copyOfRange(preorder, leftTreeSize+1, inorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, leftTreeSize+1, inorder.length);
        
        
        TreeNode head = new TreeNode(rootVal, 
                                     buildTree(leftPre, leftIn),
                                     buildTree(rightPre, rightIn));
                                     
        
        
        return head;
    }
    
}