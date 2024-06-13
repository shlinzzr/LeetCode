// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        
        int idx =0, len=arr.length;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0; i<len; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            
        }
        
        for(int i=0; i<len; i++){
            
            
            map.put(arr[i], map.get(arr[i])-1);
            if(map.get(arr[i])==0) 
                map.remove(arr[i]);
            
            Integer max = map.isEmpty() ? null : map.lastKey();
            arr[i] = max==null ? -1 : max;
            
        }
        
        return arr;
        
        
        
    }
}
