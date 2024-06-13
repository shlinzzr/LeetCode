// https://leetcode.com/problems/alien-dictionary

class Solution {
   public String alienOrder(String[] words) {
      
       
       // words = ["wrt","wrf","er","ett","rftt"]
       // t<f
       // w<e
       // r<t
       // e<r
       
       
       
       // edge case
        if(words==null || words.length==0) 
            return "";
       
        
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
       
        // init 
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
       
        // build map & degree
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            
            int len=Math.min(cur.length(), next.length());
            
            
            // edge case : 當前面比較長而且prefix相等的時候 ex: ["wrtab", "wrt"] => 不可能存在 ( the order is invalid )
            if(cur.length()>next.length() && cur.substring(0, len).equals(next))
                return "";
            
            for(int j=0; j<len; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                
                if(c1!=c2){
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
       
       
       // bfs
        Queue<Character> q = new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
       
       
        while(!q.isEmpty()){
            char c=q.poll();
            result+=c;
            
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) 
                        q.add(c2);
                }
            }
        }
       
        
       return result.length()!=degree.size()? "" : result;
        
        
    }
}