// https://leetcode.com/problems/find-all-the-lonely-nodes

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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        helper(root, res, false);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res, boolean isLonely){
        if(node==null) return;

        if(isLonely) res.add(node.val);


        
        helper(node.left, res, node.right==null);
        helper(node.right, res, node.left==null);
    }
}