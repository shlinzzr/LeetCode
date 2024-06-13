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

    Stack<TreeNode> nextStack;
    Stack<TreeNode> prevStack;
    HashSet<TreeNode> seen;



 // method stack
    public BSTIterator(TreeNode root) {

        nextStack = new Stack<>();
        prevStack = new Stack<>(); 
        seen = new HashSet<>();

        buildNextStack(root);
    }


    private void buildNextStack(TreeNode node){
       
        if(node==null) return;
        while(node!=null){
            nextStack.push(node);
            node = node.left;
        }
    }

    
    public boolean hasNext() {
        return !nextStack.isEmpty();
    }
    
    public int next() {
        TreeNode node = nextStack.pop();
        if(!seen.contains(node) && node.right!=null){
            buildNextStack(node.right);
        }

        seen.add(node);
        prevStack.add(node);
        return node.val;
        
    }
    
    public boolean hasPrev() {
        return prevStack.size()>1;
        
    }
    
    public int prev() {
        nextStack.push(prevStack.pop());
        return prevStack.peek().val;
    }




/*  // method : ArrayList

    List<Integer> list;
    int idx;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        idx =-1;
        helper(root);
    }


    private void helper(TreeNode root){
        if(root==null)  return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    
    public boolean hasNext() {
        return idx<list.size()-1;        
    }
    
    public int next() {
        return list.get(++idx);
        
    }
    
    public boolean hasPrev() {
        return idx>0;
        
    }
    
    public int prev() {
        return list.get(--idx);
        
    }
    */
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */