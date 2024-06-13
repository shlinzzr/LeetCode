// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }


        return helper(inorder, 0, len-1, postorder, 0, len-1);
    }

    private TreeNode helper(int[] in, int ist, int ied, int[] post, int pst, int ped){
        int len = in.length;

        if(len==0 || ist>ied || pst>ped) return null;

        int val = post[ped];
        int idx = map.get(val);
        int rightCnt = ied-idx;

        TreeNode root = new TreeNode(val);
        root.right = helper(in, idx+1, ied, post, pst, ped-1);
        root.left = helper(in, ist, idx-1, post, pst, ped-1-rightCnt);

        return root;

    }
    
}