// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            
            String nor = normalize(s);
            // System.out.println(s + "=>" + nor);
            map.putIfAbsent(nor, new ArrayList<>());
            map.get(nor).add(s);
        }
        
        for(List<String> list : map.values()){
            res.add(list);
        }
        
        return res;
        
    }
    
    private String normalize(String s){
        
        int[] arr = new int[26];
        
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        String res = "";
        for(int i=0; i<26; i++){
            
            for(int j=0; j<arr[i]; j++){
                res += (char)(i+'a');
            }
        }
        
        return res;
    }
}