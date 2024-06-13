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
    
    private void bfs(TreeNode parent, TreeNode node, HashSet<Integer> set, List<TreeNode> res ){
        
        if(node==null)
            return;
        
        if(parent==null && !set.contains(node.val)){
            res.add(node);
            
            
        }else if(set.contains(node.val)){
            
            if(parent!=null){
                // System.out.println(parent.val + " " + root.val);
                if(parent.left!=null && parent.left.val==node.val)
                    parent.left=null;
                else if(parent.right!=null && parent.right.val==node.val)
                    parent.right=null;
            }
            
            bfs(null, node.left, set ,res);
            bfs(null, node.right, set ,res);
            return;
        }
        
            
        
        bfs(node, node.left, set, res);
        bfs(node, node.right, set, res);
        
        
        
        
    }
    
}
