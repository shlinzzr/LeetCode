// https://leetcode.com/problems/map-sum-pairs

class MapSum {

    class TrieNode {

        TrieNode[] arr ;
        boolean isWord;
        int val;
        public TrieNode(){
            arr = new TrieNode[26];
            val=0;
        }
    }


    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {

        TrieNode curr = root;
        for(char ch : key.toCharArray()){
            if(curr.arr[ch-'a']==null){
                curr.arr[ch-'a'] = new TrieNode();
                
            }
            curr = curr.arr[ch-'a'];
            curr.val += val;
        }
        
    }
    
    public int sum(String prefix) {

        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.arr[ch-'a']==null) return 0;
            curr = curr.arr[ch-'a'];
        }
        return curr.val;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */