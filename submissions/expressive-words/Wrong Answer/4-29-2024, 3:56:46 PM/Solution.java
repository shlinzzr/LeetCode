// https://leetcode.com/problems/expressive-words

class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int len = words.length;
        
        boolean[] isValid = new boolean[len];
        Arrays.fill(isValid, true);
        
        List<int[]> rules = new ArrayList<>(); // char, wLen
        
        int st= 0;
        for(int ed=0; ed<s.length(); ed++){
            char ch = s.charAt(st);
            
            while(ed+1<s.length() && s.charAt(ed+1)==ch){
                ed++;
            }
            
            int wLen = ed-st+1;
            
            rules.add(new int[]{ch-'a', wLen});
            st = ed+1;
        }
        
        
        
        for(int i=0; i<words.length; i++){
            String w = words[i];
            st=0;
            
            int idx = 0;
            for(int ed=0; ed<w.length(); ed++){
                char ch = w.charAt(st);
                while(ed+1<w.length() && w.charAt(ed+1)==ch){
                    ed++;
                }
                
                int wLen = ed-st+1;
                int[] r = rules.get(idx++);
                
                char r_ch = (char)(r[0]+'a');
                if(r_ch!=ch){
                    // System.out.println(w+ " " + r_ch);
                    isValid[i]=false;
                    break;
                }
                
                if(r[1]<3 && r[1]!=wLen){
                    // System.out.println(w+ " " + wLen);
                    isValid[i] = false;
                    break;
                }
                
                st = ed+1;
            }
            
            if(idx!=rules.size()) isValid[i]=false;
        }
        
        int res= 0 ;
        for(int i=0; i<words.length; i++){
            if(isValid[i]) res++;
        }
        
        return res;
        
        
        
    }
}