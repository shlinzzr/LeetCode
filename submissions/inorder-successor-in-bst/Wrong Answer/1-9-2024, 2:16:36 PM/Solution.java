// https://leetcode.com/problems/inorder-successor-in-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<Integer> list = new ArrayList<>();

    TreeNode prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(root==null) return null;
        inorderSuccessor(root.left, p);

        
        // if(list.get(list.size()-1)==p){
        if(prev==p){
            return root;
        }
        prev = root;
        // list.add(root, p);
        inorderSuccessor(root.right, p);

        return null;
    }
}