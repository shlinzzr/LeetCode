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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }


        return helper(preorder, 0, len-1, inorder, 0, len-1, map);
    }

    private TreeNode helper(int[] pre, int pst, int ped, int[] in, int ist, int ied, Map<Integer, Integer> map){

        int len = pre.length;
        if(len==0 || pst>ped || ist>ied)
            return null;

        int rootVal = pre[pst];
        int rootIdx = map.get(rootVal);
        int leftCnt = rootIdx-ist;
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(pre, pst+1, pst+leftCnt, in, ist, rootIdx-1, map);
        root.right = helper(pre, pst+leftCnt+1, ped, in, rootIdx+1, ied, map);


        return root;
    }
}