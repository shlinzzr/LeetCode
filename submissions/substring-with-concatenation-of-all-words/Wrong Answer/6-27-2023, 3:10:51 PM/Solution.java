// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>  res = new ArrayList<>();
        
        Set<String> concat = new HashSet<>();
        
        
        int len = words.length;
        boolean[] used = new boolean[len];
        gen(concat, words, new StringBuilder(), used);
        
        int wl = words[0].length();
        int sl = wl*len;
        
        // for(String c: concat){
        //     System.out.println(c);
        // }
        
        
        for(int i=0; i<s.length()-sl; i++){
            
            String sub = s.substring(i, i+sl);
            
            if(concat.contains(sub))
                res.add(i);
        }
        
        
        return res;
        
        
        
    }
    
    
    private void gen(Set<String> concat, String[]words, StringBuilder sb,  boolean[] used){
        
        int len = words.length;
        if(sb.length()==words[0].length()*len){
            concat.add(sb.toString());
            return ;
        }
        
        for(int i=0; i<len; i++){
            
            if(used[i]==false){
                
                used[i]=true;
                StringBuilder sbb = new StringBuilder(sb);
                sbb.append(words[i]);
                gen(concat, words, sbb, used);
                
                used[i]=false;
            }
        }
    }
}