// https://leetcode.com/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum

class Solution {
    public long numberOfSubarrays(int[] nums) {

        int len = nums.length;

        Stack<int[] > st = new Stack<>();


long res = 0 ;

        for(int i=0; i<len; i++){

            int val = nums[i];

            while(!st.isEmpty() && st.peek()[0]<val){
                st.pop();
            }
            if (st.isEmpty() || st.peek()[0] != val)
                st.push(new int[]{val, 0});
            st.peek()[1]++;
            res += st.peek()[1];
        }

        return res;

        
    }
}