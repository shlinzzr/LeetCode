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
    
    List<List<Integer>> list = new ArrayList<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        
        helper(root, 0, 0);
        
        int max = 0;
        for(List<Integer> sub : list){
            Collections.sort(sub);
            int width = sub.get(sub.size()-1) - sub.get(0) +1;
            max = Math.max(max, width) ;
        }
        return max;
        
    }
    
    private void helper(TreeNode root, int idx, int level){
        
        
        if(root==null)
            return;
        
        if(list.size()<level+1){
            list.add(new ArrayList<>());
        }
        
        list.get(level).add(idx);
        
        helper(root.left, 2*idx+1, level+1);
        helper(root.right, 2*idx+2, level+1);
        
    }
}