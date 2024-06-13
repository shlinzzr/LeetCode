// https://leetcode.com/problems/next-greater-element-iv

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int len = nums.length;
        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, len);

        int[] secondGreater = new int[len];
        Arrays.fill(secondGreater, -1);
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for(int i=0; i<len; i++){

            while(!st2.isEmpty() && nums[st2.peek()]<nums[i]){
                secondGreater[st2.pop()] = nums[i];
            }

            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st1.push(st.pop());
            }

            while(!st1.isEmpty() ){
                st2.push(st1.pop());
            }

            st.push(i);
        }

        // for(int i=0; i<len; i++){
        //     System.out.print(nextGreater[i]+ ",");
        // }

        // int[] secondGreater = new int[len];
        // Array.fi
        // for(int i=0; i<len; i++){
        //     secondGreater[i] = nextGreater[i]==len ? -1 : nextGreater[nextGreater[i]];
        //     if(secondGreater[i]==len)
        //         secondGreater[i] = -1;
        //     else 
        //         secondGreater[i] = secondGreater[i]==-1 ? -1 :  nums[secondGreater[i]];
        // }

        return secondGreater;

    }
}