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
    public int widthOfBinaryTree(TreeNode root) {
        
        // use bfs trace by level;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int max = 0;
        
        while(!q.isEmpty()){
                
            max = Math.max(max, q.size());
            
            for(int i=q.size(); i>0; i--){
                
                TreeNode n  = q.poll();
                if(n==null)
                    continue;
                
                if(n.left==null && n.right==null)
                    continue;
                
                q.add(n.left);
                q.add(n.right);
                
            }
            
        }
        

        return max;
        
        
    }
    
}