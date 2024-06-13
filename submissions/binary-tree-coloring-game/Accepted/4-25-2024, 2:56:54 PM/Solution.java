// https://leetcode.com/problems/binary-tree-coloring-game

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
    
    int xleft =0;
    int xright = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // n : odd
        // 1 player choose x (red)
        // 2 player choose y, (blue) y!=x
            
        // left, right, parent with uncolored
        // if can't pick, pass, 
        // if both pass, game over;
        // color node more wins the game
        
        // I'm 2nd player, can win = true, else false
        
        
        int total = getNodeCnt(root);
        int subx = getNodeCntWithX(root, x , false);
        System.out.println(subx);
        
        int others = total-subx;
        
        if(others> total/2 || xleft>others+xright || xright>others+xleft)
            return true;
        
        return false;
            
    }
    
    
    private int getNodeCntWithX(TreeNode node, int x, boolean found){
        
        if(node==null) return 0;
        
        if(node.val==x){
            found = true;
        }
        
        int left = getNodeCntWithX(node.left, x, found);
        int right = getNodeCntWithX(node.right, x, found);
        
        if(node.val==x){
            xleft = left;
            xright = right;
        }
        
        return (found? 1 : 0 ) + left + right;
        
    }
    
    private int getNodeCnt(TreeNode node){
        
        if(node==null) return 0;
        if(node.left==null && node.right==null) return 1;
        
        int left = getNodeCnt(node.left);
        int right = getNodeCnt(node.right);
        return left+right+1;
        
    }
}