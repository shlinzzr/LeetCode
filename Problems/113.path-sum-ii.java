// https://leetcode.com/problems/path-sum-ii

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res= new ArrayList<>();
        if(root==null && targetSum==0) return res;

        helper(root, new ArrayList<>(), res, targetSum);
        return res;
    }

    private void helper(TreeNode node, List<Integer> curr, List<List<Integer>> res, int target){
        if(node==null) return;
        if(node.left==null && node.right==null){
            if(node.val==target){
                curr.add(node.val);
                res.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
            return;
        }

        curr.add(node.val);
        helper(node.left, curr, res, target-node.val);
        helper(node.right, curr, res, target-node.val);
        curr.remove(curr.size()-1);
    }
}