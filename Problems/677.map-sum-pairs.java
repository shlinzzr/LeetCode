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
    Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void remove(String key){
        int val = map.get(key);
        TrieNode curr = root;
        for(char ch : key.toCharArray()){
            curr = curr.arr[ch-'a'];
            curr.val-=val;
        }
        map.remove(key);


    }
    
    public void insert(String key, int val) {

        if(map.containsKey(key)){
            remove(key);
        }

        TrieNode curr = root;
        for(char ch : key.toCharArray()){
            if(curr.arr[ch-'a']==null){
                curr.arr[ch-'a'] = new TrieNode();
                
            }
            curr = curr.arr[ch-'a'];
            curr.val += val;
        }

        map.put(key, val);
        
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