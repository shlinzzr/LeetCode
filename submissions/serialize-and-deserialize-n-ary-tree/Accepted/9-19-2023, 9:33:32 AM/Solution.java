// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        
        buildStrings(root, sb);
        
        return sb.toString();
    }
	
    private void buildStrings(Node root, StringBuilder sb) {
        if (root == null) return;
        
        sb.append("[");
        sb.append(root.val);
        
        for (Node child : root.children) {
            buildStrings(child, sb);
        }  
        
        sb.append("]");
    }
    
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        
        int len = data.length();
        int val = 0;
        Deque<Node> stack = new ArrayDeque<>();
        Node dummy = new Node(0, new ArrayList<>());
        Node curr = dummy;
        
        for (int i = 0; i < len; ++i) {
            char c = data.charAt(i);
            
            if (c == '[') {
                curr.val = val;
                stack.push(curr);
                
                curr = new Node(0, new ArrayList<>());
                val = 0;
            } else if (c == ']') {
                Node top = stack.pop();
                curr.val = val;
                top.children.add(curr);
                
                curr = top;
                val = top.val;
            } else {
                val = val * 10 + c - '0';
            }
        }
        
        return dummy.children.get(0);
    }
}