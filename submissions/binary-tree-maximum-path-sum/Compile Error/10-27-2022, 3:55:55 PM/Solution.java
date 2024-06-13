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
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Set<TreeNode>> map = new HashMap<>();
        genMap(null, root, map);
        return -1;  
    }
    
    private int dfs(TreeNode root, HashMap<TreeNode, Set<TreeNode>> map){
        
        HashSet<TreeNode> seen = new HashSet<>();
        Stack<TreeNode> = 
        
        
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