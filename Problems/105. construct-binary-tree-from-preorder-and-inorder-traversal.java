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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
         int len = preorder.length;
        return helper(preorder, 0, len-1, inorder, 0, len-1, map);
        
    }
    
    
    private TreeNode helper(int[] preorder, int pst, int ped, int[] inorder, int ist, int ied, HashMap<Integer, Integer> map){
        
        int len = preorder.length;
        if(len==0)
            return null;
        
        if(pst>ped || ist>ied)
            return null;
        
        int rootVal = preorder[pst];
        int rootIdx = map.get(rootVal);
        int numLeft = rootIdx-ist;
        
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, pst+1, pst+numLeft, inorder, ist,       rootIdx-1, map);
        root.right = helper(preorder, pst+numLeft+1, ped, inorder, rootIdx+1, ied,      map);
        
        return root;
        
        
    }
}