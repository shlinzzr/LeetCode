// https://leetcode.com/problems/balance-a-binary-search-tree

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
//     public TreeNode balanceBST(TreeNode root) {
//         if(Math.abs(getDepth(root.left) - getDepth(root.right))>1)
//     }
    
//     private helper()
    
    
//     private int getDepth(TreeNode root){
        
//         if(root==null)
//             return 0;
        
//         int left = getDepth(root.left);
//         int right = getDepth(root.right);
        
//         return Math.max(left, right);
        
//     }
    
    
    public TreeNode balanceBST(TreeNode root) {
         
        List<TreeNode> list = new ArrayList<>();
        inorderTraverse(root, list);
        TreeNode res = sortedListToBSTtree(list, 0, list.size()-1);
        return res;
    }

    private TreeNode sortedListToBSTtree(List<TreeNode> list, int st, int ed){
        if(st>ed)
            return null;
        
        int mid=st + (ed-st)/2;
        TreeNode root = list.get(mid);
        root.left = sortedListToBSTtree(list, st, mid-1);
        root.right = sortedListToBSTtree(list, mid+1, ed);
        
        return root;
    }
    
    
    private void inorderTraverse(TreeNode root,  List<TreeNode> list){
        if(root==null)
            return;
        inorderTraverse(root.left, list);
        list.add(root);
        inorderTraverse(root.right, list);
        
        return;
    }
    
    
}