// https://leetcode.com/problems/shortest-uncommon-substring-in-an-array

class Solution {
    public String[] shortestSubstrings(String[] arr) {
        
        int len = arr.length;
        
        String[] res = new String[len];
        for(int i=0; i<len; i++){
            List<String> list = getSub(arr[i]);
                
            
            Collections.sort(list, (a,b)-> a.length()==b.length() ? a.compareTo(b) : a.length()-b.length());
            // System.out.println(list);
            for(int j=0; j<list.size(); j++){
            
                boolean hit = true;
                String s = list.get(j);
                
                for(int k=0; k<len ;k++){
                    if(k==i) continue;
                    if(arr[k].contains(s)){
                        hit=false;
                        break;
                    } 
                }
                
                if(hit) {
                     res[i] = s;
                    break;
                }
                else res[i] = "";
            }
        }
        
        
  
        
        return res   ;
        
    }
    
    private List<String> getSub (String s){
        
        Set<String> set = new TreeSet<>();
        for(int wLen = 1; wLen<=s.length(); wLen++){
            for(int i=0; i+wLen<=s.length(); i++){
                set.add(s.substring(i, i+wLen));
            }
        
        }
        
        return new ArrayList<>(set);
    }
}