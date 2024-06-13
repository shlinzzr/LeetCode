// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         HashMap<Integer, Integer>map = new HashMap<>();
        
//         for(int i=0; i<numbers.length; i++){
//             int comp = target - numbers[i];
//             if(map.containsKey(comp))
//                 return new int[]{ map.get(comp), i+1};
//             else
//                 map.put(numbers[i], i+1);
//         }
        
//         return new int[2];
//         // throws new Exception("fail");
//     }
    
    public int[] twoSum(int[] numbers, int target) {
        
        
        int lo=0;
        int hi = numbers.length-1;
        
        while(lo<hi){
          
            if(numbers[lo]+numbers[hi]==target)
                return new int[]{lo+1, hi+1}; 
            
            else if(numbers[lo]+numbers[hi]>target)
                hi--;
                
            else
                lo++;
        }
        
        return new int[2];
        // throws new Exception("fail");
    }
}