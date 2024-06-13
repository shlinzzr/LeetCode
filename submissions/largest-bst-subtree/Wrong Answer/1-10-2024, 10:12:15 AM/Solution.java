// https://leetcode.com/problems/largest-bst-subtree

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
    List<TreeNode> list = new ArrayList<>();
    public int largestBSTSubtree(TreeNode root) {
        helper(root);

        int st=0, ed=list.size()-1;

        while(st<ed){
            int mid = st+(ed-st)/2;
            if(list.get(mid).val==root.val){
                return list.size() - mid -1;
            }else if(list.get(mid).val > root.val){
                ed = mid-1;

            }else 
                st = mid+1;
        }

        return list.size()-st;
    }

    private void helper(TreeNode root){
        if(root==null) return ;
        
        helper(root.left);
        list.add(root);
        helper(root.right);
    }
}