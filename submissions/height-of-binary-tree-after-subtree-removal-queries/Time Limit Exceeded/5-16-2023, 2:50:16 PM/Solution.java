// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries

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
    
    List<List<TreeNode>> list;
    int H=0;
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        int m = queries.length;
        
        int[] res = new int[m];
        
        for(int i=0; i<m; i++){
            int q = queries[i];
            res[i] = getH(root, q)-1;
        }
        
        return res;
        
    }
    
    private int getH(TreeNode root, int rm){
        
        if(root==null || root.val==rm)
            return 0;
        
        
        int left = getH(root.left, rm);
        int right = getH(root.right, rm);
        
        return Math.max(left, right)+1;
        
    }
    
}