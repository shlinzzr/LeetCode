// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int st=0, ed=numbers.length-1, mid = numbers.length-1;
        
        for(int i=0; i<numbers.length-1;i++){
            
            int curr = numbers[i];
            int comp = target - curr;
            
            st =i+1;
            ed = mid;  
            
            while(st<ed){
                mid = st + (ed-st)/2;
                
                if(numbers[mid]==comp){
                    return new int[] {i+1, mid+1};
                }else if(numbers[mid] > comp){
                    ed = mid;
                }else{
                    st = mid+1;
                }
            }
            
            
        }
        
        return new int[2];
        
    }
}