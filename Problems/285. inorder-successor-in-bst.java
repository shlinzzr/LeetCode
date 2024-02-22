// https://leetcode.com/problems/inorder-successor-in-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        
        for(int i=0; i<list.size(); i++){
            TreeNode n  = list.get(i);
            if(n.val==p.val){
                return (i+1)>=list.size()? null : list.get(i+1);
            }
        }
        return null;
        
        
    }
    
    private void dfs(TreeNode root, List<TreeNode> list){
        if(root==null)
            return ;
        
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}