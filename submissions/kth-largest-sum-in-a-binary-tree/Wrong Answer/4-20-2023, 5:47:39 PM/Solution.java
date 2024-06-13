// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, root,k, 0);
        int[] arr = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            
            List<Integer> list = res.get(i);
            int val = 0;
            for(int n : list){
                val+=n;
            }
            
            arr[i] = val;
        }
        
        Arrays.sort(arr);
        return k>=arr.length? -1 : arr[arr.length-k];
        
        
        
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int k, int lv){
        
        if(res.size()<lv+1){
            res.add(new ArrayList<>());
        }
        if(root==null)
            return ;
        
        res.get(lv).add(root.val);
        
        helper(res, root.left, k, lv+1);
        helper(res, root.right, k, lv+1);
    }
        
      
}
