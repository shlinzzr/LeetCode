// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree

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
    
    int res=0;
    int[] arr;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        arr = new int[10];
        dfs(root);
        return res;
        
    }
    
    private void dfs(TreeNode root ){
        
        if(root==null)
            return ;
        
        arr[root.val]++;
        if(root.left==null && root.right==null){
            if(isPalindrome(arr))
                ++res;
        }else{
            dfs(root.left);
            dfs(root.right);    
        }
        
        arr[root.val]--;
        
        return  ;
    }
    
    private boolean isPalindrome(int[] arr){
        int odd=0;
        for(int i : arr){
            if(i%2!=0)
                odd++;
        }
        
        
        return odd<=1;
    }
}
