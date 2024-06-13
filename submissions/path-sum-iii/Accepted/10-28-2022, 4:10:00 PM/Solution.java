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
        HashMap<Long, Integer> map = new HashMap<>(); // val, 出現次數
        
        helper(root, targetSum, 0L, map);
        return cnt;
    }
    
    
    private void helper(TreeNode root, int targetSum, long curr, HashMap<Long, Integer> map ){
        
        if(root==null)
            return;
        
        System.out.println(root.val);
        
        curr+=root.val;

        if(curr==targetSum)
            cnt++;
        
        if(map.containsKey(curr - targetSum))
            cnt+=map.get(curr-targetSum);
        
        map.put(curr, map.getOrDefault(curr, 0)+1);
        
        helper(root.left, targetSum, curr, map);
        helper(root.right, targetSum, curr, map);
        map.put(curr, map.get(curr)-1);
        
        
    }
}