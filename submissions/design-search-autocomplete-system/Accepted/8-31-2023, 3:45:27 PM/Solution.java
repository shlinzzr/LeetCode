// https://leetcode.com/problems/design-search-autocomplete-system

class AutocompleteSystem {


    
    class TrieNode{
        
        TrieNode[] arr;
        boolean isWord;
        String str;
        int time;
        Set<String> set;
        
        public TrieNode(){
            set = new TreeSet<>();
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
            curr.set.add(s);
            
            for(int j=0; j<s.length(); j++){
                char ch = s.charAt(j);
                int idx = ch==' ' ? 26 : ch=='#' ? 27 : (int) (ch-'a');
                if(curr.arr[idx]==null){
                    curr.arr[idx] = new TrieNode();
                }
                
                // curr.arr[idx].time += t;
                curr = curr.arr[idx];
                curr.set.add(s);
            }
            curr.time = t;
            curr.isWord=true;
            curr.str = s;
        }
        
    }
//      public AutocompleteSystem(String[] sentences, int[] times) {
        
//         root = new TrieNode();
        
//         for(int i=0; i<sentences.length; i++){
            
//             String sen = sentences[i];
//             TrieNode node = root;
//             for(char ch : sen.toCharArray()){
                
//                 int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
//                 if(node.arr[idx]==null){
//                     node.arr[idx]=new TrieNode();
//                 }
                
//                 node=node.arr[idx];
//             }
//             node.time = times[i];
//             node.isWord=true;
//             node.str=sen;
//         }
//     }
    
//     public List<String> input(char c) {
//         List<String> res = new ArrayList<>();
//         search += c;
        
//         TrieNode curr = root;
        
//         for(int i=0; i<search.length(); i++){
//             char ch = search.charAt(i);
//             int idx = ch==' ' ? 26 : ch=='#' ? 27 : (int) (ch-'a');
            
//             if(curr==null || curr.arr[idx]==null)
//                 return res;
            
//             curr = curr.arr[idx];
//         }
        
//         List<String> sorted = new ArrayList<>(curr.set);
//         for(int i=sorted.size()-1; i>=0; i--){
//             String s = sorted.get(i);
//             res.add(s);
//             if(res.size()==3)
//                 break;
//         }
        
//         return res;
        
//     }
    
    private void addSen(String sen){
        TrieNode node = root;
        for(char ch : sen.toCharArray()){
            int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
            if(node.arr[idx]==null){
                node.arr[idx]=new TrieNode();
            }

            node=node.arr[idx];
        }
        node.time +=1;
        node.isWord=true;
        node.str=sen;
    }
    
    
    public List<String> input(char c) {
        if(c=='#'){
            addSen(search);
            search="";
            return new ArrayList<>();
        }
            
        search += c;
        
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(
            (a,b) -> a.time==b.time ? b.str.compareTo(a.str) : a.time-b.time
        );
        
        TrieNode node = root;
        for(int i=0; i<search.length(); i++){
            char ch = search.charAt(i);
            int idx = ch==' ' ? 26 : (ch=='#'? 27 : ch-'a');
            if(node.arr[idx]==null){
                return new ArrayList<>();
            }
            node = node.arr[idx];
        }
            
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