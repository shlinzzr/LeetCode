// https://leetcode.com/problems/path-sum

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> st = new Stack<TreeNode>();

        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode curr = st.pop();

            
            if(curr.left==null && curr.right==null){
                
                if(curr.val==targetSum)
                    return true;

            }
            
            if(curr.left!=null){
                st.push(curr.left);
                curr.left.val += curr.val;
            }
            if(curr.right!=null){
                st.push(curr.right);
                curr.right.val += curr.val;
            }
                
            
        }
        
        return false;
        
    }
}