// https://leetcode.com/problems/design-file-system

class FileSystem {

    
//     Map<String, Integer> file = new HashMap<>(); 
    
//     public FileSystem() {
//         file.put("", -1);
//     }
    
    // public boolean createPath(String path, int value) {
    //     int idx = path.lastIndexOf("/");
    //     String parent = path.substring(0, idx);
    //     if (!map.containsKey(parent)) { return false; }
    //     return map.putIfAbsent(path, value) == null;   
    // }
    
//     public int get(String path) {
//         return file.getOrDefault(path, -1);
//     }
    
    
    HashMap<String, Integer> map;
    
    public FileSystem() {
        map = new HashMap<>();
        // map.put("", -1);
        
        // String s = "/la/e/y/rzts/dl";
        // String[] arr = s.split("/");
        // System.out.println("arr[0]="  + arr[0]);
        
        
    }
    
    public boolean createPath(String path, int value) {
        if(path.equals("") || path.equals("/") || path.charAt(0)!='/' || map.containsKey(path))
            return false;
        
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!map.containsKey(parent)) { 
            return false; 
        }
        
        map.put(path, value);
        
        return true;
        
    }
    
    public int get(String path) {
        if(path.equals("") || path.equals("/") || !map.containsKey(path))
            return -1;
        
        return map.get(path);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */