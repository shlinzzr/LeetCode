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
        
        if(root==null)
            return 0;
      
        getDepth(root);
        return max;
        
        
    }
    
    private int getDepth(Node root){
        
        // System.out.println("getDepth node="+ro ot.val);
        
        if(root==null)
            return 0;
        
        int len1=0, len2=0;
        for(Node node : root.children){
            int d = getDepth(node);
            
            // System.out.println(node.val + " d="+d);
            
            if(d>len1){
                len2=len1;
                len1=d;
            }else if(d>len2){
                len2=d;
            }
        }
        
        max = Math.max(max, len1+len2);
        
        return len1+1;
        
    }
    
}