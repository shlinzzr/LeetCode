// https://leetcode.com/problems/design-search-autocomplete-system

class AutocompleteSystem {
    
    class TrieNode{
        TrieNode[] arr;
        boolean isWord;
        String str;
        int time;
        // Set<String> set;
        
        public TrieNode(){
            // set = new TreeSet<>();
            arr = new TrieNode[28];
            time =0;
        }
    }
    TrieNode root;    
    String search = "";
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        int n = times.length;
        root = new TrieNode();
        
        for(int i=0; i<n; i++){
            TrieNode curr = root;
            String s = sentences[i];
            int t = times[i];
            
            addString(s, t);
        }
    }
    
    private void addString(String s, int t){
        TrieNode node = root;
        for(char ch : s.toCharArray()){
            int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
            if(node.arr[idx]==null){
                node.arr[idx]=new TrieNode();
            }

            node=node.arr[idx];
        }
        node.time +=t;
        node.isWord=true;
        node.str=s;
    }
    
    
    public List<String> input(char c) {
        if(c=='#'){
            addString(search, 1);
            search="";
            return new ArrayList<>();
        }
            
        search += c;
        
        TrieNode node = root;
        for(int i=0; i<search.length(); i++){
            char ch = search.charAt(i);
            int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
            if(node.arr[idx]==null){
                return new ArrayList<>();
            }
            node = node.arr[idx];
        }
        
        
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(
            (a,b) -> a.time==b.time ? b.str.compareTo(a.str) : a.time-b.time
        );
            
        getSub(node, pq);
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().str);
        }
        
        return res;
    }
    
    
    private void getSub(TrieNode node, PriorityQueue<TrieNode> pq){
        
        if(node.isWord){
            pq.offer(node);
        }
        
        if(pq.size()>3){
            pq.poll();
        }
        
        for(int idx=0; idx<28; idx++){
            if(node.arr[idx]!=null){
                getSub(node.arr[idx], pq);
            }
        }        
        
    }
    
    
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */