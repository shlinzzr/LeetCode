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
    
    int res=0;
    
    public int pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum, new ArrayList<>());
        return res;
    
    }
    
    private void helper(TreeNode root, long t, List<Integer> list ){
        
        if(root==null)
            return;
        
        // if(root.val==t)
        //     res++;
        
        
        List<Integer> list2 = new ArrayList<>();
        
        for(int n:list){
            if(n+root.val==t)
                res++;
            
            list2.add(n+root.val);
        }
        
        list2.add(root.val);
        helper(root.left, t, list2);
        helper(root.right, t, list2);
    }
    
}