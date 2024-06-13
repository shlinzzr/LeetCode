// https://leetcode.com/problems/find-nearest-right-node-in-binary-tree

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
    
    List<List<TreeNode>> list = new ArrayList<>();
    int max = Integer.MAX_VALUE;
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        
        
        helper(root, u, 1);
        
//         for(List<TreeNode> nodes : list){
//             for(TreeNode nd : nodes){
//                 System.out.print(nd.val+",");
//             }   
//             System.out.println();
//         }
        
        
        List<TreeNode> nodes = list.get(max-1);
        for(int i=0; i<nodes.size(); i++){
            
            TreeNode node = nodes.get(i);
            if(node==u)
                return nodes.get(i+1);
        }
        
        return null;
        
    }
    
    
    private void helper(TreeNode root, TreeNode u, int lv){
        
        if(root==null)
            return ;
        
        if(lv>max)
            return;
        
        if(root==u)
            max = lv;
        
        if(list.size()<lv)
            list.add(new ArrayList<>());
        
        list.get(lv-1).add(root);
        helper(root.left, u, lv+1);        
        helper(root.right, u, lv+1);
        
        
        
    }
}