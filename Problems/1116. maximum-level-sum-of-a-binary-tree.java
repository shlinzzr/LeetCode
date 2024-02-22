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
        
        
        List<List<Long>> list =new ArrayList<>();
        helper(root, 1, list);
        
        int lv = 0;
        long max = Long.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            
            List<Long> row = list.get(i);
            
            int sum = 0;
            for(long r : row){
                sum+=r;
            }
            
            if(sum>max){
                lv =i+1;
                max = Math.max(max, sum);
                
            }
            
            
            
        }
        
        return lv;
        
        
    }
    /*
    -100
  -200 -300
-20  -5 -10 null
    */
    
    private void helper(TreeNode root, int lv, List<List<Long>> list){
        
        if(root==null)
            return;
        
        if(list.size()<lv)
            list.add(new ArrayList<>());
        
        list.get(lv-1).add((long)root.val);
        
        helper(root.left, lv+1, list);
        helper(root.right, lv+1, list);
    }
}