// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree

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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        return findTarget(original, cloned, target);
        
        
        
    }
    
    private final TreeNode findTarget(TreeNode org, TreeNode cld, TreeNode target){
        
        if(org==null)
            return null;
        
        if(org==target)
            return cld;
        
        TreeNode left = findTarget(org.left, cld.left, target);
        TreeNode right = findTarget(org.right, cld.right, target);
        
        if(left!=null)
            return left;
        else 
            return right;
        
        
        
        
    }
    
}