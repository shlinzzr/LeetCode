// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a,b)-> a[0]-b[0]);
        int[] arr = new int[100];
        for(int[] r : ranges){
            arr[r[0]]++;
            arr[r[1]+1]--;
        }


        int cur = 0;
        for(int i=left; i<=right; i++){
            cur += arr[i];

            if(cur<0)return false;
        }   

        return true;
    }
}