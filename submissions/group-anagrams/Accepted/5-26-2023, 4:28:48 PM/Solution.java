// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s: strs){
            
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String cvt = new String(arr);
            
            if(map.containsKey(cvt)){
                map.get(cvt).add(s);
            }else{
                map.put(cvt, new ArrayList<>());
                map.get(cvt).add(s);
            }
        }
        
        for(Map.Entry<String, List<String>> en : map.entrySet()){
            res.add(new ArrayList<>(en.getValue()));
        }
        
        return res;
    }
}