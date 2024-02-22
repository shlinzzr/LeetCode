class Solution {
    
    
    TrieNode pRoot = new TrieNode();
    TrieNode sRoot = new TrieNode();
    public long countPrefixSuffixPairs(String[] words) {
        
        int len = words.length;
        
        for(int i=1; i<len; i++){
            String w = words[i];
            insertPrefix(w, i);
            insertSuffix(w, i);
        }
        
        
        long res = 0;
        for(int i=0; i<len; i++){
            String a = words[i];
            
            Set<Integer> pre = searchPrefix(a);
            Set<Integer> suf = searchSuffix(a);
            Set<Integer> inter = new HashSet<>(pre);
            inter.retainAll(suf);
            res += inter.size();
            
            removeSuffix(a,i);
             removePrefix(a,i);
            
        }
        
        
        return res;
        
    }
    
    
    class TrieNode {
        
        TrieNode[] arr;
        boolean isWord;
        
        public TrieNode(){
            arr = new TrieNode[26];
            set = new HashSet<>();
            idxs = new HashSet<>();
        }
        
        Set<String> set;
        Set<Integer> idxs;
     
    }
    
      
    public void removeSuffix(String word, int idx){
        TrieNode node = sRoot;
         node.idxs.remove(idx);
        for(int i=word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(node.arr[c-'a']==null)
                node.arr[c-'a'] = new TrieNode();
            node = node.arr[c-'a'];
            node.idxs.remove(idx);
        }
        node.isWord = true;
    }

    
    public void removePrefix(String word, int idx){
        TrieNode node = pRoot;
        node.idxs.remove(idx);
        for(char c : word.toCharArray()){
            if(node.arr[c-'a']==null)
                node.arr[c-'a'] = new TrieNode();
            node = node.arr[c-'a'];
            node.idxs.remove(idx);
            
        }
        node.isWord = true;
    }
    
    

    public void insertPrefix(String word, int idx){
        TrieNode node = pRoot;
        node.set.add(word);
        node.idxs.add(idx);
        for(char c : word.toCharArray()){
            if(node.arr[c-'a']==null)
                node.arr[c-'a'] = new TrieNode();
            node = node.arr[c-'a'];
            node.set.add(word);
            node.idxs.add(idx);
            
        }
        node.isWord = true;
    }
    
    public void insertSuffix(String word, int idx){
        TrieNode node = sRoot;
         node.set.add(word);
         node.idxs.add(idx);
        for(int i=word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(node.arr[c-'a']==null)
                node.arr[c-'a'] = new TrieNode();
            node = node.arr[c-'a'];
            node.set.add(word);
            node.idxs.add(idx);
        }
        node.isWord = true;
    }

    
    public Set<Integer> searchSuffix(String word){
        TrieNode node = sRoot;
        for(int i=word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(node.arr[c-'a']==null)
                return new HashSet<>();
            node = node.arr[c-'a'];
        }

        return node.idxs;
    }   
        
    public Set<Integer> searchPrefix(String word){
        TrieNode node = pRoot;
        for(char c : word.toCharArray()){
            if(node.arr[c-'a']==null)
                return new HashSet<>();
            node = node.arr[c-'a'];
        }

        return node.idxs;
    }   


}  
    