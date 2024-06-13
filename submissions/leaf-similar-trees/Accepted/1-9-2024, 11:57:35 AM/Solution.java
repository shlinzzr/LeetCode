// https://leetcode.com/problems/leaf-similar-trees

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
    List<Integer> list = new ArrayList<>();
    int idx=0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        helper(root1, false);

        return helper(root2, true) && idx==list.size();
    }

    private boolean helper(TreeNode root, boolean chk){

        if(root==null) return true;

        if(root.left==null && root.right==null){
            
            if(chk==false)
                list.add(root.val);
            else if(idx>=list.size() || root.val!=list.get(idx++)){
                return false;
            }
        }
        boolean left = helper(root.left, chk);
        boolean right = helper(root.right, chk);

        return left&&right;
    }
}