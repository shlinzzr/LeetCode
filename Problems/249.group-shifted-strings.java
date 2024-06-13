// https://leetcode.com/problems/group-shifted-strings

class Solution {
    public List<List<String>> groupStrings(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        int len = strs.length;
        
        for(int i=0; i<len; i++){
            String w = strs[i];
            String org = getOrg(w.toCharArray());
            
            map.putIfAbsent(org, new ArrayList<>());
            map.get(org).add(w);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(List<String> list : map.values()){
            res.add(list);
        }
        
        return res;
        
        
    }
    
    private String getOrg(char[] arr) {
        
        while(arr[0]!='a'){
            
            for(int i=0; i<arr.length; i++){
                int idx = arr[i]-'a';
                idx = (idx + 27)%26;
                arr[i] = (char) (idx+'a');
                
                System.out.println(idx);
            }
            
        }
        
        return new String(arr);
    }
    
}