// https://leetcode.com/problems/design-file-system

class FileSystem {

    
    Map<String, Integer> file = new HashMap<>(); 
    
    public FileSystem() {
        file.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!file.containsKey(parent)) { return false; }
        return file.putIfAbsent(path, value) == null;   
    }
    
    public int get(String path) {
        return file.getOrDefault(path, -1);
    }
    
    
//     HashMap<String, Integer> map;
    
//     public FileSystem() {
//         map = new HashMap<>();
//     }
    
//     public boolean createPath(String path, int value) {
//         if(path.equals("") || path.equals("/") || path.charAt(0)!='/' || map.containsKey(path))
//             return false;
        
//         String[] arr = path.split("/");
        
//         String curr = "/";
//         for(int i=1; i<arr.length-1; i++){
//             curr+= arr[i];
//             if(!map.containsKey(curr))
//                 return false;
//         }
//         map.put(path, value);
        
//         return true;
//     }
    
//     public int get(String path) {
//         if(path.equals("") || path.equals("/") || !map.containsKey(path))
//             return -1;
        
//         return map.get(path);
//     }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */