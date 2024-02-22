// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

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
    public TreeNode bstToGst(TreeNode root) {
        
        
        dfs(root, 0);
        
        return root;
    }
    
    private int dfs(TreeNode curr, int cnt){
        
        if(curr==null)
            return 0;
        
        int right = dfs(curr.right, cnt);
        
        int total = curr.val + right ;
        
        curr.val = total + cnt;
        
        total += dfs(curr.left, curr.val);
        
        return total;
        
    }
}