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
        
        List<Integer> list = new ArrayList<>();
        
        helper(root, list, 0);
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)>max){
                max = list.get(i);
                res= i;
            }
        }
        
        return res+1;
        
    }
    
    private void helper(TreeNode node, List<Integer> list, int lv){
        
        if(node==null) return; 
        
        if(list.size()<lv+1){
            list.add(node.val);
        }else{
            int val = list.get(lv);
            list.set(lv, val+node.val);
        }
        
        helper(node.left, list, lv+1);
        helper(node.right, list, lv+1);
        
    }
}