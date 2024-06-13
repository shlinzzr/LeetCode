// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        int len = strs.length;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            int[] arr = new int[26];
            
            for(char ch : str.toCharArray()){
                arr[ch-'a']++;
            }
            
            String s = "";
            for(int i=0; i<26; i++){
                
                for(int r=0; r<arr[i]; r++){
                    s+=(char)(i+'a');    
                }
            }
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }
        
        res.addAll(map.values());
        
        return res;
        
        
    }
}