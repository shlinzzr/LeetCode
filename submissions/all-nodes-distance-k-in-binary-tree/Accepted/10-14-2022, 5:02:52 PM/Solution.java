// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree

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
    
//   HuaHua without HashMap version 
//   recursive version    

    
    List<Integer> res;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        helper(root, target, k);
        return res;
    }
    
    private int helper(TreeNode root, TreeNode target, int k ){
        if(root==null)
            return -1;
        
        if(root==target){
            collect(target, k);
            return 0;
        }
        
        int l = helper(root.left, target, k);
        int r = helper(root.right, target, k);
        
        if(l>=0){
            if(l==k-1)
                res.add(root.val);
            collect(root.right, k-l-2);
            return l+1;
        }
        
        if(r>=0){
            if(r==k-1)
                res.add(root.val);
            collect(root.left, k-r-2);
            return r+1;
        }
        
        return -1;
        
    }
    
    private void collect(TreeNode root, int d){
        if(root==null || d<0)
            return;
        
        if(d==0) 
            res.add(root.val);
        
        collect(root.left, d-1);
        collect(root.right, d-1);
    }
}
