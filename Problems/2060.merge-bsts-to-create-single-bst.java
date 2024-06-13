// https://leetcode.com/problems/merge-bsts-to-create-single-bst

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
    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();

        //Collect the leaves
        Set<Integer> leaves = new HashSet();
         Map<Integer, TreeNode> map = new HashMap<>(); 
        for(TreeNode tree : trees) {
             map.put(tree.val, tree);
            if(tree.left != null) {
                leaves.add(tree.left.val);
            }
            if(tree.right != null) {
                leaves.add(tree.right.val);
            }
        }
        
        //Decide the root of the resulting tree
        TreeNode result = null;
        for(TreeNode tree : trees) {
            if(!leaves.contains(tree.val) ) {
                result = tree;
                break;
            }
        }
        if(result == null) {
            return null;
        }
        
        return traverse(result, map, Integer.MIN_VALUE, Integer.MAX_VALUE) && map.size() == 1 ? result : null;
    }
    
    private boolean traverse(TreeNode root, Map<Integer, TreeNode> map, int min, int max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        
        if(root.left == null && root.right == null) {
            if(map.containsKey(root.val) && root != map.get(root.val)) {
                TreeNode next = map.get(root.val);
                root.left = next.left;
                root.right = next.right;
                map.remove(root.val);
            }
        }
        return traverse(root.left, map, min, root.val) && traverse(root.right, map, root.val, max);
    }
        
}