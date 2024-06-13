// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    
    PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(
        (a,b) -> b.val-a.val
    );
    
    public int kthSmallest(TreeNode root, int k) {
        
        helper(root, k);
        
        return pq.poll().val;
        
    }
    
    private void helper(TreeNode root, int k){
        
        pq.offer(root);
        
        while(pq.size()>k)
            pq.poll();
        
        if(root.left!=null)
            helper(root.left, k);
            
        if(root.right!=null)
            helper(root.right, k);
        
        
    }
}