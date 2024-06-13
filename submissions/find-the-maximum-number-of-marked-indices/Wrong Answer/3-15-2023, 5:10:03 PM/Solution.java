// https://leetcode.com/problems/find-the-maximum-number-of-marked-indices

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int i=0, j=1;
        int len = nums.length;
        
        Arrays.sort(nums);
        boolean[] bool = new boolean[len];
        int cnt =0;
        while(j<len){
            
            while(bool[i])
                i++;
            
            if(i>=len-1)
                break;
            
            int n1 = nums[i];
            while(j<len && nums[j]<2*n1){
                j++;
            }
            if(j<len){
                cnt+=2;
                bool[j]=true;
                j++;
                
            }
            bool[i]=true;
            i++;
            
        }
        return cnt;
    }
}