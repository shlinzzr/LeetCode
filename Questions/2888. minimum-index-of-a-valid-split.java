// https://leetcode.com/problems/minimum-index-of-a-valid-split

class Solution {
    public int minimumIndex(List<Integer> nums) {
        
        List<Long> left = new ArrayList<>();
        
        HashMap<Long, Integer> map = new HashMap<>();
        
        long max = (long)nums.get(0);
        int cnt = 1;
        
        for(int i=0; i<nums.size(); i++){
            long n = (long)nums.get(i);
            map.put((long)n, map.getOrDefault(n,0)+1);
            
            if(map.get(n)>cnt){
                cnt = map.get(n);
                max = n;
            }
            if(map.get(max)*2>i+1)
                left.add(max);
            else 
                left.add(-1L);
        }
        
        
        map = new HashMap<>();
        max = nums.get(nums.size()-1);
        cnt=1;
        List<Long> right  = new ArrayList<>();
        for(int i=nums.size()-1; i>=0; i-- ){
            
            long n  = (long)nums.get(i);
            map.put((long)n, map.getOrDefault(n,0)+1);
            
            if(map.get(n)>cnt){
                cnt = map.get(n);
                max = n;
            }
            
            // System.out.println( " i=" + i + " max="+max + " map.get(max)="+map.get(max));
            
            if(map.get(max)*2>nums.size()-i)
                right.add(0, max);
            else 
                right.add(0, -1L);
            
            
        }
        
        
//         for(int i=0; i<10; i++){
//             System.out.print(left.get(i) + ", ");
//         }
//         System.out.println();
        
//         for(int i=0; i<10; i++){
//             System.out.print(right.get(i) + ", ");
//         }
//         System.out.println();
        
        
        // System.out.println(left.get(6)-right.get(6));
        for(int i=0; i<nums.size()-1; i++){
            
            if(left.get(i)-right.get(i+1)==0 && left.get(i)!=-1)
                return i;
        }
        
        return -1;
        
        
        
        
        
        
    }
}