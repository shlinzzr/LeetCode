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
        if(N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for(int i = 1; i < N; i += 2) {
            List<TreeNode> leftSubTrees = allPossibleFBT(i);
            List<TreeNode> rightSubTrees = allPossibleFBT(N - i - 1);
            for(TreeNode l : leftSubTrees) {
                for(TreeNode r : rightSubTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
    
   // public List<TreeNode> allPossibleFBT(int n) {
//         List<TreeNode> res = new ArrayList<>();
        
//         TreeNode head = new TreeNode(0);
//         TreeNode curr = head;
//         helper(res, head, curr, n-1);
        
//         return res;
    // }
    
//     private void helper(List<TreeNode> res, TreeNode head, TreeNode curr, int n){
        
//         if(n==0){
//             TreeNode node = head;
//             res.add(node);
//             return;
//         }
            
//         for(int i=0; i<n; i++){
//             curr.left = new TreeNode(0);
//             helper(res, head, curr.left, i);    
            
//             curr.right = new TreeNode(0);
//             helper(res, head, curr.right, n-1-i);
//         }
        
//     }
    
    
    
    
    
}