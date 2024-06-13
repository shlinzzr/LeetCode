// https://leetcode.com/problems/majority-element

class Solution {
    
    //sol 1 : brute force : Time(n^2) Space(1)
    //sol 2 : HashMap : Time(n)     Space(n)
    //sol 3 : sorting : Time(nlgn), Space(1)
    //sol 4 : bit     : Time(nlogC) Space(1)
    //sol 5 : randomization ???
    //sol 6 : divide & conquer ??? 
    
    //sol 7 : Boyer-Moore Time(n), Space(1)
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int major = nums[0];
        int cnt = 1;

        for(int i=1;i<len; i++){
            if(nums[i]==major){
                cnt++;
            }else{
                cnt--;
            }

            if(cnt==-1){
                cnt = 1;
                major = nums[i];
            }
        }

        return major;
      
    }
}