// https://leetcode.com/problems/maximum-binary-tree

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
class Solution {

    /** 
        This problem has been asked in below companies:
        Amazon
        Microsoft

    */

    /** 
        The intuition is to use monotonic stack. 
        To maintain a decreasing order stack, in the decreasing order we will connect each node on the right of the
        top element in stack.

        Whenever we find a greater value we will start to pop element from stack and connect the popped element
        on the left of the current element, we will be doing this process untill we found a grater element in the stack

        once we are done with traversing the array, we need to return the most bottom element in the stack

        Time complexity: O(n)
        Space complexity: O(n)

    */


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        // to store the node in decreasing order
        Stack<TreeNode> stack = new Stack<>();

        // traverse the array
        for(int num : nums) {
            // create a new node
            TreeNode node = new TreeNode(num);

            // 想法: stack大的壓到下面, 最後pop出來給curr當左子樹 
            // 只要curr > stack.top 就 pop, 此時stack呈現降序(愈新的愈小, 愈pop愈大)
            // st之前都是prefix 左邊子樹 curr.left = st.pop();
            
            // check the stack is not empty and current element is greater than 
            // the top element in the stack 
            // if yes then pop the node and connect to the right of the current node
            
            //找左子樹
            while(!stack.isEmpty() && stack.peek().val < num) {
                node.left = stack.pop();
            }

            // if the stack is not empty
            // meaning the current element is less than the top element in the stack
            // so connect the curre node in the right of the top element node in the stack

            //如果已經盡量pop掉了 stack還是有剩, 表示stack.top>curr => stack.top.right = curr; (接下來的都是postfix 右邊子樹)
            if(!stack.isEmpty()) stack.peek().right = node;

            // add the current node in the stack
            stack.push(node);
        }

        // return the most bottom element in the stack
        return stack.firstElement();
        
    }
}