// https://leetcode.com/problems/find-and-replace-in-string

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int len = indices.length;
        int offset = 0;
        int base = 0;
        
        for(int i=0; i<len; i++){
            
            int idx = indices[i] + offset;
            
            if(idx<base)
                continue;
            
            String src = sources[i];
            String tar = targets[i];
            
            StringBuilder sb = new StringBuilder(s);
            sb.replace(idx, idx+src.length(), tar);
            base = idx+tar.length()+1;
            offset += tar.length()-src.length();
            
            
            s = sb.toString();
        }
        
        return s;
    }
}