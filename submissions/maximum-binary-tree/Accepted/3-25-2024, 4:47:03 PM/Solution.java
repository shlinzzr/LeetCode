// https://leetcode.com/problems/maximum-binary-tree

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len ;i++){
            map.put(nums[i], i);
        }

        return helper(nums, 0, len-1, map);
        
    }

    private TreeNode helper(int[] nums, int st, int ed, HashMap<Integer,Integer> map){
        int len = nums.length;
        if(len==0 || st>ed){
            return null;
        }

        // int val = map.lastKey();
        // int idx = map.get(val);
        // while(idx<st || idx>ed){
        //     val=map.lowerKey(val);
        //     idx = map.get(val);
        // }

        int idx = findMaxIndex(nums, st, ed);
        int val = nums[idx];

        int leftCnt = idx-st;
        TreeNode node = new TreeNode(val);
        node.left = helper(nums, st, idx-1, map );
        node.right = helper(nums, idx+1, ed, map);


        return node;

    }

     public int findMaxIndex(int[] nums, int start, int end){
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}