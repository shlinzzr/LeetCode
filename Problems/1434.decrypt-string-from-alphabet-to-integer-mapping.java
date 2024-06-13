// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping

class Solution {
    public String freqAlphabets(String s) {
        HashMap<String, String> map = new HashMap<>();
        for(char ch = 'j'; ch<='z'; ch++){
            map.put(((ch-'a')+1) + "#", ""+ch);
        }
        
        for(Map.Entry<String, String> en : map.entrySet()){
            s=s.replaceAll(en.getKey(), en.getValue());
        }
        
        
        for(char ch = 'a'; ch<='i'; ch++){
            map.put(((ch-'a')+1)+"" , ""+ch);
        }
        
        
        for(Map.Entry<String, String> en : map.entrySet()){
            s= s.replaceAll(en.getKey(), en.getValue());
        }
        
        return s;
        
        
    }
}