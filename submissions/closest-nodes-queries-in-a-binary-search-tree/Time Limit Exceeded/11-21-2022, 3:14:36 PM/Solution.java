// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree

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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            
        List<List<Integer>> res = new ArrayList<>();
        
        
        
        for(int q : queries){
            int[] arr = new int[2];
            Arrays.fill(arr, -1);
            if(root==null){
                // do nothing
            }else{
                
                if(root.val==q){
                    arr[0] = root.val;
                    arr[1] = root.val;
                }else if(root.val<q){
                    arr[0] = root.val;   
                }else 
                    arr[1] = root.val;
            }
            helper(res, root, arr, q);
            
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            list.add(arr[1]);
            res.add(list);
            
            
        }
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int[] arr, int q){
        
        if(root==null)
            return ;
        
        if(root.val==q){
            arr[0]=root.val;
            arr[1]=root.val;
            return;
            
        }else if(root.val<q ){
            arr[0] = root.val;
            
            if( root.right==null)
                return;
            else
                helper(res, root.right, arr, q);
        }if(root.val>q){
            
            arr[1] = root.val;
            if(root.left==null)
                return;
            
            else 
                helper(res, root.left, arr, q);
        }
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
}