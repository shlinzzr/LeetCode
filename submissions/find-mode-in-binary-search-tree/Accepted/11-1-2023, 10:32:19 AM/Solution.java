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

    int max= 0;

     Set<Integer> set = new HashSet<>();

    public int[] findMode(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
       

        helper(root, map);

//  System.out.println("max="+max);
//  System.out.println("set="+set);

        int[] res = new int[set.size()];
        int idx=0;
        for(int i : set){
            res[idx++] = i;
        }

        return res;
    }

    private void helper(TreeNode node, HashMap<Integer, Integer> map){
        if(node==null){
            return;
        }

        map.put(node.val, map.getOrDefault(node.val,0)+1);

        if(map.get(node.val)>max){
            set = new HashSet<>();
            set.add(node.val);
            max = Math.max(max, map.get(node.val));

        }else if(map.get(node.val)==max){
            set.add(node.val);
        }

        helper(node.left, map);
        helper(node.right, map);

    }
}