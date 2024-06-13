// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        TreeMap<Integer, Integer> map1 = new TreeMap<>(); 
        TreeMap<Integer, Integer> map2 = new TreeMap<>(); 
        
        for(int i=0; i<nums1.length; i++){
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        }
        
        for(int j=0; j<nums2.length; j++){
            map2.put(nums2[j], map2.getOrDefault(nums2[j], 0)+1);
        }
        
        List<Integer> list1 = new ArrayList<>(map1.keySet());
        List<Integer> list2 = new ArrayList<>(map2.keySet());
        
        long res = 0L;
        // type1
        for(int i=0; i<list1.size(); i++){
            
            int j=0, k=list2.size()-1;
            
            while(j<=k){
                
                int tar = list1.get(i)*list1.get(i);
                int val = list2.get(j)*list2.get(k);
                
                if(val==tar){
                    
                    if(list2.get(j)==list2.get(k)){
                        int cnt = map2.get( list2.get(j) );
                        
                        
                        res += map1.get(list1.get(i)) * (cnt) * (cnt-1)/2;
                    }else{
                        res += map1.get(list1.get(i)) * map2.get( list2.get(j)) * map2.get(list2.get(k));
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
                
                int tar = list2.get(i)*list2.get(i);
                int val = list1.get(j)*list1.get(k);
                
                if(val==tar){
                    
                    if(list1.get(j)==list1.get(k)){
                        int cnt = map1.get( list1.get(j) );
                        
                        // res += cnt * (cnt-1);
                         res += map2.get( list2.get(i)) * (cnt) * (cnt-1)/2;
                    }else{
                        res += map2.get(list2.get(i)) * map1.get( list1.get(j)) * map1.get(list1.get(k));
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