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

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;

        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, len-1, inorder, 0, len-1);
        
    }

    private TreeNode helper(int[] preorder, int pst, int ped, int[] inorder, int ist, int ied){

        if(pst>ped || ist>ied) return null;

        int rootVal = preorder[pst];

        TreeNode root = new TreeNode(rootVal);
        if(pst==ped) return root;

        int rootIdx = map.get(rootVal);

        int leftCnt = rootIdx-ist;
        int rightCnt = ied-rootIdx;

        TreeNode left = helper(preorder, pst+1, pst+leftCnt, inorder, ist, rootIdx-1);
        TreeNode right = helper(preorder, pst+leftCnt+1, ped, inorder, rootIdx+1, ied);

        root.left = left;
        root.right = right;

        return root;





    }
}