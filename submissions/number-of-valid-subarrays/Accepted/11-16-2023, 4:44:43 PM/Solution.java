// https://leetcode.com/problems/number-of-valid-subarrays

class Solution {
    public int validSubarrays(int[] nums) {
        int len = nums.length;

/*
[1 4 2 5 3 ]
1 
4
2 
5 
3
1 4 2 5 3
1 4 2 5
1 4 2 
1 4
2 5 3
2 5

 [0 1 2 3 4] 5





*/
        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        int res = 0;
        for(int i=0; i<len; i++){
            res += nextSmaller[i]-i;
        }

        return res;


        
    }
}