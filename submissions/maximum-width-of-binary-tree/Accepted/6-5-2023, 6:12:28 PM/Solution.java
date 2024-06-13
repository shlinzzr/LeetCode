// https://leetcode.com/problems/maximum-width-of-binary-tree

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
    
    int max = 0;
    int min = 0;
    public int widthOfBinaryTree(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        helper(root, 0, list, 0);
        
        
        for(List<Integer> sub: list){
             // Collections.sort(sub);
            max = Math.max(max, sub.get(sub.size()-1) - sub.get(0)+1);
        }
        
        return max;
        
        
    }
    
    
    private void helper(TreeNode root, int idx, List<List<Integer>> list, int lv){
        
        if(root==null)
            return;
        
        if(list.size()<lv+1)
            list.add(new ArrayList<>());
        
        list.get(lv).add(idx);
        
        helper(root.left, 2*idx+1, list, lv+1);
        helper(root.right, 2*idx+2, list, lv+1);
        
        
    }
}
