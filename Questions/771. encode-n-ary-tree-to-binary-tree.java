// https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree

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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    
    /*
    
  Java Solution (Next Level -> left, Same Level -> right)  
    
   1
 / | \
2  3  4

to:

 1
/
2 : the first child node: start from root.left
 \
  3
   \
    4
    
    */
    
    
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(root.val); // the root : create TreeNode
        if (root.children.size() > 0) {                      //if(has children)
            result.left = encode(root.children.get(0));      // recur the first child
        }
        TreeNode cur = result.left;                          // now after create the root.left, we build the same level children to right recur
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return result;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node result = new Node(root.val, new LinkedList<>());  // create root node
        TreeNode cur = root.left;      //build the children start from root.left
        while (cur != null) {
            result.children.add(decode(cur));
            cur = cur.right;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));