// https://leetcode.com/problems/find-and-replace-in-string

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        HashMap<Integer, String[]> map = new HashMap<>();
        for(int i=0; i<sources.length; i++){
            
            int idx = indices[i];
            
            String src = sources[i];
            String tar = targets[i];
            
            if( idx+src.length()<=s.length() && src.equals(s.substring(idx, idx+src.length())))
                map.put(idx, new String[]{src, tar});
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            
            if(map.containsKey(i)){
                
                sb.append(map.get(i)[1]);
                i+=map.get(i)[0].length()-1;
            }else
                sb.append(s.charAt(i));
        }
               
               return sb.toString();
            
        
        
    }
       
}