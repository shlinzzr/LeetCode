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

        Map<Integer, Integer> map = new HashMap<>();
        int len = preorder.length;
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }
        

        return helper(preorder, 0, inorder, 0, len-1, map);
        
    }

    private TreeNode helper(int[] preorder, int pi, int[] inorder, int st, int ed,  Map<Integer, Integer> map){

        int len = preorder.length;
        if(pi==len || st>ed) return null;

        int val = preorder[pi]; //3
        TreeNode root = new TreeNode(val);

        int mid = map.get(val); //1

        int leftCnt = mid-st; //  1
        int rightCnt = ed-mid; // 4-1==3


        root.left = helper(preorder, pi+1, inorder, st, mid-1, map); // 
        root.right = helper(preorder, pi+leftCnt+1, inorder, mid+1, ed, map);

        return root;
    }
}