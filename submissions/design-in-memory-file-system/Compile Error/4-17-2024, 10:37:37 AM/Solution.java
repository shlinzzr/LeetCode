// https://leetcode.com/problems/design-in-memory-file-system

class FileSystem {
    TreeMap<String, TreeSet<String>> folders;
    Map<String, String> files; // path, content
    public FileSystem() {
        folders = new TreeMap<>();
        files = new HashMap<>();

        folders.put("/", "/");
    }
    
    public List<String> ls(String path) {

        if(files.contains(path)){ // is file
            List<String> res = new ArrayList<>();


        }

        return new ArrayList<>(folders.getOrDefault(path, new TreeSet<>()));
        
    }
    
    public void mkdir(String path) {

        String[] arr = path.split("/");
        int len = arr.length;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++){
            sb.append("/").append(arr[i]);

            folders.putIfAbsent(sb.toString(), new TreeSet<>());
        }


        folders.putIfAbsent(path, new ArrayList<>());
        
    }
    
    public void addContentToFile(String filePath, String content) {
        
    }
    
    public String readContentFromFile(String filePath) {
        
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