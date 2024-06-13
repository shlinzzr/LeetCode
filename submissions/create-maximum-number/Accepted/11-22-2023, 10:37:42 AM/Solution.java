// https://leetcode.com/problems/create-maximum-number

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] res = new int[k];
        for(int i=0; i<=k; i++){

            if(i>nums1.length || k-i>nums2.length)
                continue;

            int[] tmp1 = getMax(nums1, i);
            int[] tmp2 = getMax(nums2, k-i);

            int[] tmp = merge(tmp1, tmp2, k);

            if (greater(tmp, 0, res, 0)) 
                res = tmp;
            // int[] res2 = merge(tmp2, tmp


            System.out.println("i="+i);
            for(int r: res){
                System.out.print(r+ ",");

            }
            System.out.println();
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

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
        i++;
        j++;
    }
    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
}
        
    // private int[] merge(int[] nums1, int[] nums2){

    //     int m = nums1.length;
    //     int n = nums2.length;

    //     int[] res = new int[m+n];

    
    //     int i=0, j=0, idx=0;
    //     while(i<m && j<n){

    //         if(nums1[i]>nums2[j]){
    //             res[idx++] = nums1[i++];
    //         }else{
    //             res[idx++] = nums2[j++];
    //         }
    //     }

    //     while(i<m){
    //         res[idx++] = nums1[i++];
    //     }

    //     while(j<n){
    //         res[idx++] = nums2[j++];
    //     }

    //     return res;
    // }

    // private boolean greater(int[] tmp, int[] res){
    //     int len = tmp.length;

    //     for(int i=0; i<len; i++){
    //         if(tmp[i]==res[i])
    //             continue;

    //         else if(tmp[i]>res[i])
    //             return true;
    //         else 
    //             return false;
    //     }

    //     return false;
    
    // }
}