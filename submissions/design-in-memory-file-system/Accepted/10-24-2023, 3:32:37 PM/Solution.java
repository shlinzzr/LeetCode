// https://leetcode.com/problems/design-in-memory-file-system

class FileSystem {
    
    TrieNode root;
    
    class TrieNode{
        TreeMap<String, TrieNode> map;
        String self="";
        boolean isFile;
        String content;
        
        public TrieNode(String self){
            map= new TreeMap<>();
            this.self = self;
            isFile=false;      
            content=null;
        }
    }
    
    
    public FileSystem() {
        root = new TrieNode("/");
        
    }
    
    public List<String> ls(String path) {
        //file , dir in lexicographic order
        
        List<String> res = new ArrayList<>();
        TrieNode node = root;
        
        
        if(!path.equals("/")){
            String[] arr = path.split("/");
            int i=1;
            while(i<arr.length){
                if(node.map.containsKey(arr[i])){
                    node = node.map.get(arr[i]);
                    i++;
                }else{
                    return new ArrayList<>();
                }
            }
        }
        
        if(node.isFile==true){
            res.add(node.self);
        }else{
            for(String k : node.map.keySet()){
                res.add(k);
            }
        }
        
        return res;
    }
    
    public void mkdir(String path) {
        
        String[] arr = path.split("/");
        TrieNode node = root;


        for(int i=1; i<arr.length; i++){
            if(!node.map.containsKey(arr[i])){
                node.map.put(arr[i], new TrieNode(arr[i]));
            }
            node = node.map.get(arr[i]);
        }
        
        
        
    }
    
    public void addContentToFile(String filePath, String content) {
        
        String[] arr = filePath.split("/");
        TrieNode node = root;
        int i=1;
        while(i<arr.length){
            if(!node.map.containsKey(arr[i])){
                node.map.put(arr[i], new TrieNode(arr[i]));
            }
            node = node.map.get(arr[i]);
            i++;
        }
        node.isFile=true;
        node.content= node.content==null? content: node.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        
        String[] arr = filePath.split("/");
        TrieNode node = root;
        int i=1;
        while(i<arr.length){
            if(node.map.containsKey(arr[i])){
                node = node.map.get(arr[i]);
                i++;
            }else{
                return null;
            }
        }
        
        if(node.isFile==false)
            return null;
        
        return node.content;
        
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */