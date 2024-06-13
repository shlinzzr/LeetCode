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
        
        
        PriorityQueue<TreeNode> pq = new PriorityQueue<>(
            (a,b) -> a.val-b.val
        );
        
        // PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
        //     (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        // );
        
        
        helper(pq, root);
        
        int res =0;
        while(k>0){
            res = pq.poll().val;
            k--;
        }
        return res;
    }
    
    private void helper(PriorityQueue<TreeNode> pq, TreeNode root){
        
        if(root==null)
            return;
        
        pq.offer(root);
        
        helper(pq, root.left);
        helper(pq, root.right);
        
    }
}
