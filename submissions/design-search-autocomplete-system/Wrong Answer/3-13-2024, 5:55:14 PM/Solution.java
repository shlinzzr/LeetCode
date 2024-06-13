// https://leetcode.com/problems/design-search-autocomplete-system

class AutocompleteSystem {
    
    TrieNode root;
    StringBuilder sb;
    
    class Tuple{
        String s;
        int f;
        public Tuple(String s, int f){
            this.s = s;
            this.f = f;
        }
    }
    
    class TrieNode{
        boolean isWord;
        TrieNode[] arr;
        List<String> candidate;
        public TrieNode(){
            arr = new TrieNode[27];
            candidate = new ArrayList<>();
        }
        
        public void add(String s){
            TrieNode curr = root;
            for(char ch : s.toCharArray()){
                int idx = (ch==' ') ? 26 : (ch-'a');
                if(curr.arr[idx]==null){
                    curr.arr[idx] = new TrieNode();
                }

                curr = curr.arr[idx];
                curr.candidate.add(s);
            }
            
            curr.isWord = true;
        }
        
        public List<String> startsWith(String s){
            TrieNode curr = root;
            for(char ch : s.toCharArray()){
                int idx = ch==' ' ? 26 : (ch-'a');
                if(curr.arr[idx]==null){
                    return new ArrayList<>();
                }
                curr = curr.arr[idx];
            }
            
            return getTop3(curr.candidate);
        }
        
        private List<String> getTop3(List<String> input){
            
            List<Tuple> list = new ArrayList<>();
            for(String in : input){
                Tuple t = new Tuple(in, map.get(in));
                list.add(t);
            }
            
            Collections.sort(list, (a,b)->b.f==a.f ? a.s.compareTo(b.s) : b.f-a.f);
            
            List<String> res = new ArrayList<>();
            for(int i=0; i<Math.min(list.size(), 3); i++){
                res.add(list.get(i).s);
            }
            
            return res;
            
            
            
            
            
        }
    }
    
    
    
    Map<String, Integer> map;

    public AutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        map = new HashMap<>();
        int len = times.length;
        
        root = new TrieNode();
        for(int i=0; i<len ;i++){
            String s = sentences[i];
            root.add(s);
            
            map.put(s, times[i]);
        }
    }
    
    public List<String> input(char c) {
        
        if(c=='#'){
             sb = new StringBuilder();
            return new ArrayList<>();
        }
        
        sb.append(c);
        TrieNode curr = root;
        return curr.startsWith(sb.toString());
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */