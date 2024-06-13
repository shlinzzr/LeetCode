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
    int cnt = 0;
    int res =0 ;

    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        helper(root);
        return res;
    }

    private void helper(TreeNode node){

        if(node.left!=null) helper(node.left);
        cnt--;
        if(cnt==0){
            res=node.val;
            return;
        }
        if(node.right!=null) helper(node.right);
            


    }
}