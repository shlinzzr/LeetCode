// https://leetcode.com/problems/check-completeness-of-a-binary-tree

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
    public boolean isCompleteTree(TreeNode root) {
        
        if(root==null)
            return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode prev = new TreeNode();
        
        q.offer(root);
        boolean nullNodeFound = false;
        while(!q.isEmpty()){
            
            TreeNode p = q.poll();
            if (p == null) {
                nullNodeFound = true;
            } else {
                if (nullNodeFound) {
                    return false;
                }
                q.offer(p.left);
                q.offer(p.right);
            }
        }
        
        return true;
    }
    
//     private boolean helper(TreeNode root, List<List<Integer>> list, int lv){
        
//         if(list.size()<lv+1)
//             list.add(new ArrayList<>());
        
//         if(root==null){
//             list.get(lv).add(null);
//             return
//         }
        
//         list.get(lv).add(root.val);
        
//         if(root.left==null && root.right!=null)
//             return false;
        
//         boolean left = helper(root.left);
//         boolean right = helper(root.right);
        
//     }
    
}