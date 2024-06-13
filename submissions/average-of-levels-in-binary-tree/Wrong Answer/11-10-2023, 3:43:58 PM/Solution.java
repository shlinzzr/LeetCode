// https://leetcode.com/problems/average-of-levels-in-binary-tree

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            
            double sum = 0;
            int siz = q.size();
            while(siz-->0){
                TreeNode p = q.poll();
                
                sum+=p.val;
                
                if(p.left!=null)
                    q.offer(p.left);
                if(p.right!=null)
                    q.offer(p.right);
            }
            
            list.add(sum/siz);
        }
        
        return list;
    }
}