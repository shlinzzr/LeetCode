// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        
        int[] res = new int[len];
        int idx = 0;
        
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        for(int n : nums){
            
            while(!st.isEmpty() && Math.abs(st.peek()-n)<=limit && st.peek()>n){
                st2.push(st.pop());
            }
            
            
            st.push(n);
            
            while(!st2.isEmpty()){
                st.push(st2.pop());
            }
        }
        
        for(int i : st){
            res[idx++]=i;
        }
        
        return res;
    }
}

//[1,4,5,3,9,8]

// 1 3 4 5
    
// 5 4
