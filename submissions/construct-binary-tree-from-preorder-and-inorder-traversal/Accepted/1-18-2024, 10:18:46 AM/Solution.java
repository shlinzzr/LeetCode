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
        int len = preorder.length;
        
        Map<Integer, Integer> map = new HashMap<>();// val, idx
        for(int i=0; i<len;i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, len-1, inorder, 0, len-1, map);
        
        
    }
    
    private TreeNode helper(int[]preorder, int pst, int ped, int[] inorder, int ist, int ied,  Map<Integer, Integer> map ){
        int len = preorder.length;
              
        if(len==0 || pst>ped || ist>ied )
            return null;
        
        int rootVal = preorder[pst];
        int idx = map.get(rootVal);
        int leftCnt = idx-ist;
        
        TreeNode root = new TreeNode(rootVal);
  
        root.left = helper(preorder, pst+1, pst+leftCnt, inorder, ist, idx-1, map);
        root.right = helper(preorder, pst+1+leftCnt, ped, inorder, idx+1, ied, map);
        
        return root;
        
    }
}