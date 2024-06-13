// https://leetcode.com/problems/alien-dictionary

class Solution {
   public String alienOrder(String[] words) {
       
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) 
            return "";
       
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
       
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            
            int len=Math.min(cur.length(), next.length());
            
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
       
        Queue<Character> q=new LinkedList<Character>();
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