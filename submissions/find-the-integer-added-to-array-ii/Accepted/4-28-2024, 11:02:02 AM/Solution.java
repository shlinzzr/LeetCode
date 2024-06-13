// https://leetcode.com/problems/find-the-integer-added-to-array-ii

class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        
        int sum2 = 0;
          Map<Integer, Integer> map2 = new HashMap<>();
        for(int n : nums2){
            sum2+= n;
            
            map2.put(n, map2.getOrDefault(n,0)+1);
            
        }
        
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum1 = 0;
        for(int n : nums1){
            map.put(n, map.getOrDefault(n,0)+1);
            sum1+= n;
        }
        
       
        
        
        Set<int[]> can = new LinkedHashSet<>();
        
        Arrays.sort(nums1);
        
        int len = nums2.length;
        for(int i=0; i<nums1.length ; i++){
            for(int j=i+1; j<nums1.length; j++){
                    
                // map.put(nums1[i], map.getOrDefault(nums1[i],0)-1);
                // map.put(nums1[j], map.getOrDefault(nums1[j],0)-1);
                // if(map.get(nums1[i])==0) map.remove(nums[i]);
                // if(map.get(nums1[j])==0) map.remove(nums[j]);
                    
                // 3 3 5 5 
                // 7 7 
                // 16-3-3-14 == -4
                
                
                if( (sum2 - (sum1-nums1[i]-nums1[j] ) )%len==0){
                    
                    int x = (sum2 - (sum1-nums1[i]-nums1[j] ) )/len;
                    can.add(new int[]{x, i, j});
                }
                
                // 4 5 7
                // 5
                // 5 - (16-5-4) == -2
                
                // 1 4 7 9
                // 0 8
                // 8- (21-1-4) == -8
            }
        }
        
        
        for( int[] el : can){
            
            boolean match = true;
            for(int i=0; i<nums1.length; i++){
                
                int x = el[0];
                int a = el[1];
                int b = el[2];
                
                if(i==a || i==b) continue;
                
                if(!map2.containsKey( nums1[i]+x)){
                    match=false;
                    break;
                }
                
            }
            
            if(match) return el[0];
        }
        
    
        
        
        
        return -1;
    }
}