// https://leetcode.com/problems/recover-binary-search-tree

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

    // 因為要找出 "亂序的" node -> 想到的是 inorder print node 會是sorted

    //  [1,3,null,null,2] => "3 2" 1,     3 "2 1" 
    //              first==prev curr.          second

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;


    
    // List<TreeNode> candidate = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){

        if(root==null) return ;

        inorder(root.left);

        if(first==null && prev.val>=root.val){
            first = prev;
        }

        if(first!=null && prev.val >= root.val){
            second = root;
        }

        prev = root;

        inorder(root.right);

    }
}