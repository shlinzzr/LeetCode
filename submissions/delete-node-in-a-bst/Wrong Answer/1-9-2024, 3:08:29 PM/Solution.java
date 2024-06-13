// https://leetcode.com/problems/delete-node-in-a-bst

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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(root.val>key){
            root.right = deleteNode(root.right, key);
        }else { // found the delete node
            if(root.left==null){
                return root.right;
            }else if (root.right==null)
                return root.left;
            
            // a node who has two children, retrun the min of right tree
            root.val  = getMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int getMin(TreeNode node){
        
        while(node.left!=null){
            node = node.left;
        }
        return node.val;
    }
}