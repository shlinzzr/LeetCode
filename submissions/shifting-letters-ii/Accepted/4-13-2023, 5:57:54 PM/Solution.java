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
            // System.out.println(en.getKey() + " " + curr);
        }        
        
         // System.out.println("///////////////");
        
        char[] arr = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            
            Integer key = new_map.floorKey(i);
            
            if(key==null)
                continue;
            
            int offset = new_map.get(key);
            
//             System.out.println(i + " key=" + key + " off=" + offset);
            
            int val = (arr[i]-'a'+offset)%26;
            if(val<0) val+=26;
            arr[i] = (char)(val+'a');
        }
        
        return new String(arr);
        
        
    }
}
