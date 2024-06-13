// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
    
    int max=0;
    
    public int maxPathSum(TreeNode root) {
        
        
        int sum = helper(root);
        max = Math.max(max, sum);
        
        return max;
        
    }
    
    private int helper(TreeNode root){
        
        
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return root.val;
        
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        
        max = Math.max(max, left+right+root.val);
        
        
        return left + right + root.val;
    }
    
    
    
    private void genMap(TreeNode parent, TreeNode root, HashMap<TreeNode, Set<TreeNode>> map){
        
        if(root==null){
            return;
        }
        
        if(!map.containsKey(root))
            map.put(root, new HashSet<>());
        
        if(parent!=null)
            map.get(root).add(parent);
        
        if(root.left!=null);
            map.get(root).add(root.left);
        
        if(root.right!=null);
            map.get(root).add(root.right);
        
        genMap(root, root.left, map); 
        genMap(root, root.right, map); 
        
    }
}