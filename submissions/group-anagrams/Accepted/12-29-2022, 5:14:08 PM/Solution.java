// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            
            String aa = getAlpha(s);
            if(!map.containsKey(aa)){
                map.put(aa , new ArrayList<>());
            }
            
            map.get(aa).add(s);
        }
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            res.add(en.getValue());
        }
        
        return res;
        
        
    }
    
    private String getAlpha(String s){
        
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        
        for(int i=0; i<26; i++){
            
            if(arr[i]!=0){
                
                for(int j=0; j<arr[i]; j++){
                    sb.append(i+'a');
                }
            }
        }
        
        return sb.toString();
        
        
        
    }
}