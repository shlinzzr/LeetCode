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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 1);
        
        
        int level=0, width=0; // nodeCnt = 2^level, width==nodeCnt-1==2^level-1;
        while(!queue.isEmpty()){
            int siz = queue.size();
            int start=0, end=0;
            
            
            for(int i=0; i<siz; i++){ // by level
                TreeNode curr = queue.poll();                
                if(i==0){
                    start = map.get(curr);
                }
                if(i==siz-1){
                    end = map.get(curr);
                }
                
                if(curr.left!=null){
                    queue.offer(curr.left);
                    map.put(curr.left, 2*map.get(curr));
                    
                }
                
                if(curr.right!=null){
                    queue.offer(curr.right);
                    map.put(curr.right, 2*map.get(curr)+1);
                }
                    
                width = Math.max(width, end-start+1);
                
            }
        }
        
        return width;
        
        
    }
}