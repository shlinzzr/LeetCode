// https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node a, Node b) {
        if(a.isLeaf){
            return a.val ? a : b;
        }
        if(b.isLeaf){
            return b.val ? b : a;
        }
        a.topLeft = intersect(a.topLeft,b.topLeft);
        a.topRight = intersect(a.topRight,b.topRight);
        a.bottomLeft = intersect(a.bottomLeft,b.bottomLeft);
        a.bottomRight = intersect(a.bottomRight,b.bottomRight);

        if (a.topLeft.isLeaf && a.topRight.isLeaf 
            && a.bottomLeft.isLeaf && a.bottomRight.isLeaf
            && a.topLeft.val == a.topRight.val 
            && a.topRight.val == a.bottomLeft.val 
            && a.bottomLeft.val == a.bottomRight.val) {
            return new Node(true,a.topLeft.val);
        }
        return a;
    }
}