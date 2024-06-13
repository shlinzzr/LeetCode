// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves

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

    int maxDepth= 0;
    int maxCnt;
    TreeNode res;
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        dfs(root, 0);
        dfs2(root, 0);
        return res;
        
    }

    private void dfs(TreeNode node, int lv){
        if(node==null) return;
        if(node.left==null && node.right==null){
            if(lv>maxDepth){
                maxDepth = lv; 
                maxCnt=1;
            }else if(lv==maxDepth){
                maxCnt++;
            }
        }

        dfs(node.left, lv+1);
        dfs(node.right, lv+1);

    }


    private int dfs2(TreeNode node, int lv){
        if(node==null) return 0;

        int self = lv==maxDepth ? 1 : 0;

        int left = dfs2(node.left, lv+1);
        int right = dfs2(node.right, lv+1);
        if(left+right+self==maxCnt && res==null)
            res = node;

        return left+right+self;
    }

}