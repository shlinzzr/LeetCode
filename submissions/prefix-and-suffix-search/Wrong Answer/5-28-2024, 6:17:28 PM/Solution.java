// https://leetcode.com/problems/prefix-and-suffix-search

class WordFilter {

    TrieNode preroot, sufroot;
    class TrieNode{

        int idx = -1;
        
        TrieNode[] next = new TrieNode[26];
        boolean isWord =false;
        
        public TrieNode(){
            next = new TrieNode[26];
            isWord = false;
        }
        
    }

    public WordFilter(String[] words) {
        preroot = new TrieNode();
        sufroot = new TrieNode();

        for(int j = 0; j<words.length; j++){
            char[] arr = words[j].toCharArray();
            TrieNode curr = preroot;
            for(int i=0; i<arr.length; i++){
                char ch = arr[i];
                if(curr.next[ch-'a']==null){
                    curr.next[ch-'a']= new TrieNode();
                }
                curr = curr.next[ch-'a'];
            }
            curr.isWord=true;
            curr.idx = j;

            curr = sufroot;
            for(int i=arr.length-1; i>=0; i--){
                char ch = arr[i];
                if(curr.next[ch-'a']==null){
                    curr.next[ch-'a']= new TrieNode();
                }
                curr = curr.next[ch-'a'];
            }
            curr.isWord=true;
            curr.idx = j;
        }
    }
    
    public int f(String pref, String suff) {
        int a = Integer.MAX_VALUE;
        TrieNode curr = preroot;
        for(char ch : pref.toCharArray()){
            if(curr.next[ch-'a']==null){
                a=-1;
                break;
            }
            curr = curr.next[ch-'a'];
        }
        a = curr.idx;

        curr = sufroot;
        char[] arr = suff.toCharArray();

        int b = Integer.MAX_VALUE;
        for(int i=arr.length-1; i>=0; i--){
            char ch = arr[i];
             if(curr.next[ch-'a']==null){
                b=-1;
                break;
            }
            curr = curr.next[ch-'a'];
        }
        b = curr.idx;

        return Math.min(a,b);



        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */