// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes

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

    
    int maxDepth = 0;
    int maxCnt=0;
    TreeNode res;
    Map<TreeNode, TreeNode> map; //leaf, parent
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        map = new HashMap<>();
        helper(root, 0);
        helper2(root, 0);
        return res;
    }

    private void helper(TreeNode root, int lv){
        if(root==null) return ;

        if(root.left==null && root.right==null){
            if(lv>maxDepth){
                maxDepth = lv;
                maxCnt=1;
            }else if(lv==maxDepth){
                maxCnt++;
            }
        }

        

        helper(root.left,lv+1);
        helper(root.right, lv+1);
    }

    private int helper2(TreeNode root, int lv){

        if(root==null) return 0;

        int self = lv==maxDepth ? 1 : 0;
        int left = helper2(root.left, lv+1);
        int right = helper2(root.right, lv+1);

        if(self + left + right ==maxCnt && res==null){
            res = root;
        }

        return self + left + right;
    }
}