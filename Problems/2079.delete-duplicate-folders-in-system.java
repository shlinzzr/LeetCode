// https://leetcode.com/problems/delete-duplicate-folders-in-system


class Solution {
    Folder root = new Folder("");
    Map<String, Integer> cntMap = new HashMap<>();
    
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths){
            addPath(path);
        }
        
        for (Folder f : root.list){
            generateKey(f);
        }

        for(String k : cntMap.keySet()){
            System.out.println(k + " " + cntMap.get(k));
        }
        
        for (Folder f : root.list){
            updateDeleteStatus(f);
        }
        
        List<List<String>> results = new ArrayList<>();
        for (List<String> path : paths){
            if (isValid(path))
                results.add(path);
        }
        
        return results;
    }
    
    private boolean isValid(List<String> path){
        Folder folder = root;
        
        for (String p : path){
            folder = folder.map.get(p);
            if (folder.del)
                return false;
        }
        
        return true;
    }
    
    private void updateDeleteStatus(Folder f){
        if (f.list.size() > 0 && cntMap.get(f.key) > 1){
            f.del = true;
            return;
        }
        
        for (Folder fold : f.list){
            updateDeleteStatus(fold);
        }
    }
    
    private String generateKey(Folder fold){
        StringBuilder sb = new StringBuilder();
        
        if (fold.list.size() == 0)
            return sb.toString();
        
        // sort to order matches
        Collections.sort(fold.list, (a, b) -> a.name.compareTo(b.name));
        
        for (Folder subfolder : fold.list){
            sb.append('(');
            sb.append(subfolder.name + generateKey(subfolder)); //recur
             sb.append(')');
        }

/*
前後括號的差異 階層還是有差
只有前斜線
/c/d/e 2
/d 1
/e 1
/i 2
/h/i/j 2

(c)(d(e)) 1
(d) 1
(e) 1
(i) 2
(h(i))(j) 2
(c(d))(e) 1

*/


        
        String key = sb.toString();
        fold.key = key;
        cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        
        return key;
    }
    
    private void addPath(List<String> path){
        Folder current = root;
        
        for (String f : path){
            if (!current.map.containsKey(f)){
                Folder fold = new Folder(f);
                current.map.put(f, fold);
                current.list.add(fold);
            }
            
            current = current.map.get(f);
        }
    }
}
class Folder{
    String name;
    Map<String, Folder> map;
    List<Folder> list;
    String key;
    boolean del;
    
    Folder(String name){
        this.name = name;
        map = new HashMap<>();
        list = new ArrayList<>();
        key = "";
        del = false;
    }
}