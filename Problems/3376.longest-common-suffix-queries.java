// https://leetcode.com/problems/longest-common-suffix-queries

class Solution {
    
    TrieNode root;
    
    class TrieNode{
        
        TrieNode[] children;
        boolean isWord;
        List<WCON> list;
        
        public TrieNode(){
            children = new TrieNode[26];
            list = new ArrayList<>();
        }
    }
    
    class WCON{
        String s;
        int idx;
        
        public WCON(String s, int idx) {
            this.s= s;
            this.idx=idx;
        }
        
    }
    
    public int[] stringIndices(String[] wc, String[] wq) {
       
        
        int len = wc.length;
        
         root = new TrieNode();
        for(int i =0; i<len; i++){
            
            String w = wc[i];
            WCON obj = new WCON(w, i);
            
            TrieNode cur = root;
            
            root.list.add(obj);
            for(int j=w.length()-1; j>=0; j--){
                char ch = w.charAt(j);
                if(cur.children[ch-'a']==null)
                    cur.children[ch-'a'] = new TrieNode();
                cur = cur.children[ch-'a'];
                cur.list.add(obj);
                
                Collections.sort(cur.list, (a,b)->a.s.length()!=b.s.length() ? a.s.length()-b.s.length() : a.idx-b.idx);
            }
            
            cur.isWord = true;
        }
        
         Collections.sort(root.list, (a,b)->a.s.length()!=b.s.length() ? a.s.length()-b.s.length() : a.idx-b.idx);
        
        int[] res = new int[wq.length];
        
        
        for(int i=0; i<wq.length ;i++){
            
            String w = wq[i];
            
            boolean found = true;
            TrieNode cur = root;
            List<WCON> list = new ArrayList<>();
            for(int j=w.length()-1; j>=0; j--){
                
                char ch = w.charAt(j);
                if(cur.children[ch-'a']==null){
                    break;
                }
                
                cur = cur.children[ch-'a'];
                list = cur.list;
            }
            
                res[i] = cur.list.get(0).idx;
            
        }
                                  
                                  return res;
        
        
        
        
        
        
        
        
    }
}