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
        
        
        int left =0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==rootVal)
                left = i;
        }
        int right = inorder.length-left -1;
        // System.out.println(right + " , " + left);
        
        int[] leftPre =  Arrays.copyOfRange(preorder, 1, left+1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, left);
        
        int[] rightPre = Arrays.copyOfRange(preorder, left+1, inorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, left+1, inorder.length);
        
        
        TreeNode head = new TreeNode(rootVal, 
                                     left <=0 ? null: buildTree(leftPre, leftIn),
                                     right <=0? null : buildTree(rightPre, rightIn));
                                     
        
        
        return head;
    }
    
}