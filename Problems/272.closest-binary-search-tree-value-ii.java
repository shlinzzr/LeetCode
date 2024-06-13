// https://leetcode.com/problems/closest-binary-search-tree-value-ii

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

    List<Integer> list = new ArrayList<>();

    int closestIdx = 0;
    double closestVal = Integer.MAX_VALUE;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        genList(root, target);
        System.out.println(closestIdx +" "  + list.size());

        res.add(list.get(closestIdx));

        int st = closestIdx-1, ed =closestIdx+1;
        while(res.size()<k){

            if(st>=0 && ed<list.size()){
                if( Math.abs(list.get(st)-target) < Math.abs(list.get(ed)-target) ){
                    res.add(list.get(st--));
                }else{
                    res.add(list.get(ed++));
                }
            }else if(st>=0)
                res.add(list.get(st--));
            else 
                res.add(list.get(ed++));

        }

        return res;




    }

    private void genList(TreeNode node, double target){
        if(node==null) return;
        genList(node.left, target);
        list.add(node.val);

        if(Math.abs(node.val-target)<closestVal){
            closestVal = Math.abs(node.val-target);
            closestIdx = list.size()-1;
        }
        genList(node.right,target);
    }
}