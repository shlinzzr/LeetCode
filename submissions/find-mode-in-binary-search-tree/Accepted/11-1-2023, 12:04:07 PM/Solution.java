// https://leetcode.com/problems/find-mode-in-binary-search-tree

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

    int maxFreq = 0;
    int curFreq = 0;
    int prev;
    List<Integer> list = new ArrayList<>();
//[1,1,1,0,null,null,4,0,0,4,4]
    public int[] findMode(TreeNode root) {
        if(root==null)
            return new int[0];
        
        findMode(root.left);

        if(maxFreq==0){ // init the first node
            maxFreq=1;
            curFreq=1;
            // prev = root.val;
            list.add(root.val);

        }else{
            if(root.val==prev){
                curFreq+=1;
                if(curFreq > maxFreq){
                    maxFreq = curFreq;
                    list = new ArrayList<>();
                    list.add(root.val);
                }else if(curFreq == maxFreq){
                    list.add(root.val);
                }
            }else{
                curFreq = 1;
                if(curFreq == maxFreq){
                    list.add(root.val);
                }
            }
        }

        prev = root.val;
        findMode(root.right);


        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }   

}