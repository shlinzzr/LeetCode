// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        if(pattern.length()!=arr.length)
            return false;
        
        
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(!map.containsKey(ch)){
                
                if(set.contains(arr[i]))
                    return false;
                
                map.put(ch, arr[i]);
                set.add(arr[i]);
            }
            
            else if(!map.get(ch).equals(arr[i])){
                return false;
            }
        }
        return true;
    
        
    }
}