// https://leetcode.com/problems/binary-search-tree-iterator

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
class BSTIterator {
    Map<Integer, TreeNode> map;
    int idx= 0;
    public BSTIterator(TreeNode root) {
        map = new HashMap<>();
        idx = 0;
        helper(root);

        
    }

    private void helper(TreeNode node ){
        if(node ==null) return;
        helper(node.left);
        map.put(map.size(), node);
        helper(node.right);
    }
    
    public int next() {
        return map.get(idx++).val;
        
    }
    
    public boolean hasNext() {

        return idx < map.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */