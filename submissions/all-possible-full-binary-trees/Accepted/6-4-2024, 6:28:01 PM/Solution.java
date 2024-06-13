// https://leetcode.com/problems/all-possible-full-binary-trees

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
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        List<TreeNode> res = new ArrayList<>();
        
        TreeNode root = new TreeNode();
        if(n==1) {
            res.add(root);
            return res;
        }
        
        for(int i=1; i<=n-2; i+=2){
            
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-1-i);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(0); // always new node
                    node.left = l ;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}

