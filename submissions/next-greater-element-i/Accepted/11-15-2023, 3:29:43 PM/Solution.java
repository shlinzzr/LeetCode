// https://leetcode.com/problems/next-greater-element-i

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();

        int len = nums2.length;

        int[] nextGreater = new int[len];

        HashMap<Integer,Integer> map = new HashMap<>();

        Arrays.fill(nextGreater, -1);
        for(int i=0; i<len; i++){

            while(!st.isEmpty() && nums2[st.peek()]<nums2[i]){
                map.put(nums2[st.peek()], nums2[i]);
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }

        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;


    }
}