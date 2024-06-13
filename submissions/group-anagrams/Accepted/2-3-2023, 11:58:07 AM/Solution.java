// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf( ca);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            
            res.add(en.getValue());
        }
        
        
        return res;
        
    }
}