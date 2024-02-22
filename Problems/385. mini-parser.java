// https://leetcode.com/problems/mini-parser

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty())
            return null;
        if (s.charAt(0) != '[') // ERROR: special case
            return new NestedInteger(Integer.valueOf(s));
            
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int st = 0; // l shall point to the start of a number substring; 
                // r shall point to the end+1 of a number substring
        for (int ed = 0; ed < s.length(); ed++) {
            char ch = s.charAt(ed);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                st = ed+1;
            } else if (ch == ']') {
                String num = s.substring(st, ed);
                if (!num.isEmpty())
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                st = ed+1;
            } else if (ch == ',') {
                if (s.charAt(ed-1) != ']') {
                    String num = s.substring(st, ed);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                st = ed+1;
            }
        }
        
        return curr;
    }
}