// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();
         HashMap<String , Set<String>> map = new HashMap<>();
        
        for(String s : strs){
            String org = getStr(s);
            if(!map.containsKey(org)){
                map.put(org, new HashSet<>());
            }
            map.get(org).add(s);
        }
        
        for(Map.Entry<String, Set<String>> en : map.entrySet()){
            res.add(new ArrayList<>(en.getValue()));
        }
        
        return res;
        
        
    }
    
    private String getStr(String s){
        
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            while(arr[i]>0){
                sb.append( (i+'a'));
                arr[i]--;
            }
        }
        
        return sb.toString();
        
        
    }
}