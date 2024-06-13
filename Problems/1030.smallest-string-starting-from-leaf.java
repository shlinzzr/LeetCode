// https://leetcode.com/problems/smallest-string-starting-from-leaf

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
    String res = null;
    public String smallestFromLeaf(TreeNode root) {

        helper(root, "");

        return res;
        
    }

    private void helper(TreeNode root, String cur){
        if(root==null) return ;

        cur = (char)(root.val+'a') + cur;

        if(root.left==null && root.right==null){
            

            if(res==null) 
                res= cur;
            else if(res.compareTo(cur)>0){
                res = cur;   
            }
            return;
        }

        helper(root.left, cur);
        helper(root.right, cur);

        

    }
}