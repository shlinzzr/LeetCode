// https://leetcode.com/problems/add-one-row-to-tree

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root.left;
            return node;
        }

        helper(root, val, depth, 1);
        return root;
        
    }

    private void helper(TreeNode root, int val, int depth, int curDepth){

        if(root==null) return ;

        if(curDepth+1==depth){

            TreeNode left = new TreeNode(val);
            left.left = root.left;
            root.left = left;
            
            TreeNode right = new TreeNode(val);
            right.right = root.right;
            root.right = right;
            return;
        }

        helper(root.left, val, depth, curDepth+1);
        helper(root.right, val, depth, curDepth+1);

    }
}