// https://leetcode.com/problems/binary-search-tree-iterator-ii

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
    int idx;
    
    
    public BSTIterator(TreeNode root) {
        list= new ArrayList<>();
        helper(list,  root);
        idx=-1;
    }
    
    private void helper(List<Integer> list , TreeNode root){
        
        if(root==null)
            return;
        
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
    
    public boolean hasNext() {
        return idx<list.size()-1;        
    }
    
    public int next() {
        idx++;
        return list.get(idx);
    }
    
    public boolean hasPrev() {
        return idx>0;
    }
    
    public int prev() {
        idx--;
        return list.get(idx);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */