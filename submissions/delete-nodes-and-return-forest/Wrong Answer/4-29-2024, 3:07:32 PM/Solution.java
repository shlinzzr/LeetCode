// https://leetcode.com/problems/delete-nodes-and-return-forest

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> set = new HashSet<>();
        for(int d : to_delete)
            set.add(d);

        List<TreeNode> res = new ArrayList<>();

        helper(null, root, set, res);

        return res;
        
    }

    private void helper(TreeNode parent, TreeNode node, Set<Integer> set, List<TreeNode> res){

        if(node==null) return;

        if(parent==null && !set.contains(node.val)){
            res.add(node);
        }

        if(set.contains(node.val)){

            
            if(parent!=null && parent.left!=null && parent.left.val==node.val){
                parent.left = null;
            }

            if(parent!=null && parent.right!=null && parent.right.val==node.val){
                parent.right = null;
            } 

            helper(null, node.left, set, res);
            helper(null, node.right, set, res);
        }

        helper(node, node.left, set, res);
        helper(node, node.right, set, res);

        

    }
}