// https://leetcode.com/problems/minimum-depth-of-binary-tree

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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 1;
        
        while(q.size()>0){
            
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode n = q.poll();
            
                if(n.left==null && n.right==null){
                    return level;
                }
            
                if(n.left!=null)
                    q.offer(n.left);
            
                if(n.right!=null)
                    q.offer(n.right);
            }
            
            level ++;
        }
        
        return  level;
    }
}
