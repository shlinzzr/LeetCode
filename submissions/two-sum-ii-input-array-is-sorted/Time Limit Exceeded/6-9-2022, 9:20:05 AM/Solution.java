// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int st=0, ed=numbers.length-1, mid = numbers.length-1;
        
        for(int i=0; i<numbers.length-1;i++){
            // i=0
            int curr = numbers[i]; //2
            int comp = target - curr; //4
            
            st =i+1; // 1
            ed = mid; // 2
            
            while(st<=ed){
                mid = st + (ed-st)/2;  // 1 //2
                
                if(numbers[mid]==comp){
                    return new int[] {i+1, mid+1};
                }else if(numbers[mid] > comp){
                    ed = mid;
                }else{
                    st = mid+1; //2
                }
            }
            
            
        }
        
        return new int[2];
        
    }
}