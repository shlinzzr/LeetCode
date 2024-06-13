// https://leetcode.com/problems/create-maximum-number

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] res = new int[k];
        for(int i=0; i<=k; i++){

            if(i>nums1.length || k-i>nums2.length)
                continue;

            int[] tmp1 = getMax(nums1, i);
            int[] tmp2 = getMax(nums2, k-i);

// 

            int[] res1 = merge(tmp1, tmp2);
            if(greater(res1, res)){
                System.arraycopy(res1, 0, res, 0, k);
            }

            int[] res2 = merge(tmp2, tmp1);
             if(greater(res2, res)){
                System.arraycopy(res2, 0, res, 0, k);
            }
        }

        return res;
    }


    private int[] getMax(int[] nums, int k){
        Stack<Integer> st = new Stack<>();
        int len = nums.length;
        int del = len-k;

        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i] && del>0){
                st.pop();
                del--;
            }
            st.push(i);
        }

        while(del>0 && !st.isEmpty()){
            st.pop();
            del--;
        }

        int[] res = new int[st.size()];
        int idx= 0;
        for(int i : st){
            res[idx++] = nums[i];
        }

        return res;
    }
        
    private int[] merge(int[] nums1, int[] nums2){

        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m+n];

    
        int i=0, j=0, idx=0;
        while(i<m && j<n){

            if(nums1[i]>nums2[j]){
                res[idx++] = nums1[i++];
            }else{
                res[idx++] = nums2[j++];
            }
        }

        while(i<m){
            res[idx++] = nums1[i++];
        }

        while(j<n){
            res[idx++] = nums2[j++];
        }

        return res;
    }

    private boolean greater(int[] tmp, int[] res){
        int len = tmp.length;

        for(int i=0; i<len; i++){
            if(tmp[i]==res[i])
                continue;

            else if(tmp[i]>res[i])
                return true;
            else 
                return false;
        }

        return false;
    
    }
}