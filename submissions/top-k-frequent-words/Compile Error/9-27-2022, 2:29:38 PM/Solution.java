// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        LRUCache cache = new LRUCache();
        
        
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(String w : words){
            pq.offer()
        }
    }
    
    
    public class LRUCache{
        
        public Tuple head;
        public Tuple tail;
        private int capacity = 0;
        public LRUCache(int k){
            head = new Tuple();
            tail = new Tuple();
            head.next = tail;
            tail.prev = head;
            capacity = k;
        }
        
        public void add(String s){
            Tuple t = new Tuple(s);
            Tuple ft = search(s);
            if(ft!=null){
                
                
            }
            
            
        }
        
        public Tuple search(String s){
            
            Tuple curr = head.next;
            while(curr!=null){
                if(curr.val.equals(s))
                    return curr;
            }
            return null;
        }
        
        
        public boolean isContain(String s){
            
            Tuple curr = head.next;
            while(curr!=null){
                if(curr.val.equals(s))
                    return true;
                
            }
            return false;
            
        }
        
        
        public class Tuple {
            
            public Node prev;
            public Node next;
            public String val;
            
            public Tuple(String s){
                prev = new Node();
                next = new Node();
                val = s;
            }
            
        }
        
    }
}