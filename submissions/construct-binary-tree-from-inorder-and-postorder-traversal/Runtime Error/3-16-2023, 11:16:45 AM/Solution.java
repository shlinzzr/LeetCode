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
        
//         System.out.print("inorder:");
//         for(int i: inorder){
//             System.out.print(i+",");
//         }
//         System.out.println();
        
//         System.out.print("postorder:");
//          for(int i: postorder){
//             System.out.print(i+",");
//         }
//         System.out.println();
//          System.out.println();
        
        
        int len = inorder.length;
        
        if(len==0)
            return null;
        
        if(len==1){
            return new TreeNode(inorder[0]);
        }
        
        
        int pi=len-1, i = 0;
        
        //find root;
        
        int rootVal = postorder[pi];
        
        TreeNode root = new TreeNode(rootVal);
        
        while(i<len && inorder[i]!=rootVal){
            i++;
        }
        
        if(i+1<len){
            int leftVal = inorder[i+1];
            while(pi>0 && postorder[pi]!=leftVal)
                  pi--;
        }
        
        TreeNode right = buildTree(Arrays.copyOfRange(inorder, i+1, len), 
                                   Arrays.copyOfRange(postorder, pi, len-1));
        
        TreeNode left = buildTree(Arrays.copyOfRange(inorder, 0, i), 
                                  Arrays.copyOfRange(postorder, 0, pi));
        
        root.right=  right;
        root.left = left;
        return root;
        
    }
}