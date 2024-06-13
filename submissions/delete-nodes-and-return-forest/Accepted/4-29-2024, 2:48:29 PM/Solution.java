// https://leetcode.com/problems/delete-nodes-and-return-forest

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        for(int d: to_delete)
            set.add(d);
        
        bfs(null, root, set, res);
        
        return res;
    }
    
    private void bfs(TreeNode parent, TreeNode root, HashSet<Integer> set, List<TreeNode> res ){
        
        if(root==null)
            return;
        
        if(parent==null && !set.contains(root.val)){
            res.add(root);
            
            
        }else if(set.contains(root.val)){
            
            if(parent!=null){
                // System.out.println(parent.val + " " + root.val);
                if(parent.left!=null && parent.left.val==root.val)
                    parent.left=null;
                else if(parent.right!=null && parent.right.val==root.val)
                    parent.right=null;
            }
            
            bfs(null, root.left, set ,res);
            bfs(null, root.right, set ,res);
            return;
        }
        
            
        
        bfs(root, root.left, set, res);
        bfs(root, root.right, set, res);
        
        
        
        
    }
    
}