// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        
        for(String s : strs){
            String key = genKey(s);
            if(map.containsKey(key))
                res.get(map.get(key)).add(s);
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                res.add(list);
                map.put(key, res.size()-1);
            }
        }
        
        return res;
        
    }
    
    
    private String genKey(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++ ){
            
            while(arr[i]>0){
                sb.append(i+'a');
                arr[i]--;
            }
        }
        
        return sb.toString();
        
        
    }
}