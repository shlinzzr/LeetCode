// https://leetcode.com/problems/maximum-width-of-binary-tree

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
    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();

        helper(list, 0, root, 0);

        int max= 0;
        for(int i=0; i<list.size(); i++){

            List<Integer> row = list.get(i);
            max = Math.max(max, row.get(row.size()-1)-row.get(0)+1);
        }

        return max;

        
    }

    private void helper( List<List<Integer>> list, int idx, TreeNode node, int lv){
        if(node==null)
            return;

        if(list.size()<lv+1){
            list.add(new ArrayList<>());
        }
        list.get(lv).add(idx);
        helper(list, idx*2+1, node.left, lv+1);
        helper(list, idx*2+2, node.right, lv+1);
    

    }
}