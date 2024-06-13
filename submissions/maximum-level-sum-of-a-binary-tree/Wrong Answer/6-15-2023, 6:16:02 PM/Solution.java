// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

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
    public int maxLevelSum(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 1);
        
        int max = 0, lv=0;
        
        for(int i=0; i<res.size(); i++){
            
            
            List<Integer> list = res.get(i);
            
            int sum = 0;
            for(int s : list){
                sum+=s;
            }
            
            if(sum>max){
                max = sum;
                lv = i+1;
            }
            
        }
        
        return lv;
        
        
        
    }
    
    private void helper(TreeNode root, List<List<Integer>>  res, int lv){
        
        if(root==null)
            return;
        
        if(res.size()<lv)
            res.add(new ArrayList<>());
        
        res.get(lv-1).add(root.val);
        
        helper(root.left, res, lv+1);
        helper(root.right, res, lv+1);
        
    }
}