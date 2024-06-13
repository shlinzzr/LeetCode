// https://leetcode.com/problems/design-search-autocomplete-system

class AutocompleteSystem {

    class TrieNode{
        TrieNode[] arr;
        boolean isWord;
        String val;
        int freq = 0;
        
        public TrieNode(){
            arr = new TrieNode[28]; //0-25=a~z, 26=' ', 27='#'
            isWord=false;
        }
        
    }
    
    TrieNode root;
    String prefix="";
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        
        root = new TrieNode();
        
        for(int i=0; i<sentences.length; i++){
            
            String sen = sentences[i];
            TrieNode node = root;
            for(char ch : sen.toCharArray()){
                
                int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
                if(node.arr[idx]==null){
                    node.arr[idx]=new TrieNode();
                }
                
                node=node.arr[idx];
            }
            node.freq = times[i];
            node.isWord=true;
            node.val=sen;
        }
    }
    
    public List<String> input(char c) {
        // if(c=='#')
        //     return new ArrayList<>();
        prefix += c;
        
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(
            (a,b) -> a.freq==b.freq ? b.val.compareTo(a.val) : a.freq-b.freq
        );
        
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
            if(node.arr[idx]==null){
                return new ArrayList<>();
            }
            node = node.arr[idx];
        }
        
        
        
        if(node.isWord){
            pq.offer(node);
        }
            
        getSub(node, pq);
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().val);
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