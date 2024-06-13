// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;

        map = new HashMap<>(); // val, idx
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }


        return helper(preorder, inorder, 0, len-1, 0, len-1);

        
        
    }

    private TreeNode helper(int[] pre, int[] in, int pst, int ped, int ist, int ied){

        int len = pre.length;

        if(len==0 || pst>ped || ist>ied ) return null;
        int val = pre[pst];
        TreeNode node = new TreeNode(val);

        int idx = map.get(val);
        
        int nodeCnt = idx-ist;

        node.left = helper(pre, in, pst+1, ped, ist, idx-1);
        node.right = helper(pre, in, pst+1+nodeCnt, ped, idx+1, ied);

        return node;

    }
}