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

    List<Integer> list;
    int cur = 0;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
            
        helper(root);
        
    }
    
    private void helper(TreeNode root){
        
        if(root!=null){
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
    }
    
    public int next() {
        
        return list.get(cur++);
    }
    
    public boolean hasNext() {
      
        return cur<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */