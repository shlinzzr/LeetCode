// https://leetcode.com/problems/n-ary-tree-level-order-traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, root, 1);
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, Node root, int lv){
        
        if(root==null)
            return;
        
        if(res.size()<lv)
            res.add(new ArrayList<>());
        
        res.get(lv-1).add(root.val);
        
        for(Node child : root.children){
            helper(res, child, lv+1);    
        }
        
    }
}