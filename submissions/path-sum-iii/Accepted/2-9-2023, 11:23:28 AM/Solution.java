// https://leetcode.com/problems/path-sum-iii

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
    int cnt=0;
    public int pathSum(TreeNode root, int targetSum) {
        helper(root, new ArrayList<>(), targetSum);
        return cnt;
    }
    
    private void helper(TreeNode root, List<Integer> list, int t){
        
        if(root==null)
            return ;
        
        list.add(root.val);
        long sum=0;
        for(int i=list.size()-1; i>=0; i--){
            
            sum+=Long.valueOf(list.get(i));
            if(sum==t)
                cnt++;
        }
        
        helper(root.left, list, t);
        helper(root.right, list, t);
        
        list.remove(list.size()-1);
        
        
        
    }
}