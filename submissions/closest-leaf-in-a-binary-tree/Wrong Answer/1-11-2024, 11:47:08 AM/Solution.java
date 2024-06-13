// https://leetcode.com/problems/closest-leaf-in-a-binary-tree

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

    Integer prev;
    int prevStep = Integer.MAX_VALUE;

    Integer next;
    int nextStep = Integer.MAX_VALUE;
    int step = 0;

    int kStep = 0;
    boolean found = false;
    Integer res;

    public int findClosestLeaf(TreeNode root, int k) {

        helper(root, k);

        return res;
        
    }

    private void helper(TreeNode node , int k){
        if(node==null) return ;

        if(res!=null) return;
        step++;
        // abs = Math.min(abs, Math.abs(node.val-k));

        if(node.val==k){
            found=true;
            kStep = step;

            if(node.left==null && node.right==null){
                res = node.val;
                return;
            }

            if(prev==null){
                prev = Integer.MAX_VALUE;
                prevStep = Integer.MAX_VALUE;
            }
        } 

        if(node.left==null && node.right==null){

            if(found==false){
                prev = node.val;
                prevStep = step;

            }else{
                
                
                next = node.val;
                nextStep = step;

                // System.out.println(prev + " " + prevStep + " , "+ next + " " + nextStep);

                if(kStep-prevStep > nextStep-kStep ){
                    res = next;
                }else{
                    res = prev;
                }

            }
                
        }
        helper(node.left, k);
        helper(node.right, k);
    }
}