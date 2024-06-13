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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> pq =new PriorityQueue<>(
            (a, b) -> b.val-a.val
        );
        
        helper(root, pq, k);
        
        return pq.poll().val;
        
    }
    
    private void helper(TreeNode root,  PriorityQueue<TreeNode> pq, int k){
        if(root==null)
            return;
        
        pq.offer(root);
        while(pq.size()>k)
            pq.poll();
        
        helper(root.left, pq, k);
        helper(root.right, pq, k);
        
    }
}