// https://leetcode.com/problems/largest-bst-subtree

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

    int res = 0 ;
    public int largestBSTSubtree(TreeNode root) {

        if(root==null) return 0;

        helper(root);

        return res;
    }

    private int helper(TreeNode root){
        if(root==null) return 0;

        boolean flag = true;

        if(root.left!=null){
            TreeNode node = root.left;
            while(node.right!=null) node = node.right;
            if(node.val>= root.val) 
                flag = false;
        }

        if(root.right!=null){

            TreeNode node = root.right;
            while(node.left!=null) node= node.left;
            if(node.val<=root.val)
                flag = false;
        }

        int leftVal = helper(root.left);
        int rightVal = helper(root.right);

        if(flag==false || leftVal==-1 || rightVal==-1) return -1;

        res = Math.max(res, leftVal+rightVal+1);

        return leftVal+rightVal+1;
        

        // if(node.left!=null && (node.left.val>node.val || node.left.val<lo ) return -1;
        // if(node.right!=null && (node.right.val<node.val || node.right.val>hi ) return -1;

        // int left = helper(node.left, )

         
    }
}