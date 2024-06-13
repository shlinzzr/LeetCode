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
    
    
    Stack<TreeNode> st;
    
    private void helper(TreeNode root){
        
        
        if(root.right!=null)
            helper(root.right);
        
        st.push(root);
        
        if(root.left!=null)
            helper(root.left);
        
    }
    
    
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }
    
    public int next() {
        

        if(!st.isEmpty())
            return st.pop().val;
        
        return -1;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */