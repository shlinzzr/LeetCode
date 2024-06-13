// https://leetcode.com/problems/brace-expansion

class Solution {
    public String[] expand(String s) {
        
        
        List<List<Character>> dict = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch=='{'){
                
                int st = i+1;
                int cnt= 1 ;
                while(i+1<s.length() && cnt!=0){
                    i++;
                    char chh = s.charAt(i);
                    if(chh=='{') cnt++;
                    if(chh=='}') cnt--;
                }
                
                String sub = s.substring(st, i);
                String[] arr = sub.split(",");
                List<Character> sublist = new ArrayList<>();
                for(String a : arr){
                    sublist.add(a.charAt(0));
                }
                dict.add(sublist);
            }else{
                
                List<Character> ll = new ArrayList<>();
                ll.add(ch);
                dict.add(ll);
            }
        }
        
        System.out.println(dict);
        
        List<String> res= new ArrayList<>();
        helper(dict, 0, res, new StringBuilder());
        
        String[] rt = new String[res.size()];
        for(int i=0; i<res.size(); i++){
            rt[i] = res.get(i);
        }
        return rt;
        
    }
    
    private void helper(List<List<Character>> dict, int idx, List<String> res, StringBuilder sb){
        
        if(idx==dict.size()){
            res.add(sb.toString());
            return;
        }
        
        for(char ch : dict.get(idx)){
            sb.append(ch);
            helper(dict, idx+1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    } 
}
