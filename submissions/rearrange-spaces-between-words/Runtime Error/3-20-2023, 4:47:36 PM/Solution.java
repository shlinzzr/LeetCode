// https://leetcode.com/problems/rearrange-spaces-between-words

class Solution {
    public String reorderSpaces(String text) {
        int cnt = 0, w=0;
        
        List<String > list = new ArrayList<>();
        
        String curr ="";
        for(int i=0; i<text.length(); i++){
            
            char ch = text.charAt(i);
            
            if(ch==' '){
                cnt++;
                continue;
            }
            
            curr += ch;
            while(i+1<text.length() && text.charAt(i+1)!=' '){
                curr+=text.charAt(i+1);
                i++;
            }
            list.add(curr);
            curr="";
        }        
        
        
        int blok = cnt/(list.size()-1);
        int mod = cnt % blok;
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<list.size(); j++){
            
            String s = list.get(j);
            sb.append(s);
            
            
            if(j!=list.size()-1){
                for(int i=0; i<blok; i++){
                    sb.append(' ');
                }    
            }
        }
        
        for(int i=0; i<mod; i++){
                sb.append(' ');
        }
        
        return sb.toString();
        
        
        
        
    }
}