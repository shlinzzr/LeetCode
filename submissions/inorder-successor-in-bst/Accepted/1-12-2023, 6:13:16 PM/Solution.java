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
           
        dfs(list, root);
        
        for(int i=0; i<list.size(); i++){
            
            if(list.get(i).val==p.val)
                return i+1 > list.size()-1 ? null : list.get(i+1);
        }
        
        return null;

        
    }
    
    
    private void dfs(List<TreeNode> list, TreeNode root){
                
        if(root==null)
            return;
        
        dfs(list, root.left);
        list.add(root);
        dfs(list, root.right);
        
    }

}