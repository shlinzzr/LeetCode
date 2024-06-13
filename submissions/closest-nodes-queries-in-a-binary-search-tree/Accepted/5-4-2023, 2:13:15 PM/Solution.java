// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree

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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
      
        TreeSet<Integer> set = new TreeSet<>();
        helper(root, set);
        
        int siz = queries.size();
        List<List<Integer>>  res = new ArrayList<>();
        for(int q : queries){
            
            int flo = set.floor(q)==null ? -1 : set.floor(q);
            int cel = set.ceiling(q)==null ? -1 : set.ceiling(q);
            
            res.add(Arrays.asList(flo, cel));
        }
        
        return res;
        
    }
    
    private void helper(TreeNode root, TreeSet<Integer> set  ){
        if(root==null)
            return;
        
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }
}
