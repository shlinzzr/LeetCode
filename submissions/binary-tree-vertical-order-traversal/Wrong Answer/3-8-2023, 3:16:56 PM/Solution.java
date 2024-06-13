// https://leetcode.com/problems/binary-tree-vertical-order-traversal

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
    
    int min = 100;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<200; i++){
            res.add(new ArrayList<>());
        }
     
        
        
        helper(root, res, 100);
        
        while(res.get(0).size()==0)
            res.remove(0);
        
        int i=0;
        while(res.get(i).size()!=0){
            i++;
        }
        while(i<res.size() && res.get(i).size()==0)
            res.remove(i);
        
        
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, int lv){
        
         res.get(lv).add(root.val);
        
        if(root.left!=null){
            
            min = Math.min(min, lv-1);
            helper(root.left, res, lv-1);
            
        }
        
       
        
        if(root.right!=null){
            helper(root.right, res, lv+1);
        }
    }
}