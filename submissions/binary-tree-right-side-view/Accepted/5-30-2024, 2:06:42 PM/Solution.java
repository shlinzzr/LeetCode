// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        helper(root, res, 1);

        return res;
        
    }

    private void helper(TreeNode node, List<Integer> res, int lv){

        if(node==null) return;

        if(res.size()<lv){
            res.add(node.val);
        }

        helper(node.right, res, lv+1);
        helper(node.left, res, lv+1);



    }
}