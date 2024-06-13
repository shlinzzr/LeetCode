// https://leetcode.com/problems/diameter-of-n-ary-tree

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int diameter(Node root) {
        getDepth(root);
        return max;
    }

    private int getDepth(Node root){
        if(root==null) return 0;

        List<Node> list = root.children;

        int top1 = 0;
        int top2 = 0;

        for(Node node : list){
            int d = getDepth(node);

            if(d>top1){
                top2 = top1;
                top1 = d;
                
            }else if(d>top2){
                top2=d;
            }

        }

        max = Math.max(max, top1+top2);

        return top1+1;

    }
}