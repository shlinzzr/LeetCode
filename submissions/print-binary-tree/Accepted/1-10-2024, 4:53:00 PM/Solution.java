// https://leetcode.com/problems/print-binary-tree

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
    public List<List<String>> printTree(TreeNode root) {
         List<List<String>> res = new ArrayList<>();
         int h = getH(root);
         int w = (int)Math.pow(2, h)-1;

         for(int i=0; i<h; i++){
             res.add(new ArrayList<>());
             for(int j=0; j<w; j++){
                 res.get(i).add("");
             }
         }

        //  helper(root, res, row, left, right);
         helper(root, res, 0, 0, w-1);

         return res;

    }


    private void helper(TreeNode root, List<List<String>> res, int row, int left, int right){
        if(root==null) return;

        int mid = left + (right-left)/2;
        res.get(row).set(mid, root.val+"");

        helper(root.left, res, row+1, left, mid-1);
        helper(root.right, res, row+1, mid+1, right);

    }

    private int getH(TreeNode node){
        if(node==null) return 0;

        int left = getH(node.left);
        int right = getH(node.right);

        return Math.max(left, right)+1;
    }
}