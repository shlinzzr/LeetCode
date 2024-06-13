// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {

    // the same concept as leetcode 160 

    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while(a!=b){
            a = (a==null) ? q : a.parent;
            b = (b==null) ? p : b.parent;
        }

        return a;
    }
}