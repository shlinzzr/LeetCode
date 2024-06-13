// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array

class Solution {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int cnt = 0;
        for(int i=0; i<len-1; i++){
            if(i>0 && arr[i-1]!=arr[i])
                cnt=0;
            cnt++;

            if(cnt>len/4)
                return arr[i];
        }

        return -1;
    }
}