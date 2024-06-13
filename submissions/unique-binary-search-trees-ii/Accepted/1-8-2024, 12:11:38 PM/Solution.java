// https://leetcode.com/problems/unique-binary-search-trees-ii

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
    public List<TreeNode> generateTrees(int n) {

        return helper(1, n);
        
    }

    private List<TreeNode> helper(int left, int right){

        List<TreeNode> res = new ArrayList<>();

        if(left>right){
            res.add(null);
            return res;
        }

        for(int i=left; i<=right; i++){

            List<TreeNode> leftSub = helper(left, i-1);
            List<TreeNode> rightSub = helper(i+1, right);

            for(TreeNode l : leftSub){
                for(TreeNode r : rightSub){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;

    }
}