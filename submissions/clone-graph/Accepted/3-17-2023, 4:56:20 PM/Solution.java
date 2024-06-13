// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    Map<Integer, Node> map = new HashMap<>();
    
    
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return null;
        
        if(map.containsKey(node.val))
            return map.get(node.val);
        
        
        Node res = new Node(node.val, new ArrayList<>());
        map.put(res.val, res);
        
        for(Node adj : node.neighbors){
            res.neighbors.add(cloneGraph(adj));
        }
        
        
        return res;
        
    }
}