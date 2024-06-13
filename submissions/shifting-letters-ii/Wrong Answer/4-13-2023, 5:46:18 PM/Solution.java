// https://leetcode.com/problems/shifting-letters-ii

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int[] sh: shifts){
            
            if(sh[2]==1){
                map.put(sh[0], map.getOrDefault(sh[0], 0)+1);
                map.put(sh[1]+1, map.getOrDefault(sh[1]+1, 0)-1);    
            }else{
                map.put(sh[0], map.getOrDefault(sh[0], 0)-1);
                map.put(sh[1]+1, map.getOrDefault(sh[1]+1, 0)+1);    
            }
        }
        
        int curr=0;
        TreeMap<Integer, Integer> new_map = new TreeMap<>();
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            curr+=en.getValue();
            new_map.put(en.getKey(), curr);
        }        
        
        char[] arr = s.toCharArray();
        for(Map.Entry<Integer, Integer> en : new_map.entrySet()){
            
           
            int idx = en.getKey();
            
             if(idx>=s.length())
                continue;
            
            int offset = en.getValue();
            int val = (arr[idx]-'a'+offset)%26;
            if(val<0) val+=26;
            arr[idx] = (char)(val+'a');
        }
        
        return new String(arr);
        
        
    }
}
