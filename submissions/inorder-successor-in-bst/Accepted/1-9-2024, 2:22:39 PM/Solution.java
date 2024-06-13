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
        TreeNode left  = inorderSuccessor(root.left, p);
        if(left!=null) return left;

        System.out.println( (prev==null ? "null" : p.val) + " " +root.val + " "  + (prev==p));
        // if(list.get(list.size()-1)==p){
        if(prev==p){
            return root;
        }
        prev = root;
        // list.add(root, p);
        TreeNode right = inorderSuccessor(root.right, p);
        if(right!=null) return right;

        return null;
    }
}