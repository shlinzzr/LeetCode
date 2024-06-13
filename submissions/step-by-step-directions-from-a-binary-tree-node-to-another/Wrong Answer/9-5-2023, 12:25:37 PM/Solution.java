// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another

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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb = new StringBuilder();
        
        helper(root, sb, startValue);
        
        helper2(root, sb, destValue);
        return sb.toString();
        
    }
    
    private boolean helper2(TreeNode root, StringBuilder sb, int target){
        if(root==null)
            return false;
        
        
        if(root.val==target)
            return true;
        
        if(root.left!=null){
            sb.append("L");
            if(helper2(root.left, sb, target))
                return true;
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(root.right!=null){
            sb.append("R");
            if(helper2(root.right, sb, target))
                return true;
            sb.deleteCharAt(sb.length()-1);
        }     
        
        return false;
        
    }
    
    
    
    private boolean helper(TreeNode root, StringBuilder sb, int target){
        
        if(root==null)
            return false;
        
        if(root.val==target)
            return true;
        
        
        if(root.left!=null){
            sb.append("U");
            if(helper(root.left, sb, target))
                return true;
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(root.right!=null){
            sb.append("U");
            if(helper(root.right, sb, target))
                return true;
            sb.deleteCharAt(sb.length()-1);
        }        
        
        return false;
        
    }
}
