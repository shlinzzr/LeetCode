// https://leetcode.com/problems/reorganize-string

class Solution {
    
    class Tuple{
        int cnt;
        char ch;
        public Tuple( char ch, int cnt){
            this.cnt = cnt;
            this.ch = ch;
        }
    }
    
    
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Tuple> pa = new PriorityQueue<>( (a,b) -> b.cnt-a.cnt);
        PriorityQueue<Tuple> pb = new PriorityQueue<>( (a,b) -> b.cnt-a.cnt);
        
        
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            pa.offer(new Tuple(en.getKey(), en.getValue()));
        }
        
        
        Character prev = null;
        StringBuilder sb = new StringBuilder();
        
        while(!pa.isEmpty() ){

            Tuple t = null;
            
            if(!pb.isEmpty() && pb.peek().ch!=prev) 
                t = pb.poll();
            
            else if(pa.isEmpty() || (prev!=null && pa.peek().ch==prev))
                return "";
            
            else 
                t = pa.poll();
            
            sb.append(t.ch);
            prev= t.ch;
            t.cnt--;
            if(t.cnt>0)
                pb.offer(t);
            
            if(pa.isEmpty()&&!pb.isEmpty()){
                
                pa.offer(pb.poll());
                
            }
            
        }
        
        return sb.toString();
        
            
        
        
        
            
            
            
            
            
            
        
    }
}