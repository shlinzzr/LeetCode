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
    
    private void addSen(String sen){
        TrieNode node = root;
        for(char ch : sen.toCharArray()){
            int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
            if(node.arr[idx]==null){
                node.arr[idx]=new TrieNode();
            }

            node=node.arr[idx];
        }
        node.freq +=1;
        node.isWord=true;
        node.val=sen;
    }
    
    
    public List<String> input(char c) {
        if(c=='#'){
            addSen(prefix);
            prefix="";
            return new ArrayList<>();
        }
            
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

/*
["AutocompleteSystem",    [["i love you","island","iroman","i love leetcode"],[5,3,2,2]]
"input",
"input",
"input",
"input",
"input",
"input",
"input",
"input",
"input",
"input",
"input",
"input"]
[,["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]


expected
[null,
["i love you","island","i love leetcode"],    prefix= 'i'
["i love you","i love leetcode"],             prefix= 'i '
[],                                           prefix= 'i a'
[],                                       add prefix= 'i a'  ## end
["i love you","island","i love leetcode"],    prefix= 'i'
["i love you","i love leetcode","i a"],       prefix= 'i '
["i a"],                                      prefix= 'i a'
[],
["i love you","island","i a"],
["i love you","i a","i love leetcode"],
["i a"],
[]]


output 
[null,
["i love you","island","i love leetcode"],
["i love you","i love leetcode"],
[],
[],
["i love you","island","i love leetcode"],
["i love you","i love leetcode","i a"],
["i a","i a"],
[],
["i love you","island","i a"],
["i love you","i a","i love leetcode"],
["i a","i a"],
[]]





/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */