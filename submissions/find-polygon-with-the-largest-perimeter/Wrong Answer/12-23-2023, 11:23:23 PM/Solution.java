// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter

class Solution {
    public long largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        
        int[] presum = new int[len];
        for(int i=0;i<len; i++)
        {
            presum[i]= i==0 ? nums[0] : nums[i]+presum[i-1];
        }
        
        for(int i=len-1; i>0; i--){
            
            int a = nums[i];
            
            if(a<presum[i-1]){
                return presum[i-1]+a;
            }
//             map.put(a, map.getOrDefault(a,0)-1);
//             if(map.get(a)==0) map.remove(a);
            
//             Integer b = map.floorKey(a);
//             if(b==null || b<= a/2)
//                 continue;
            
//             Integer c = map.floorKey(b);
//             if(c==null || b+c<=a)
//                 continue;
            
//             System.out.println(a+" " +b+" "+c);
            
//             if(b+c>a) return a+b+c; 
            
            
        }
        
        return -1;
        
        
        
        
        
//         for(int i=len-1; i>=0; i--){
//             for(int j=i-1; j>=0; j--){
//                 for(int k=j-1; k>=0; k--){
//                     if(nums[k]+nums[j]>nums[i]) return nums[i]+nums[j]+nums[k];
//                 }
//             }
                
//         }
//         return -1;
        
    }
}