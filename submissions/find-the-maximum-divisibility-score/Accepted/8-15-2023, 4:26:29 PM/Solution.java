// https://leetcode.com/problems/find-the-maximum-divisibility-score

class Solution {
    public int maxDivScore(int[] nums, int[] div) {
        int res = 0;
        
        int[] arr = new int[div.length];
        
        int max = 0;
        
        TreeSet<Integer> set = new TreeSet<>();
        
        
        for(int j=0; j<div.length; j++){

            int cnt =0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]%div[j]==0)
                    cnt++;
            }
            
            arr[j] = cnt;
            
            if(cnt > max){
                set = new TreeSet<>();
                max = cnt;
                set.add(div[j]);
            }else if(cnt==max){
                set.add(div[j]);
            }
            
        }
        
        return set.first();
    }
}