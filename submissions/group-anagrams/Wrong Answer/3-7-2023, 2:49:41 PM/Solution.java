// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>  res = new ArrayList<>();
        
        HashMap<String, Set<String>> map = new HashMap<>();
        for(String s : strs){
            
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            
            String k = String.valueOf(ca);
            
            map.putIfAbsent(k, new HashSet<>());
            map.get(k).add(s);
        }
        
        for(Map.Entry<String, Set<String>> en : map.entrySet()){
            res.add(new ArrayList<>(en.getValue()));
        }
        
        return res;
    }
}