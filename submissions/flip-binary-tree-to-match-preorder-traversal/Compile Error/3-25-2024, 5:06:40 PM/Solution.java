// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal

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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<voyage.length; i++){
            map.put(voyage[i], i);
        }

        helper(res, root, voyage, 0);

        if(res.isEmpty()) res.add(-1);

        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int[] v, int idx){

        if(root==null) return;

        if(root.val!=v[idx]) return;

        if(root.left!=null && root.right!=null){
            int leftVal = root.left.val;
            int leftIdx = map.get(leftVal);
            int rightVal = root.right.val;
            int rightIdx = map.get(rightVal);

            if(rightVal==v[idx+1]){
                res.add(idx+1);
                helper(res, root.)
            }
        }






    }
}
