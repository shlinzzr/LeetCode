// https://leetcode.com/problems/even-odd-tree

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

    List<List<Integer>> list = new ArrayList<>();

    public boolean isEvenOddTree(TreeNode root) {
        helper(root, 0);


        for(int r=0; r<list.size(); r++){
            
            List<Integer> row = list.get(r);

            // System.out.println(row);

            if(r%2==0){
                for(int i=0; i<row.size()-1; i++){

                    if(row.get(i)%2==0) return false;
                    if(row.get(i)>=row.get(i+1)) return false;
                }

                if(row.get(row.size()-1)%2==0) return false;
            }else{

                for(int i=0; i<row.size()-1; i++){

                    if(row.get(i)%2==1) return false;
                    if(row.get(i)<=row.get(i+1)) return false;
                }

                if(row.get(row.size()-1)%2==1) return false;
            }



        }

        return true;
    }

    private void helper(TreeNode root, int idx){
        if(root==null) return;

        if(list.size()<idx+1){
            list.add(new ArrayList<>());
        }

        list.get(idx).add(root.val);

        helper(root.left, idx+1);
        helper(root.right, idx+1);

        
    }
}