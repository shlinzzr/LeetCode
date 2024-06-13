// https://leetcode.com/problems/kth-ancestor-of-a-tree-node

class TreeAncestor {

    int[] parent;
    
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        
        int curr= node;
        while(k>0 && curr!=-1){
            
            curr = parent[curr];
            k--;
            
        }
        
        return curr;
        
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */