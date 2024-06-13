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

    // 1:pq, 2:recur, 3:stack

    // // 1.pq
    // public int kthSmallest(TreeNode root, int k) {
    //     PriorityQueue<TreeNode> pq =new PriorityQueue<>( (a, b) -> b.val-a.val );
    //     helper(root, pq, k);
    //     return pq.poll().val;
    // }
    
    // private void helper(TreeNode root,  PriorityQueue<TreeNode> pq, int k){
    //     if(root==null)
    //         return;
        
    //     pq.offer(root);
    //     while(pq.size()>k)
    //         pq.poll();
        
    //     helper(root.left, pq, k);
    //     helper(root.right, pq, k);
    // }


    // 2.recur
    int cnt = 0;
    int res =0 ;
    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        recur(root);
        return res;
    }
    private void recur(TreeNode node){

        if(node.left!=null) recur(node.left);
        cnt--;
        if(cnt==0){
            res=node.val;
            return;
        }
        if(node.right!=null) recur(node.right);
    }


    // // stack
    // public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     stack.push(root);
    //     TreeNode node = root;
    //     int count = 0;
    //     // node == null, might get to the leaf but stack is not empty
    //     while(node!=null || !stack.isEmpty()){
    //         while(node!=null){
    //             stack.push(node);
    //             node = node.left;
    //         } 
    //         node = stack.pop();
    //         count++;
    //         if(count==k) return node.val;
    //         node = node.right;
    //     }
    //     return -1;
    // }
}