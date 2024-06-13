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
    int cnt = 0 ;
    public int pseudoPalindromicPaths (TreeNode root) {

        HashMap<Integer, Integer> map =new HashMap<>();

        helper(map, root);

        return cnt;

        
    }

    private void helper(HashMap<Integer, Integer> map, TreeNode root){
        if(root==null) return ;

        map.put(root.val, map.getOrDefault(root.val,0)+1);

        if(root.left==null && root.right==null && checkpal(map)){
            cnt++;
        }

        helper(map, root.left);
        helper(map, root.right);
        map.put(root.val, map.getOrDefault(root.val,0)-1);
    }

    private boolean checkpal(HashMap<Integer, Integer> map){
        boolean single = false;

        for(int key : map.keySet()){
            if(map.get(key)%2==1){
                if(single) return false;
                single = true;
            }
        }
        return true;
    }
}