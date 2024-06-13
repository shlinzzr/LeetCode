// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        
        for(String s : strs){
            
           
            String sa = getAlphaStr(s);
            // System.out.println(sa);
            List<String> list = map.getOrDefault(sa, new ArrayList<>());
            list.add(s);
            map.put(sa, list);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            res.add(en.getValue());
        }
        
        return res;
        
    }
    
    private String getAlphaStr(String s){
         int[] arr = new int[26];
         for(char ch : s.toCharArray()){
                arr[ch-'a']++;
         }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++){
            
            for(int j=0; j<arr[i];j++){
                sb.append((char)('a'+i));    
            }
            
            
        }
        
        return sb.toString();
    }
    
    
}