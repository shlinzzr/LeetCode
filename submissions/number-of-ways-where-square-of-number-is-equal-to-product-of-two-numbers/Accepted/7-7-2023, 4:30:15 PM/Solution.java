// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int M = (int) 1e9+7;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        TreeMap<Integer, Long> map1 = new TreeMap<>(); 
        TreeMap<Integer, Long> map2 = new TreeMap<>(); 
        
        for(int i=0; i<nums1.length; i++){
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0L)+1L);
        }
        
        for(int j=0; j<nums2.length; j++){
            map2.put(nums2[j], map2.getOrDefault(nums2[j], 0L)+1);
        }
        
        List<Integer> list1 = new ArrayList<>(map1.keySet());
        List<Integer> list2 = new ArrayList<>(map2.keySet());
        
        long res = 0L;
        // type1
        for(int i=0; i<list1.size(); i++){
            
            int j=0, k=list2.size()-1;
            
            while(j<=k){
                
                long tar = list1.get(i)*list1.get(i);
                long val = list2.get(j)*list2.get(k);
                
                if(val==tar){
                    
                    if(list2.get(j)==list2.get(k)){
                        long cnt = map2.get( list2.get(j) );
                        
                        
                        res = (res + map1.get(list1.get(i)) * (cnt) * (cnt-1)/2)%M;
                    }else{
                        res = (res + map1.get(list1.get(i)) * map2.get( list2.get(j)) * map2.get(list2.get(k)) ) %M;
                    }
                    j++;
                    k--;
                    
                    
                }else if(val<tar){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
      
        
          // type2
        for(int i=0; i<list2.size(); i++){
            
            int j=0, k=list1.size()-1;
            
            while(j<=k){
                
                long tar = (long)list2.get(i)*(long)list2.get(i);
                long val = (long)list1.get(j)*(long)list1.get(k);
                
                if(val==tar){
                    
                    if(list1.get(j)==list1.get(k)){
                        long cnt = map1.get( list1.get(j) );
                        
                         res = (res + map2.get( list2.get(i))%M * (cnt)%M * (cnt-1)/2%M ) %M;
                    }else{
                        res = ( res + map2.get(list2.get(i))%M * map1.get( list1.get(j))%M * map1.get(list1.get(k)) ) % M;
                    }
                    j++;
                    k--;
                    
                    
                }else if(val<tar){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return (int)res;
        
        
        
    }
}