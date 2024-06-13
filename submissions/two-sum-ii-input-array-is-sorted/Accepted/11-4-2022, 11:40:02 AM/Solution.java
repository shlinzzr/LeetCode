// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        
        int len = numbers.length;
        
        for(int i=0; i<len;i++){

            int curr = numbers[i];
            int comp = target-curr;
            
            int st=i+1, ed=len-1;
            while(st<=ed){
                int mid = st+(ed-st)/2;
                
                if(numbers[mid]==comp)
                    return new int[]{i+1, mid+1};
                
                else if(numbers[mid]>comp){
                    ed = mid-1;
                }else{
                    st= mid+1;
                }
            }
        }
        
        return new int[2];
    }
}