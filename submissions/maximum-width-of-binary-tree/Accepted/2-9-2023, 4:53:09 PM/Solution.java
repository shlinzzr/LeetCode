// https://leetcode.com/problems/maximum-width-of-binary-tree

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
    public int widthOfBinaryTree(TreeNode root) {
        
        // use bfs trace by level;
        HashMap<TreeNode, Integer> map = new HashMap<>();  // node, idx
        map.put(root, 0);
         
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int max = 1;
        while(!q.isEmpty()){
            int start=0, end=0;
            int siz = q.size();
            
            for(int i=0; i<siz; i++){
                TreeNode node = q.poll();
                int idx = map.get(node);
                
                if(i==0) start = idx;
                if(i==siz-1) end = idx;
                   // System.out.println(i + " val=" + node.val + " max=" + max + " idx=" + idx + " st="+start+ " ed="+end );
                if(node.left!=null){
                    map.put(node.left, 2*idx+1);
                    q.offer(node.left);
                }
                
                if(node.right!=null){
                    map.put(node.right, 2*idx+2);
                    q.offer(node.right);
                }
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}