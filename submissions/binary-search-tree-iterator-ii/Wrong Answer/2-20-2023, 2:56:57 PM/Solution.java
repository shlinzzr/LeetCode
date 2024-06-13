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

     TreeNode root;
    List<Integer> list;
    int size;
    int curr;
    
    Iterator<Integer> iter;
    
    
    public BSTIterator(TreeNode root) {
        this.root=root;
        list = new ArrayList<>();
        buildList(root);
        size = list.size();
        curr=-1;
    }
    
    
    private void buildList(TreeNode root){
        
        if(root==null)
            return;
        
        buildList(root.left);
        list.add(root.val);
        buildList(root.right);
    }
    
    public boolean hasNext() {
        System.out.println(curr<size-1);
        return curr<size-1;
    }
    
    public int next() {
        curr++;    
        int val = list.get(curr);
        
        System.out.println(val);
        return val;
    }
    
    public boolean hasPrev() {
         System.out.println(curr>=0 && curr<size);
        return curr>=0 && curr<size; 
    }
    
    public int prev() {
        curr--;
        int val = list.get(curr);
        System.out.println(val);
        return val;
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